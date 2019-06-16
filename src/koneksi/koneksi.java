package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



public class koneksi {
       public static Connection cn;
       public static Statement stm;
       public static Connection getkoneksi() {
           if (cn == null){
               try{
                   DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                   cn = DriverManager.getConnection("jdbc:mysql://localhost/db_java","root","");
                   stm=cn.createStatement();
                   System.out.println("Berhasil");
               } catch (Exception e){
                   e.getStackTrace();
               }
           }
           return cn;
       }
}
