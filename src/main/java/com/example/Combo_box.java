package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Combo_box extends Application {
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Choice Box");

        Button btn = new Button("Submit");

        // Khai báo commbo box
        ComboBox<String> comboBox = new ComboBox<>();

        comboBox.getItems().addAll("Xin chao", "Tam biet");

        // Xét giá trị mặc định
        comboBox.setPromptText("Chọn lựa chọn");

        // Xét sựu kiện click button lấy giá trị
        btn.setOnAction(e -> System.out.println(comboBox.getValue()));

        // Ngoài ra combo box có thể tụ xét sự kiện cho mình và cho phép nhập giá trị
        comboBox.setEditable(true);
        comboBox.setOnAction(e -> System.out.println(comboBox.getValue()));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(comboBox, btn);

        Scene scene = new Scene(layout, 600, 400);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
