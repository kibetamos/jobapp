import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ALAKA
 */
public class DBConnect {
    
    
    public DBConnect(){
            }
    
     public Connection myConnect(){
      Connection connect = null;
    
    try {
                    Class.forName("com.mysql.jdbc.Driver");

                    connect = DriverManager.getConnection(""
                            + "jdbc:mysql://localhost/jobsearch"
                            + "?user=root&password=");
    
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Cannot connect to Property DB"+e.getMessage());
        }
            return connect;
                
     }
     
     public static void main(String args[]){
         DBConnect mycon = new DBConnect();
         mycon.myConnect();
     }
}