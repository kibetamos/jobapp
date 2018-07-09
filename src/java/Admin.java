

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
 
@ManagedBean(name="AdminObj")
@SessionScoped
public final class Admin implements Serializable{
    
    DBConnect db = new DBConnect();//db instance
    Connection myCon = db.myConnect(); //db connection instance
    String age;
    String fname;
    String lname;
    String gender;
    String phone;
    String email;
    String address;
    int id;

    
    
	
	private static final long serialVersionUID = 1L;
	
	public static Map<String,String> user_details;
        
        
	
	private String user; //default value 
	
	

	public void userChanged(ValueChangeEvent e){
		//assign new value to localeCode
		user= e.getNewValue().toString();
		
	}

	public Map<String,String> getUserInMap() {
            get_user_list();
		return this.user_details;
               
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        String[] token = user.split(";");
        this.age = token[6];
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
         String[] token = user.split(";");
        this.fname = token[1];
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
         String[] token = user.split(";");
        this.lname = token[2];
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
         String[] token = user.split(";");
        this.gender = token[3];
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
         String[] token = user.split(";");
        this.phone = token[4];
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
         String[] token = user.split(";");
        this.email = token[5];
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
         String[] token = user.split(";");
        this.address = token[7];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        String[] token = user.split(";");
        this.id = Integer.valueOf(token[0]);
    }
    
    
        
        
        
        
        public void get_user_list(){
 	try {
 	 	Connection connection=null;
 	 	connection=myCon;
                user_details = new LinkedHashMap<>();
 	 	Statement ps=connection.createStatement();
                
 	 	String sql="select distinct * from user order by fname asc";
                
 	 	ResultSet rs=ps.executeQuery(sql);
 	 	while(rs.next()){
              
		
		user_details.put(rs.getString("fname")+" "+rs.getString("lname"), (rs.getString("id")
                        +";"+rs.getString("fname")+";"+rs.getString("lname")+";"+rs.getString("gender")
                        +";"+rs.getString("phone")
                        +";"+rs.getString("email")
                        +";"+rs.getString("age")
                        +";"+rs.getString("address"))); //label, value
		
	}
                
 	} catch (SQLException e) {
 	 	 System.out.println(e);
 	}
 	
 	}
        public String Edit(){
            return "Admin";
        }
        public String Delete(){
            return "Admin";
        }


}