/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientstore;

import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ;

/**
 *
 * @author Omar
 */
public class Database {
    public Connection connection ;
    public void handle() throws SQLException, ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.64.2/patient_store", "omar",  "1411");
            System.out.println("connected");
        } catch (Exception ex){
            System.out.printf("Error : " + ex.getMessage());
        }
        
    }
    
    public ResultSet executePatientQuery(String query){
        ResultSet rs = null;
        try {
            this.handle();
            Statement stmnt = connection.createStatement();
            rs = stmnt.executeQuery(query);
        } catch(Exception x) {
            System.out.println("Error: " + x.getMessage());
        }
        return rs;
    }
    
    public void executePatientUpdate(String id, String name, String type, String rank) throws SQLException, ClassNotFoundException{
        this.handle();
        Statement stmnt = null ;
        try {
            stmnt = connection.createStatement();
            String query = "INSERT INTO `Patient` (`id`, `name`, `type`, `rank`) VALUES ('" + id + "','" + name + "','" + type + "','" + rank + "');";
            stmnt.executeUpdate(query);
        } catch(Exception x) {
            String query = "UPDATE `Patient` SET `name` = '" + name + "',`type` = '" + type + "',`rank` = '" + rank + "' WHERE `id` = '" + id + "'";;
            stmnt.executeUpdate(query);
            System.out.println("Error: " + x.getMessage());
        }
    }
    
    public void executeRecordUpdate(int patient_id, String department, String count) throws SQLException, ClassNotFoundException{
        this.handle();
        Statement stmnt = null ;
        try {
            stmnt = connection.createStatement();
            String query = "INSERT INTO `Record` (`patient_id`, `department`, `count`) VALUES ('" + patient_id + "','" + department + "','" + count + "');";
            stmnt.executeUpdate(query);
        } catch(Exception x) {
            System.out.println("Error: " + x.getMessage());
        }
    }
    
    public void shutdown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    
    public ResultSet executeRecordQuery(String query){
        ResultSet rs = null;
        try {
            this.handle();
            Statement stmnt = connection.createStatement();
            rs = stmnt.executeQuery(query);
        } catch(Exception x) {
            System.out.println("Error: " + x.getMessage());
        }
        return rs;
    }
}
