import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "forgotObj")
@RequestScoped

public class forgot {
    
   String password;
   String fname;
   String lname;
    
     DBConnect db = new DBConnect();//db instance
    Connection myCon = db.myConnect(); //db connection instance
    HasherSha1 jk = new HasherSha1(); //hashing class instance
    private String CPassword;
    
 public forgot(){
    
    
}
     public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
 public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCPassword() {
        return CPassword;
    }

    public void setCPassword(String CPassword) {
        this.CPassword = CPassword;
    }
    public void clear(){
      

}
public String forgot() throws SQLException{
         

    Statement statement = myCon.createStatement();
    
    String SQL = "SELECT password FROM forgot WHERE  password = '" + jk.encryptPassword(getPassword()) + "';";

    ResultSet resultSet = statement.executeQuery(SQL);
    while (resultSet.next()) {
        if (getpassword().equals(resultSet.getString("password")) && jk.encryptPassword(getPassword()).equals(resultSet.getString("password"))) {
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
        
 String sql = "INSERT INTO forgot "
                            + "(fname,lname,"
                            + "password,) "
                            + "VALUES ('" + getFname() + "','"
                            + getLname() + "','"
                            
                            + jk.encryptPassword(getCPassword())+ "') ";
                    s.execute(sql);
                    clear();
     }
    return "login.xhtml";
        }

    private Object getpassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    