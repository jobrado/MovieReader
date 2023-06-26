/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

/**
 *
 * @author Jo
 */

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javax.sql.DataSource;

public class DataSourceSingleton {

    private static final String SERVER = "localhost";
    private static final String DB = "MovieEditorJavaProject";
    private static final String USER = "sa";
    private static final String PASS = "sql";

    private DataSourceSingleton() {
    }
    private static DataSource instance;

    public static DataSource getInstance() {
        if (instance == null) {
            instance = createInstance();
        }
        return instance;
    }

    private static DataSource createInstance() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName(SERVER);
        dataSource.setDatabaseName(DB);
        dataSource.setUser(USER);
        dataSource.setPassword(PASS);

        return dataSource;
    }

}
