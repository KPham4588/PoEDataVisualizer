package com.PhamKornbluhGroup.utilities;

import com.PhamKornbluhGroup.SecretsHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class SessionPool {
    private final static Logger sessionPoolLogger = LogManager.getLogger(SessionPool.class);

    private static final String MYBATIS_URI = "mybatisconfig.xml";

    private static SqlSessionFactory factory;
    private static Reader reader;
    private static SqlSession session;

    private SessionPool() {
    }

    public static SqlSession getSession() {
        if (session != null) {
            sessionPoolLogger.trace("Returning a copy of already-created SqlSession at SessionPool.getSession");
            return session;
        }
        Properties databaseSecrets = SecretsHelper.getDBInformation();
        // Session never gets closed

        /* TODO: UPDATE -- Since we're using the Singleton, we should check to see if session has already been initialized
         * If it has, we should return the pre-existing object, not overwrite it with a new one */

        //r SESSION MUST BE CLOSED BY THE CALLER DOWNSTREAM
        // Other Notes:    Update / Make sure not to create extra unneeded builders
        try {
            sessionPoolLogger.trace("Setting reader in SessionPool");
            reader = Resources.getResourceAsReader(MYBATIS_URI);

            sessionPoolLogger.trace("Setting factory in SessionPool");
            factory = new SqlSessionFactoryBuilder().build(reader, databaseSecrets);

            //r SESSION MUST BE CLOSED BY THE CALLER DOWNSTREAM
            sessionPoolLogger.trace("Setting session in SessionPool");
            session = factory.openSession(ExecutorType.BATCH);
            return session;
        }
        catch (IOException e) {
            sessionPoolLogger.error("IOException in SessionPool.getSession. Message: " + e.getMessage());
        }
        finally {
            close(reader);
        }
        return session;

    }

    public static void close(AutoCloseable resource) {
        if (resource != null) {
            try {
                resource.close();
            }
            // TODO: Add a better multi-catch and implement logging
            catch (Exception e) {
                sessionPoolLogger.error("Exception in SessionPool.getSession. Message: " + e.getMessage());
                System.out.println("could not close the sql session " + e.getMessage());
            }
        }
    }
}
