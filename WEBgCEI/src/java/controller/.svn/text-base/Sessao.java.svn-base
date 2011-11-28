/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author reisneto
 */
public class Sessao extends Usuario{    
     private static Sessao instance;     
     
     private Sessao(){}
     
     public void Dispose(){
        instance = null;
     }

     public static Sessao getInstance(){
         if(instance==null){
             instance = new Sessao();
         }
         return instance;
     }
     
     public static int loginUser(String username,String password){
         int result = 0;
         controller.Database db = new Database();
        String sql = "Select * FROM `gcei`.`user` WHERE `username`='"+username+
                "' and password='"+password+"'";
        if(db.connect()){
            ResultSet rs = null;
            rs=db.query_res(sql);
            try {
                while(rs.next()){//nessa parte deve verificar se o usuario existe                                            
                              Sessao.getInstance().loadUser(rs);
                              result=1;
                          }
            } catch (SQLException ex) {
                Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
     
    private void loadUser(ResultSet rs) throws SQLException{
       Sessao.getInstance().setID(rs.getInt("userid"));
       Sessao.getInstance().setFirstName(rs.getString("firstname"));
       Sessao.getInstance().setLastName(rs.getString("lastname"));
       Sessao.getInstance().setUsername(rs.getString("username"));
       Sessao.getInstance().setPassword(rs.getString("password"));
       Sessao.getInstance().setEmail(rs.getString("email"));
       Sessao.getInstance().setCountry(rs.getString("country"));
       Sessao.getInstance().setCity(rs.getString("city"));
       Sessao.getInstance().setAddress(rs.getString("address"));
       Sessao.getInstance().setPermission(rs.getString("permission"));
       Sessao.getInstance().setOccupation(rs.getString("occupation"));
    }
        
}
