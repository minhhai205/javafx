package com.example.new_window;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button("Click");

        btn.setOnAction(e -> {
            NewWindow.disPlay("Title", "message");
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(btn);
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
