package net.service.librarijdbcmanageracc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionMysql {

    private final String host;
    private final String userName;
    private final String password;
    private final String nameDB;
    private String url;

    private Connection conection;

    private final Properties properties = new Properties();

    public void initProperties() {

        url = "jdbc:mysql://" + host + "/" + nameDB;

        properties.setProperty("user", userName);
        properties.setProperty("password", password);
        properties.setProperty("characterEncoding", "UTF-8");
        properties.setProperty("useUnocode", "true");
    }

    public ConnectionMysql(String host, String userName, String password, String nameDB) {
        this.host = host;
        this.userName = userName;
        this.password = password;
        this.nameDB = nameDB;
    }

    public void init() {
        if (conection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conection = DriverManager.getConnection(url, properties);
            } catch (ClassNotFoundException ex) {
                System.out.println("Not found driver JDBC");
            } catch (SQLException ex) {

            }
        } else {
            System.out.println("Warning: the database connection is already open");
        }
    }

}
