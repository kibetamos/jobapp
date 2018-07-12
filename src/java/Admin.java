

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
    String  phone;
    String email;
    String address;
    String id;

    
    
	
	private static final long serialVersionUID = 1L;
	
	public static Map<String,String>  applicant_details;
        
        
	
	private String applicant; //default value 
    private Map<String, String> applicant_detail;
	
	

	public void applicantChanged(ValueChangeEvent e){
		//assign new value to localeCode
		applicant= e.getNewValue().toString();
		
	}

	public Map<String,String> getUserInMap() {
            get_user_list();
		return this.applicant_details;
               
	}

	public String getappplicant() {
		return applicant;
	}

	public void setUser(String user) {
		this.applicant = user;
	}

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        String[] token = applicant.split(";");
        this.age = token[6];
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
         String[] token = applicant.split(";");
        this.fname = token[1];
    }

    public String getLname() {    
            return lname;
    }

    public void setLname(String lname) {
         String[] token = applicant.split(";");
        this.lname = token[2];
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
         String[] token = applicant.split(";");
        this.gender = token[3];
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
         String[] token = applicant.split(";");
        this.phone=token[4];
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
         String[] token = applicant.split(";");
        this.email = token[5];
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
         String[] token = applicant.split(";");
        this.address = token[7];
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        String[] token = applicant.split(";");
        this.id = String.valueOf(token[0]);
    }
    
    
        
        
        
        
        public void get_user_list(){
 	try {
 	 	Connection connection=null;
 	 	connection=myCon;
                applicant_details = new LinkedHashMap<>();
 	 	Statement ps=connection.createStatement();
                
 	 	String sql="select distinct * from user order by fname asc";
                
 	 	ResultSet rs=ps.executeQuery(sql);
 	 	while(rs.next()){
              
		
		applicant_details.put(rs.getString("fname")+" "+rs.getString("lname"), (rs.getString("id")
                        +";"+rs.getString("fname")+";"+rs.getString("lname")+";"+rs.getString("gender")
                        +";"+rs.getString("phone")
                        +";"+rs.getString("email")
                        +";"+rs.getString("age")
                        +";"+rs.getString("address"))); //label, value
		
	}
                
 	} catch (SQLException e) {
 	 	 System.out.println(e);
 	}}}
 	
