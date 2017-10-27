import java.sql.Connection;

public class Test_DB {
    public static void main(String[] args) {

        //DB_Connector k = new DB_Connector();
        //DB_Connector.connect();
        DB_Statements ree = new DB_Statements();
        ree.createNewDB();
    }
}
