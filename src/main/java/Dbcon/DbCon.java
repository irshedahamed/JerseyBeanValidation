/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author irshed-pt2884
 */
public class DbCon {

    static final Map<String, Connection> connectionPool;
  
    static {
        connectionPool = new HashMap<String, Connection>();
    }


    public static Connection getConnection(String dbname) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Connection conn = connectionPool.get(dbname);
        if (conn == null || conn.isClosed()) {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname, "root", "1234");
            connectionPool.put(dbname , conn);
        }

        return conn;
    }
}
