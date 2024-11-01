package com.example;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene; // inport tạo scene
import javafx.scene.control.Button; // import button
import javafx.scene.layout.StackPane; // import bố cục

public class Thay_doi_scene extends Application {
    // Hàm start để bắt đầu javafx
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn1 = new Button("Đổi sang 2");
        Button btn2 = new Button("Đổi sang 1");

        StackPane root1 = new StackPane();
        root1.getChildren().addAll(btn1);

        StackPane root2 = new StackPane();
        root2.getChildren().addAll(btn2);

        // layout cần đc thêm vào scene, scene vẫn ở cấp cao hơn
        Scene scene1 = new Scene(root1, 600, 400);
        Scene scene2 = new Scene(root2, 600, 400);

        btn1.setOnAction((e) -> {
            primaryStage.setScene(scene2);
        });

        btn2.setOnAction((e) -> {
            primaryStage.setScene(scene1);
        });

        // Show layout
        primaryStage.setScene(scene1);
        primaryStage.setTitle("First JavaFX Application");
        primaryStage.show();
    }

    // tạo phương thức main
    public static void main(String[] args) {
        launch(args);
    }
}
