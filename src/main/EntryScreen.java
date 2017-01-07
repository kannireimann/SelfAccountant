package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    }


}
