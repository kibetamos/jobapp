import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "jobObj")
@RequestScoped
public class post {
    String job;
    
    
    DBConnect db = new DBConnect();//db instance
    Connection myCon = db.myConnect(); //db connection instance
    HasherSha1 jk = new HasherSha1(); //hashing class instance
    
    public post(){
}
    
    public String getJob(){
    return job;
 
    }
 public String login() throws SQLException{
         

    Statement statement = myCon.createStatement();
    
    String SQL = "SELECT job FROM job WHERE job = '" + getJob()
            ;

    ResultSet resultSet = statement.executeQuery(SQL);
    while (resultSet.next()) {
        if (getJob().equals(resultSet.getString("job")) ) {
            return "home";
        } 
    }
    return "login.xhtml";
    
 }
        public String saveapplicant() throws SQLException{
          Statement s = null;
         //creates an instance of the DBConnect class
         
         if(myCon!=null){
         System.out.println(myCon);
         s = myCon.createStatement();
        
 String sql = "INSERT INTO signup "
                            + "(fname,lname,gender,address,"
                            + "email,password,age) "
                            + "VALUES ('" 
                            
                            + getJob()+ "') ";
                    s.execute(sql);
                    
     }
    return ".xhtml";
        }
}
  