package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Kanni on 01.01.2017.
 */
public class EntryScreen extends Application{


    @Override
    public void start (Stage primaryStage) throws Exception {
        VBox vBox = new VBox();
        vBox.setSpacing(8);
        Scene entryScreen = new Scene(vBox,200,300);
        primaryStage.setScene(entryScreen);
        primaryStage.show();

        Database transactions = new Database();

        Label amount = new Label("Amount");
        TextField amountField = new TextField();
        Label category = new Label("Category");
        ChoiceBox chooseCat = new ChoiceBox(FXCollections.observableArrayList("Bills","Food","Clothing","Leisure","Health","Transport","Other")
        );
        Label date = new Label("Date");
        DatePicker chooseDate = new DatePicker();
        Label comment = new Label("Comment");
        TextField commentField = new TextField();
        Button submit = new Button("Submit");
        Button statistics = new Button("Statistics");


        vBox.getChildren().addAll(amount, amountField, category, chooseCat, date, chooseDate, comment, commentField, submit, statistics);

        //https://github.com/KristerV/javaSQLNaide/blob/master/src/UserDetails.java
        submit.setOnAction(event -> {
            HashMap<String, String> newEntry = new HashMap<String, String>();
            newEntry.put("amount", amountField.getText());
            newEntry.put("category", chooseCat.getSelectionModel().getSelectedItem().toString());
            newEntry.put("date", chooseDate.getValue().toString());
            newEntry.put("comment", commentField.getText().toString());

            transactions.saveTransactions(newEntry);

            List<Transaction> transactionsList = transactions.getTransactions();

            for(Transaction trans : transactionsList){
                System.out.println(trans); //prindib kirjed välja
            }
            transactions.disconnect();

        });

    }

}
