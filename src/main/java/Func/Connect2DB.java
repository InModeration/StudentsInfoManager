package Func;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Connect2DB {
    private static DataSource druidpool = null;
    public static Connection connection = null;

    static {
        DruidDataSourceFactory druidDataSourceFactory = new DruidDataSourceFactory();
        Properties properties = new Properties();
        try {
            properties.load(Connect2DB.class.getResourceAsStream("/dpbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            druidpool = druidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * sub method to query the database
     * @param execute SQL
     * @return query result
     */
    public static ResultSet query(String execute) {
        try {
            connection = druidpool.getConnection();
            Statement statement = connection.createStatement();
            return statement.executeQuery(execute);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * method to modify the database
     * @param execute SQL
     */
    public static void modify(String execute) {
        try {
            Connection connection = druidpool.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(execute);
            // close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
