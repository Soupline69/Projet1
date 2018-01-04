package myconnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.PropertyResourceBundle;

public class DBConnection {
    private static DBConnection instance = null;
    protected String serverName;
    protected String username;
    protected String password;
    protected String dbName;
    protected String dbPort;
    
    public static DBConnection getInstance() {
        if(instance == null) {
        	instance = new DBConnection();
        }
        
        return instance;
    } 
 
    private DBConnection() {
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

        PropertyResourceBundle properties = (PropertyResourceBundle)
        PropertyResourceBundle.getBundle("db.application");
        serverName = properties.getString("server");
        dbName = properties.getString("database");
        username = properties.getString("login");
        password = properties.getString("password");
        dbPort = properties.getString("port");    
    }

    public Connection getConnection() {
       try {
           return DriverManager.getConnection("jdbc:mysql://"+serverName+":"+dbPort+"/"+dbName+"?verifyServerCertificate=false&useSSL=true", username, password); 
       } catch(Exception e) {
           e.printStackTrace();
       }
       
       return null;
   }
    
}