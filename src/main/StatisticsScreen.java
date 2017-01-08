package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

/**
 * Created by Kanni on 01.01.2017.
 */
//Kasutatud: http://docs.oracle.com/javafx/2/ui_controls/table-view.htm
public class StatisticsScreen extends Application {

    private TableView<Transaction> stats = new TableView<Transaction>();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage primaryStage) throws Exception {

        Database dataBase = new Database();


        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Statistics");
        primaryStage.setWidth(450);
        primaryStage.setHeight(500);

        stats.setEditable(true);

        TableColumn amountCol = new TableColumn("Amount");
        amountCol.setMinWidth(100);
        amountCol.setCellValueFactory(
                new PropertyValueFactory<Transaction, String>("Amount"));

        TableColumn categoryCol = new TableColumn("Category");
        categoryCol.setMinWidth(100);
        categoryCol.setCellValueFactory(
                new PropertyValueFactory<Transaction, String>("Category"));

        TableColumn dateCol = new TableColumn("Date");
        dateCol.setMinWidth(100);
        dateCol.setCellValueFactory(
                new PropertyValueFactory<Transaction, String>("Date"));

        TableColumn commentCol = new TableColumn("Comment");
        commentCol.setMinWidth(100);
        commentCol.setCellValueFactory(
                new PropertyValueFactory<Transaction, String>("Comment"));

        List<Transaction> transactions = dataBase.getTransactions();
        ObservableList<Transaction> data =
                FXCollections.observableArrayList(transactions);
        stats.setItems(data);
        stats.getColumns().addAll(amountCol, categoryCol, dateCol,commentCol);

        Button home = new Button("Home");


        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(stats, home);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
