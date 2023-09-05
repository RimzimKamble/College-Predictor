/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.sql.*;

/**
 *
 * @author swapn
 */
public class dbConnection {
    public static Connection con() {
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniprojectdb","root","");
            System.out.println("Database connected!");
        }catch(Exception e){
            System.out.print(e);
        }
        return con;
    }
}
