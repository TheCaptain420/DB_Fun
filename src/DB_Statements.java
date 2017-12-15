import java.sql.*;

public class DB_Statements {
    /*Her kan man: Create, Update, modify, delete(DDL = data definition language)*/

    //Declaring a statement
    private static Statement stat = null;

    //Declaring a connection
    private static Connection con = DB_Connector.connect();

    //Declare a result set
    private static ResultSet rs = null;

    //Declare a PreparedStatement
    private static PreparedStatement pst = null;



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
            //Handle SQL exceptions(ikke kender statement, ikke connected, )
            System.out.println("\n --- Statement did not execute ---");
            ex.printStackTrace();
        }
    }

    //Method to use a database
    public void useDB(String DB_Name) {
        //statement
        String query = "use " + DB_Name;

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

    //Method to insert data
    public void  insertData(String tableName){
        //SQL query
        String query = "insert into "+tableName+" ("+
                "myName, address) "+
                "values ('Douglas', 'My address'), "+
                "('Bub ', 'His address'), " + //Man skal altid have 4 chars
                "('REEEE', 'RES address')";
        try {
            //Connection
            stat = con.createStatement();
            //execute
            stat.executeUpdate(query);
            System.out.println("\n --- Data inserted into table: " + tableName + " ---");

        }
        catch (SQLException ex){
            System.out.println("\n --- Data could not be inserted "+tableName+ " ---");
            ex.printStackTrace();
        }
    }
    /*method to read/show data from table*/
    public void selectFromTable(String tableName){
        //SQL query
        String query = "select * from "+tableName;
        //
        try{
            //connection
            stat = con.createStatement();
            //execute
            rs = stat.executeQuery(query);
            //"build a table"
            System.out.println("\nid\t\tmyName\t\taddress\n________________________________");
            //get data
            while (rs.next()){
                int id = rs.getInt(1);//returns the id / first collumn
                String myName = rs.getString("myName");//returns the myName
                String address = rs.getString("address"); // returns the address
                System.out.println(id+"\t\t"+myName+"\t\t"+address);

            }

        }
        catch(SQLException ex){
            System.out.println("\n --- query didnt execute ---");
            ex.printStackTrace();
        }
    }
    //Method to check for user credientials
    public Boolean checkLogin(String username, String password){
        boolean check = false;

        // SQL statement
        String query = "select * from thisdatabase.user where username = (?) and password =(?)";

        try{
            //stat = con.createStatement();
            pst = con.prepareStatement(query);
            //rs = stat.executeQuery(query);
            pst.setString(1,username);//Henter username fra pst
            pst.setString(2,password);
            rs = pst.executeQuery();
            //Checker om info er "true", altså password/username
            while(rs.next()){
                check = true;
                System.out.println("\n --- It works ---");
            }

        }catch (SQLException e) {
            System.out.println("\n --- Darn!! ---");
            e.printStackTrace();
        }
        return check;
    }


}
