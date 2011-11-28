package controller;

import java.io.File;
import java.lang.reflect.Field;
import model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Evento;
import model.Usuario;

public class Database extends Thread{
	Connection con;
	Statement stmt;
	PreparedStatement ppstmt;
	ResultSet rs;
    String bdUser;
    String bdPassword;
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/gcei";

    @Override
    public void run() {        
    }        
    
    public boolean connect(){
    	boolean result=true;
        Config cfg = new Config();
        bdUser = cfg.user;
        bdPassword = cfg.password;       
    	try {
            try {
                    Class.forName(DRIVER);
                } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                con = (Connection) DriverManager.getConnection(URL, bdUser, bdPassword);			
               // JOptionPane.showMessageDialog(null, "Conexão OK");
                stmt = con.createStatement();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco\nTentaiva de conexão com usuário: "+bdUser);
                File f = new File("database.conf");
                f.delete();
                System.exit(1);
                result=false;
                //e.printStackTrace();
            }
    			
        return result;		
    }
    
    public boolean desconnect(){
    	boolean result=true;
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error ao desconectar com o banco");
			result=false;
			e.printStackTrace();
		}
    	return result;
    }        
    
    public ResultSet query_res(String qry){
        try{
            rs = stmt.executeQuery(qry);
           // JOptionPane.showMessageDialog(null, "Query com result executada");
            return rs;
        }catch(SQLException err){
            err.printStackTrace();
            return null;
        }        
    }
    
    public void QueryObject(String sql){
    	int count=0;    	
    	
    	try {
                stmt = con.createStatement();   
                count = stmt.executeUpdate(sql);
                if(count>0)
                    JOptionPane.showMessageDialog(null, "Alteração feita com Sucesso!");                                   
		} catch (SQLException e) {			
                    JOptionPane.showMessageDialog(null, "Erro ao alterar registro!");
                    e.printStackTrace();
		}
    }         
    
        public void QueryObject(String sql,boolean msg){
    	int count=0;    	
    	
    	try {
                stmt = con.createStatement();   
                count = stmt.executeUpdate(sql);
                /*if(count>0)
                    JOptionPane.showMessageDialog(null, "Alteração feita com Sucesso!");*/
		} catch (SQLException e) {			
                    JOptionPane.showMessageDialog(null, "Erro ao alterar registro!");
                    e.printStackTrace();
		}
    }     

}
