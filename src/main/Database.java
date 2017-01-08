package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Created by Kanni on 07.01.2017.
 */

//Kasutatud: https://github.com/KristerV/javaSQLNaide/blob/master/src/Andmebaas.java
public class Database {
    Connection connection = null;

    //objekti loomine
    public Database() {
        connect();
        createTable();

    }

    //andmebaasi ühendumiseks
    private void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
//            connection = DriverManager.getConnection("jdbc:sqlite:transaction.db"); //Connect to database file
            connection = DriverManager.getConnection("jdbc:sqlite:transaction.db");
            System.out.println("Database connect successful"); //kinnitav sõnum kontrolliks
        } catch (Exception e) { //püüab kinni errorid
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    //teeb uue tabeli kui pole juba olemas
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS TRANSACTIONS (AMOUNT INT, CATEGORY TEXT, DATE DATE, COMMENT TEXT);"; //columns
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
            System.out.println("Database disconnected"); //kontrolltekst
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveTransactions(HashMap<String, String> data) {
        String amount = data.get("amount");
        String category = data.get("category");
        String date = data.get("date");
        String comment = data.get("comment");

        try {
            Statement stat = connection.createStatement();
            String sql = String.format("INSERT INTO TRANSACTIONS (AMOUNT, CATEGORY, DATE,COMMENT) VALUES('%s','%s','%s','%s')", amount, category, date, comment);

            stat.executeUpdate(sql);
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public List<Transaction> getTransactions() {
        //teeb tühja array
        List<Transaction> transactions = new ArrayList<>();
        try {
            Statement stat = connection.createStatement();
            String sql = "SELECT * FROM TRANSACTIONS";

            ResultSet resultSet = stat.executeQuery(sql);
            //while tsükkel loeb baasist rida rea haaval välja kasutaja sisestatud kirjed ja paneb transactions arraysse
            while(resultSet.next()){
                Transaction transaction = new Transaction(resultSet.getString("amount"), resultSet.getString("category"), resultSet.getString("date"), resultSet.getString("comment"));
                transactions.add(transaction);
            }
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return transactions;

    }
}
