package main;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Kanni on 08.01.2017.
 */
//Kasutatud materjal: http://docs.oracle.com/javafx/2/ui_controls/table-view.htm
public class Transaction {

    public SimpleStringProperty amount;
    public SimpleStringProperty category;
    public SimpleStringProperty date;
    public SimpleStringProperty comment;

    public Transaction(String amount, String category, String date, String comment) {
        this.amount = new SimpleStringProperty(amount);
        this.category =  new SimpleStringProperty(category);
        this.date =  new SimpleStringProperty(date);
        this.comment =  new SimpleStringProperty(comment);
    }
    //genereeritud kõik

    public String getAmount() {
        return amount.get();
    }

    public SimpleStringProperty amountProperty() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getComment() {
        return comment.get();
    }

    public SimpleStringProperty commentProperty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment.set(comment);
    }

    @Override
    //näitab objekti sisu stringi kujul
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", category=" + category +
                ", date=" + date +
                ", comment=" + comment +
                '}';
    }
}

