/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connectmysqldb;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author USUARIO
 */
public class Connectmysqldb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/mydb?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String username ="administrador";
            String password ="30DEabril*";
            Connection conn =DriverManager.getConnection(url, username, password);
            String sql ="SELECT * FROM usuarios";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs =pst.executeQuery();
            if(rs.next()){
                System.out.println("Firstname\t\tMiddleName\t\tLastname");
                System.out.println(rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
}
