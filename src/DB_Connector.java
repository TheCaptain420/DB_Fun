import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {
    //JDBC = Java DataBase Connector

    //Declare a connection
    private static Connection con = null;

    // JDBC Driver
    private static final String DRIVER= "com.mysql.jdbc.Driver";

    // The URL  = jdbc:dbms://host name: port#/database name
    //private  static String url = "jdbc:mysql://localhost:3306/madsnielsenforste"; // Den her connector til "gammel" DB
    private  static String url = "jdbc:mysql://localhost:3306/";

    //user name på mysql workbench
    private static String usr = "root";

    //password på mysql workbench
    private static String pswrd = "mads123";


    public static Connection connect(){

        System.out.println("\n ---Connecting to the MySQL JDBC---");
        // Locate MySQL JDBC Driver

        try{
            Class.forName(DRIVER);
        }
        // Catch exceptions if JDBC is not found
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
            System.out.println("\n ---JDBC driver is missing---");

        }
        System.out.println("\n ---MySQL JDBC driver registered---");

        // Connect to MySQL DataBase = URL + username + password
        try {
            con = DriverManager.getConnection(url, usr, pswrd);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("\n ---Did not connect, try again---");
        }
        // if connecting is successful
        if (con != null){
            System.out.println("\n ---Connection successful---");
        }
        else {
            // If connection fails
            System.out.println("\n ---You failed to connect---");
        }

        return con;
    }








    // Catch exceptions on Connection error



}
