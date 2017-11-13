/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.service.librarijdbcmanageracc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andrey
 */
public class Connector {

    private static final String URL = "jdbc:mysql://localhost:3306/managerAcc?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "andrey123ariman";
    
    private static Connection con;

    public static Connection getConnect() throws SQLException{
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Not found driver JDBC");
        }
        return con;
    }
}
