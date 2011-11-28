/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramayana Júnior
 */
public class Config {
    File file_config_name;
    public String user,password;

    public Config() {
        file_config_name = new File("database.conf");
        if(file_config_name.exists()){
            String l;
            String[] aux, resul= new String[2];        
            try{        
                BufferedReader bf_read = new BufferedReader( new FileReader("database.conf") );            
                int i=0,j=0;            
                while( (l = bf_read.readLine() ) != null ){     
                    aux = l.split(":");
                    resul[i] = aux[1];
                    ++i;
                }
                user = resul[0]; password = resul[1];
            }catch(Exception e){e.printStackTrace();}
        }else{
             String input = JOptionPane.showInputDialog("Entre com o nome do seu \"User MYSQL\":");
             user = input;
             input = JOptionPane.showInputDialog("Entre com a senha do usuário informado:");
             password = input;
             
            File arquivo = new File("database.conf");
            try{        
                FileOutputStream saida = new FileOutputStream(arquivo);        
                String arq = "USER:"+user+"\n"+"PASSWORD:"+password;
                saida.write(arq.getBytes());
                saida.close();
            }catch(IOException error){
                System.out.printf("Erro em arquivo: %s", error.toString() );
            }
        }
        
    }
    
    
}
