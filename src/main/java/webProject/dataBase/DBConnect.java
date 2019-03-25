package webProject.dataBase;

import java.sql.*;

public class DBConnect implements AutoCloseable{
    Connection con;

    private static final String URL = "jdbc:mysql://msql:3306/home?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    private static final String USER = "readUser";
    private static final String PASSWORD = "0UZnolAo";

    /*private static final String URL = "jdbc:mysql://serggrw.ddns.net:53306/home?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    private static final String USER = "readUser";
    private static final String PASSWORD = "0UZnolAo";*/

    DBConnect() throws SQLException {
        //Creating connection to database.
        con = DriverManager.getConnection(URL, USER, PASSWORD);
    }
    DBConnect(String user, String password) throws SQLException {
        //Creating connection to database.
        con = DriverManager.getConnection(URL, user, password);
    }

    @Override
    public void close() throws SQLException {
        con.close();
    }
}
