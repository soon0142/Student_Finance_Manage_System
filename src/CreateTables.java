import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
	
	/**
     * Create a new table in the test database
     *
     */
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:/home/cloudera/workspace/Paraguay1/Paraguay.db";
    	//final String url="jdbc:sqlite:Paraguay.db";
        
        // SQL statement for creating a new table
        /*String sql = "CREATE TABLE IF NOT EXISTS login (\n"
                + "	loginID integer PRIMARY KEY,\n"
                + "	loginName text NOT NULL,\n"
                + "	passwd text not null\n"
                + ");"; */
       /* 
        String sql = "CREATE TABLE IF NOT EXISTS student (\n"
                + "	StudentID integer PRIMARY KEY,\n"
                + "	StudentName text NOT NULL,\n"
                + " StudentPhone text,\n"
                + " StudentEmail text,\n"
                + " Grade integer,\n"
                + " DOB text,\n"
                + " Address text,\n"
                + " Hobby text, \n"
                + " StudentPhoto longblob, \n"
                + " Gender text, \n"
                + " EntMoveinMoveout text, \n"
                + " EntInOutDate text, \n"
                + " MomName text, \n"
                + " MomPhone text, \n"
                + " MomEmail text, \n"
                + " DadName text, \n"
                + " DadPhone text, \n"
                + " DadEmail text, \n"
                + " Faith text, \n"
                + " Baptizement, \n"
                + " AwardPunish, \n"
                + "	AwardPunContent text\n"
                + ");"; */
                
        
        String sql = "CREATE TABLE IF NOT EXISTS finance (\n"
                + "	PaymentID integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	PaymentYear integer,\n"
                + " PaymentMonth integer,\n"
                + " MonthlyTuition integer,\n"
                + " CostOfBooks integer,\n"
                + " T1 text,\n"
                + " T1Cost integer,\n"
                + " T2 text, \n"
                + " T2Cost integer, \n"
                + " T3 text, \n"
                + " T3Cost integer, \n"
                + " T4 text, \n"
                + " T4Cost integer, \n"
                + " T5 text, \n"
                + " T5Cost integer, \n"
                + " T6 text, \n"
                + " T6Cost integer, \n"
                + " T7 text, \n"
                + " T7Cost integer, \n"
                + " T8 text, \n"
                + " T8Cost integer, \n"
                + " T9 text, \n"
                + " T9Cost integer, \n"
                + " TotalCost integer, \n"
                + " Scholarship text, \n"
                + " StudentID integer, \n"
                + "	StudentName text NOT NULL, \n"
                + " FOREIGN KEY(StudentID) REFERENCES student(StudentID) \n"
                + ");"; 
        
        /*try {
			Class.forName("org.sqlite.JDBC").newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    } 
 
    /**
     * @param args the command line arguments
     */

	public static void main(String[] args) {
		createNewTable();
	}

}
