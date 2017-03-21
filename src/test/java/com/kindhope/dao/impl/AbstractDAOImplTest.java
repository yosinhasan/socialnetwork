package com.kindhope.dao.impl;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.cfg.Environment;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Properties;

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
        while(rs.next()) {
            System.out.println("Table =>>>>>>>>> " + rs.getString(3));
        }
        DatabaseOperation.CLEAN_INSERT.execute(dbConn, getDataSet());
    }

    protected abstract IDataSet getDataSet() throws Exception;

}
