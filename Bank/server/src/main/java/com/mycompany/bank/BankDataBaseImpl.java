package com.mycompany.bank;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mark2
 */
public class BankDataBaseImpl extends BankImpl implements DataBase {

    @Override
    public void save() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Brak sterownika");
            e.printStackTrace();
            System.exit(1);
        }
        Connection conn = null;
        String strUrl = "jdbc:mysql://localhost/asdf";
        java.util.Properties props = new java.util.Properties();
        props.put("user", "root");
        props.put("password", "meaculpa");
        try {
            conn = (Connection) DriverManager.getConnection(strUrl, props);
            Statement statement = (Statement) conn.createStatement();
            ResultSet result = statement.executeQuery("select * from app.customer");
            conn.close();
        } catch (SQLException e) {
// TODO: handle exception
        }
    }

    @Override
    public void update() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Brak sterownika");
            e.printStackTrace();
            System.exit(1);
        }
        Connection conn = null;
        String strUrl = "jdbc:mysql://localhost/asdf";
        java.util.Properties props = new java.util.Properties();
        props.put("user", "root");
        props.put("password", "meaculpa");
        try {
            conn = (Connection) DriverManager.getConnection(strUrl, props);
            Statement statement = (Statement) conn.createStatement();
            ResultSet result = statement.executeQuery("select * from Employees");
            while (result.next()) {
                System.out.print(result.getLong("id"));
                System.out.print(result.getLong("age"));
                System.out.print(result.getString("first"));
                System.out.println(result.getString("last"));
            }
            conn.close();
        } catch (SQLException e) {
// TODO: handle exception
        }

    }

    @Override
    public void remove(Integer Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void find(Integer Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main (String [] args) {
        BankDataBaseImpl bank = new BankDataBaseImpl();
        bank.update ();
        bank.createAccount("Mark", "Warsaw");
        bank.createAccount("Moby", "Warsaw");
        bank.save ();
    }
    
}
