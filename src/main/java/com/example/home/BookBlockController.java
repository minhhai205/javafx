package com.example.home;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BookBlockController {
    @FXML
    private VBox bookBlock;
    @FXML
    private ImageView bookImage;
    @FXML
    private Label titleLabel;
    @FXML
    private Label authorLabel;

    public void setBookData(Book book) {
        titleLabel.setText(book.getTitle());
        authorLabel.setText("by " + book.getAuthor());
        bookImage.setImage(new Image(book.getImageUrl()));
        bookBlock.setOnMouseClicked(this::handleClick);
    }

    private void handleClick(MouseEvent event) {
        System.out.println("Ok");
    }
}