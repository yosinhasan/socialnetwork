package com.kindhope.dao.impl;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appconfig-root-test.xml"})
public abstract class AbstractDAOImplTest {

    @Autowired
    protected DataSource dataSource;

    @Before
    public void setUp() throws Exception {
        IDatabaseConnection dbConn = new DatabaseDataSourceConnection(dataSource);
        DatabaseConfig config = dbConn.getConfig();
        System.out.println("CATALOG: =========" + dbConn.getConnection().getCatalog());
        config.setProperty(DatabaseConfig.FEATURE_CASE_SENSITIVE_TABLE_NAMES, Boolean.TRUE);
        config.setProperty(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, Boolean.TRUE);
        DatabaseMetaData metaData = this.dataSource.getConnection().getMetaData();
        ResultSet rs = metaData.getTables(null, null, "%", null);
        while (rs.next()) {
            System.out.println("Table =>>>>>>>>> " + rs.getString(3));
        }
        DatabaseOperation.CLEAN_INSERT.execute(dbConn, getDataSet());
    }

    @After
    public void tearDown() throws Exception {
        try (Statement statement = dataSource.getConnection().createStatement()) {
            statement.executeUpdate("DELETE  FROM kindhope.blacklist");
            statement.executeUpdate("DELETE  FROM kindhope.comment_photo");
            statement.executeUpdate("DELETE  FROM kindhope.comment_post");
            statement.executeUpdate("DELETE  FROM kindhope.connection");
            statement.executeUpdate("DELETE  FROM kindhope.connection_request");
            statement.executeUpdate("DELETE  FROM kindhope.gallery_photo");
            statement.executeUpdate("DELETE  FROM kindhope.deleted_conversation");
            statement.executeUpdate("DELETE  FROM kindhope.group_member");
            statement.executeUpdate("DELETE  FROM kindhope.group_post");
            statement.executeUpdate("DELETE  FROM kindhope.like_photo");
            statement.executeUpdate("DELETE  FROM kindhope.like_post");
            statement.executeUpdate("DELETE  FROM kindhope.user_role");
            statement.executeUpdate("DELETE  FROM kindhope.conversation");
            statement.executeUpdate("DELETE  FROM kindhope.comment");
            statement.executeUpdate("DELETE  FROM kindhope.message");
            statement.executeUpdate("DELETE  FROM kindhope.photo");
            statement.executeUpdate("DELETE  FROM kindhope.gallery");
            statement.executeUpdate("DELETE  FROM kindhope.post");
            statement.executeUpdate("DELETE  FROM kindhope.role");
            statement.executeUpdate("DELETE  FROM kindhope.usergroup");
            statement.executeUpdate("DELETE  FROM kindhope.user");
        } catch (Throwable e) {
            System.out.println("Error occured");
        }
    }

    protected abstract IDataSet getDataSet() throws Exception;

}
