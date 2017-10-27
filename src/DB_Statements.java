import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Statements {
    /*Her kan man: Create, Update, modify, delete(DDL = data definition language)*/

    //Declaring a statement
    private static Statement stat = null;

    //Declaring a connection
    private static Connection con = DB_Connector.connect();

    //Create new DataBase using method
    public void createNewDB(String DB_Name) {
        //SQL Statement
        String query = "create database if not exists "+DB_Name;

        try {
            //Connection
            stat = con.createStatement();

            //Execute Statement
            stat.executeUpdate(query);
            System.out.println("\n --- Database "+DB_Name+" created--");
        }
        catch (SQLException ex) {
            //Handle SQL exceptions
            System.out.println("\n --- Statement did not execute ---");
            ex.printStackTrace();
        }
    }

    //Method to use a database
    public void useDB(String DB_Name) {
        //statement
        String query = "use" + DB_Name;

        try {
            //connection
            stat = con.createStatement();
            //Execute query
            stat.executeUpdate(query);
            System.out.println("\n --- using" + DB_Name + " DB ---");
        } catch (SQLException ex) {
            //handle sql exceptions (failures)
            System.out.println("\n --- Query did not execute ---");
            ex.printStackTrace();
        }
    }

        /*CREATE TABLE*/
        public void createTable(String tableName){
         //SQL Statement
        String query = "create table if not EXISTS "+tableName+ "("+ "id int not null auto_increment, " +" myName varchar(28),  "+"address varchar(28), " +"primary key(id)"+ ")";

        try {
            //connection
            stat = con.createStatement();
            //Execute query
            stat.executeUpdate(query);
            System.out.println("\n --- Table " + tableName + " created ---");
        }
        catch (SQLException ex){
            //Handle SQL statement
            System.out.println("\n --- Query did not execute ---");
            ex.printStackTrace();
        }
    }

    
}
