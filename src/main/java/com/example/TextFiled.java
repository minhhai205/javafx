package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFiled extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Tạo TextField
        TextField textField = new TextField();
        textField.setPromptText("Nhập giá trị tại đây");

        // Tạo Button
        Button button = new Button("In ra giá trị");

        // Sự kiện khi nhấn nút
        button.setOnAction(e -> {
            // Lấy giá trị từ TextField và in ra console
            String inputValue = textField.getText();
            System.out.println("Giá trị nhập vào: " + inputValue);
        });

        // Bố cục
        VBox vbox = new VBox(10, textField, button);
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Tạo Scene
        Scene scene = new Scene(vbox, 300, 200);

        // Hiển thị cửa sổ
        primaryStage.setTitle("TextField Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
