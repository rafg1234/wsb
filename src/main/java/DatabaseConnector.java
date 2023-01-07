import org.apache.tomcat.jdbc.pool.interceptor.StatementCacheMBean;

import java.sql.*;

public class DatabaseConnector {
    public static final String HOST = "jdbc:postgresql://rogue.db.elephantsql.com/";
    public static final String DATABASE = "hovqgozf";
    public static final String USERNAME = "hovqgozf";
    public static final String pass = "tg_tbq0XBSEBpl9rm_eQbormxrZFZaof";

    public Connection connection;
    public void connect(){
        try {
            Class.forName("org.postgresql.Driver");
            //c = DriverManager.getConnection()
            this.connection = DriverManager.getConnection(HOST + DATABASE, USERNAME, pass);
            System.out.println("Opened database succesfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Dupa");
        }
    }

    public void executeInsert(String sql) throws SQLException {
        Statement stm = this.connection.createStatement();
        stm.execute(sql);
    }

    public ResultSet executeSelect(String sql) throws SQLException {
        Statement stm = this.connection.createStatement();
        return stm.executeQuery(sql);
    }
}
