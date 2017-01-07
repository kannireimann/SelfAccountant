package main;

import java.sql.*;
import java.util.HashMap;

/**
 * Created by Kanni on 07.01.2017.
 */
public class Database {
    Connection connection = null;

    //Constructor
    public Database() {
        connect();
        disconnect();
    }

    //Connect to database
    private void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jbdc:sqlite:transactions.db"); //Connect to database file
            System.out.println("Database connect successful"); //Confirmation message
        } catch (Exception e) { //Catch errors
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    //Create new table when one does not exist
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS TRANSACTIONS (AMOUNT INT, CATEGORY TEXT, DATE INT, COMMENT TEXT);"; //columns
        updateDatabase(sql);
    }

    public void updateDatabase(String sql) {
        try {
            Statement stat = connection.createStatement();
            stat.executeUpdate(sql);
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Disconnect from database
    public void disconnect() {
        try {
            connection.close();
            System.out.println("Database disconnected"); //Confirmation message
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //poolik!!!
    public HashMap getTransactions(something) {
        HashMap data = new HashMap();
        try {
            Statement stat = connection.createStatement();
            String sql = "SELECT * FROM TRANSACTIONS ...";

            ResultSet result = stat.executeQuery(sql);
            //kui mitu rida andmeid, siis vaja tsüklit (while (result.next()){})
            //get data from a row
            data.put("amount", result.getString("amount"));
            data.put("category", result.getString("category"));
            data.put("date", result.getString("date"));
            data.put("comment", result.getString("comment"));

            result.close();
            stat.close();
            return data;
        }
    }
}
