package com.PhamKornbluhGroup.utilities;

import com.PhamKornbluhGroup.SecretsHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class SessionPool {
    private static final String MYBATIS_URI = "mybatisconfig.xml";

    private static SqlSessionFactory factory;
    private static Reader reader;
    private static SqlSession session;

    private SessionPool() {
    }

    public static SqlSession getSession() {
        // TODO: FIX THIS AND IMPLEMENT
        Properties databaseSecrets = SecretsHelper.getDBInformation();

        // Update / Make sure not to create extra unneeded builders
        try {
            reader = Resources.getResourceAsReader(MYBATIS_URI);
            factory = new SqlSessionFactoryBuilder().build(reader, databaseSecrets);
            session = factory.openSession();
            return session;
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
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
            catch (NullPointerException | IOException e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
