package model;

import controller.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramayana Júnior
 */
public class Usuario implements Cloneable {
    String firstName, lastName, username, password, email;   
    
    @Override
    public String toString() {
        return "Usuario{" + "firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password=" + password + ", email=" + email + ", country=" + country + ", city=" + city + ", address=" + address + ", permission=" + permission + ", occupation=" + occupation + ", ID=" + ID + '}';
    }   
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }   

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getPassword() {
        return password;
    }

    public String getPermission() {
        return permission;
    }

    public String getUsername() {
        return username;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Usuario clone = (Usuario) super.clone();
        clone.address = new String(address);        
        clone.city = new String(city);        
        //clone.address = (String) address.clone();
        return clone;
    }
    
    String country, city, address;
    String permission, occupation;
    int ID;

    public Usuario(String firstName, String lastName, String username, 
            String password, String email,
            String country, String city, String address, 
            String permission, String occupation, int ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;        
        this.country = country;
        this.city = city;
        this.address = address;
        this.permission = permission;
        this.occupation = occupation;   
        this.ID = ID;
    }

    public Usuario() {
    }
    
    public static void InsertUser(Usuario us){
        String sql = null;
    	
    	sql = "INSERT INTO user (userid,firstname,lastname,username,password, "
                + "email, country, city, address, permission, occupation) "
                + "VALUES(NULL, '"+ us.getFirstName()+"', '"+ us.getLastName()+"', '"
                + us.getUsername()+"', '"+us.getPassword()+"', '"+us.getEmail()+"', '"
                + us.getCountry()+"', '"+us.getCity()+"', '"+us.getAddress()+"', '"
                + us.getPermission()+"', '"+us.getOccupation()+"' )";
        
        controller.Database db = new Database();
        if( db.connect()) {
            db.QueryObject(sql);
        }
        db.desconnect();
    }
    
    public static Usuario[] SelectUsers(){
        controller.Database db = new Database();
        Usuario[] ret = new Usuario[1000];
        //List<Usuario> lst = List<Usuario>;
        //lst.clear();
        if( db.connect()) {
            ResultSet rs = null;                        
            try{    
                rs = db.query_res("SELECT * FROM user");                
                int c=0;               
                while( rs.next() )
                {  
                  Usuario u = new Usuario(rs.getString("firstname"), 
                          rs.getString("lastname"), rs.getString("username"), 
                          rs.getString("password"), rs.getString("email"), 
                          rs.getString("country"), rs.getString("city"), 
                          rs.getString("address"), rs.getString("permission"), 
                          rs.getString("occupation"), rs.getInt("userid") );
                  try{                      
                  //lst.add(c, u);    
                  ret[c] = (Usuario) u.clone();
                  }catch(CloneNotSupportedException clone_err){
                      clone_err.printStackTrace();
                  }
                  ++c;
                }                  
            }catch(SQLException err){
                err.printStackTrace();
                return null;
            }
        }        
        db.desconnect();
        return ret;                    
    }
    
    public static void AlterUser(Usuario us, int jtext_userid){
        String sql = null;
    	
    	sql = "UPDATE `gcei`.`user` SET `userid`="+us.getID()+", `firstname`='"+ us.getFirstName()+"', "
                + "`lastname`='"+ us.getLastName()+"', `username`='"+ us.getUsername()+"', `password`='"+us.getPassword()+"', "
                + "`email`='"+us.getEmail()+"', `country`='"+ us.getCountry()+"', `city`='"+us.getCity()+"', "
                + "`address`='"+us.getAddress()+"', `permission`='"+ us.getPermission()+"', "
                + "`occupation`='"+us.getOccupation()+"' WHERE `userid`='"+jtext_userid+"'";
                
        controller.Database db = new Database();
        if( db.connect()) {
            db.QueryObject(sql);
        }
        db.desconnect();
    }
    
    public static void DeleteUser(int jtext_userid){
        String sql = null;
    	
    	sql = "DELETE FROM `gcei`.`user` WHERE `userid`='"+jtext_userid+"'";                
                
        controller.Database db = new Database();
        if( db.connect()) {
            db.QueryObject(sql);
        }
        db.desconnect();
    }
       
}
