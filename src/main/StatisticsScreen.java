package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Kanni on 01.01.2017.
 */
public class StatisticsScreen extends Application {
    @Override
    public void start (Stage primaryStage) throws Exception {

        VBox vBox = new VBox();
        vBox.setSpacing(8);
        Scene stats = new Scene(vBox,200,300);
        primaryStage.setScene(stats);
        primaryStage.show();

        Label from = new Label("From");
        DatePicker startDate = new DatePicker();
        Label to = new Label("To");
        DatePicker toDate = new DatePicker();
        Label category = new Label("Category");
        ChoiceBox chooseCat = new ChoiceBox(FXCollections.observableArrayList("Bills","Food","Clothing","Leisure","Health","Transport","Other")
        );
        Label type = new Label("Type");
        ChoiceBox chooseType = new ChoiceBox(FXCollections.observableArrayList("Sum", "List")
        );
        Button search = new Button("Search");
        Button home = new Button("Home");

        vBox.getChildren().addAll(from, startDate, to, toDate, category, chooseCat, type, chooseType, search, home);
    }
}
