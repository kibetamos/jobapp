import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "signupObj")
@RequestScoped
public class signup {
    String fname;
    String lname;
    int age;
    String gender;
     String address;
    String email;
    String password;
    String CPassword;
    
    /*We declare and initiliaze global data members that we will be using in our
    interactions with the DB*/
    DBConnect db = new DBConnect();//db instance
    Connection myCon = db.myConnect(); //db connection instance
    HasherSha1 jk = new HasherSha1(); //hashing class instance
    
    public signup(){
        
    
}

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age =  age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        setFname(null);
         setLname(null);
        setAge(0);
        setGender(null);
        setAddress(null);
        setEmail(null);
        setPassword(null);
        setCPassword(null);
    }
    
 public String login() throws SQLException{
         

    Statement statement = myCon.createStatement();
    
    String SQL = "SELECT email, password FROM signup WHERE email = '" + getEmail()
            + "' AND password = '" + jk.encryptPassword(getPassword()) + "';";

    ResultSet resultSet = statement.executeQuery(SQL);
    while (resultSet.next()) {
        if (getEmail().equals(resultSet.getString("email")) && jk.encryptPassword(getPassword()).equals(resultSet.getString("password"))) {
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
                            + "VALUES ('" + getFname() + "','"
                            + getLname() + "','"
                            + getGender()+ "'" + ",'"
                            + getAddress()+ "','"
                            + getEmail()+ "','"
                            + jk.encryptPassword(getCPassword())+ "','"
                            + getAge()+ "') ";
                    s.execute(sql);
                    clear();
     }
    return "login.xhtml";
        }
}
    