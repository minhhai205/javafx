package com.example;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene; // inport tạo scene
import javafx.scene.control.Button; // import button
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent; // import bắt sự kiện
import javafx.event.EventHandler; //

public class App extends Application {

    // Hàm start để bắt đầu javafx
    @Override
    public void start(Stage primaryStage) throws Exception {

        Button btn = new Button("hello");
        // bắt sự kiện cho nút
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("hello world");
            }
        });

        Button btnExit = new Button("Exit.");
        btnExit.setOnAction((e) -> {
            System.exit(0);
        });

        // Tạo bố cục và thêm nút vào
        // StackPane root = new StackPane();
        VBox root = new VBox();
        root.getChildren().addAll(btn, btnExit);

        // layout cần đc thêm vào scene, scene vẫn ở cấp cao hơn
        Scene scene = new Scene(root, 600, 400);

        // Show layout
        primaryStage.setScene(scene);
        primaryStage.setTitle("First JavaFX Application");
        primaryStage.show();
    }

    // tạo phương thức main
    public static void main(String[] args) {
        launch(args);
    }

}