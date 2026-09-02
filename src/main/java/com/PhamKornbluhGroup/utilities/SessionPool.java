package com.PhamKornbluhGroup.utilities;

import com.PhamKornbluhGroup.SecretsHelper;
import com.zaxxer.hikari.HikariConfig;
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

/**
 * <h3> Description: </h3>
 * <ul>
 *     <li> SessionPool's purpose is to open instances of {@link SqlSession} to the POE Oracle DB in a thread-safe way. </li>
 * </ul>
 *
 * @apiNote Settings are configured in resource file {@value #MYBATIS_URI}. In that file, the "dataSource
 * type" is set to {@link HikariDataSourceFactory}, where more configuration like {@link HikariConfig#setMaximumPoolSize} takes place
 */
public class SessionPool {
    private final static Logger sessionPoolLogger = LogManager.getLogger(SessionPool.class);
    private static final String MYBATIS_URI = "mybatisconfig.xml";
    private static volatile SqlSessionFactory factory = null;

    private SessionPool() {
    }


    /**
     * <h3> Description: </h3>
     * <ul>
     *     <li> This will run when factory is null, the first time a user calls one of the getSession methods. </li>
     * </ul>
     *
     * <h3> Implementation: </h3>
     * <ul>
     *     <li> Credentials (User/Pass/Driver/URL) comes from {@link SecretsHelper#getDBInformation()}.</li>
     *     <li> SessionPool Config comes from resource file {@value #MYBATIS_URI}, which links to
     *     {@link HikariDataSourceFactory} through the "dataSource type" setting </li>
     * </ul>
     *
     * @apiNote Since buildFactory is synchronized, "factory == null" should still be checked before calling this
     * method, for increased efficiency
     */
    private static synchronized void buildFactory() {
        if (factory != null) {
            return;
        }
        Properties databaseSecrets = SecretsHelper.getDBInformation();
        sessionPoolLogger.trace("Setting reader in SessionPool");
        try (Reader reader = Resources.getResourceAsReader(MYBATIS_URI)) {
            sessionPoolLogger.trace("Setting factory in SessionPool");
            factory = new SqlSessionFactoryBuilder().build(reader, databaseSecrets);
        }
        catch (IOException e) {
            sessionPoolLogger.error("IOException in SessionPool.buildFactory. Message: " + e.getMessage());
            throw new RuntimeException("Failed to initialize MyBatis SqlSessionFactory", e);

        }
    }

    /**
     * <h3>Implementation:</h3>
     * <ul>
     *     <li> Lazily initialize static field {@link #factory} via {@link #buildFactory()}, if not done yet </li>
     *     <li> Open a new {@link SqlSession} connected to the POE Oracle DB. </li>
     *     <li> This uses the default (non-batched) {@link ExecutorType}, intended for {@code SELECT} queries </li>
     * </ul>
     *
     * @return A new {@link SqlSession} connected to the POE Oracle DB
     *
     * @apiNote The returned session is not closed automatically. Callers are responsible
     * for closing it, typically via try-with-resources.
     */
    public static SqlSession getSession() {
        if (factory == null) {
            buildFactory();
        }
        sessionPoolLogger.trace("Setting session in getSession");
        return factory.openSession();
    }

    /**
     * <h3>Implementation:</h3>
     * <ul>
     *     <li> Lazily initialize static field {@link #factory} via {@link #buildFactory()}, if not done yet </li>
     *     <li> Open a new {@link SqlSession} connected to the POE Oracle DB </li>
     *     <li> This session uses the {@link ExecutorType#BATCH} config, intended for bulk {@code INSERT}, {@code UPDATE},
     *     or {@code DELETE} operations </li>
     * </ul>
     *
     * @return A new batched {@link SqlSession} connected to the POE Oracle DB
     *
     * @apiNote
     *     <ul>
     *         <li> The returned session is not closed automatically. Callers are responsible for closing it,
     *         typically via try-with-resources </li>
     *         <li> Batched statements are not sent to the database until {@link SqlSession#commit()} or
     *         {@link SqlSession#flushStatements()} is called </li>
     *     </ul>
     */
    public static SqlSession getBatchedSession() {
        if (factory == null) {
            buildFactory();
        }
        sessionPoolLogger.trace("Setting session in getBatchedSession");
        return factory.openSession(ExecutorType.BATCH);
    }
}
