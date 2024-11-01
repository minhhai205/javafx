package com.example;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Thongbao_alert extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button btn = new Button("hello");

        btn.setOnAction((e) -> {
            // Khai báo alert chọn thông tin và set các giá trị hiển thị
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Alert Information");
            alert.setContentText("choose you option");

            // Khai báo các lựa chọn button
            ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get().getButtonData() == ButtonBar.ButtonData.YES) {
                System.out.println("choose yes");
            } else if (result.get().getButtonData() == ButtonBar.ButtonData.NO) {
                System.out.println("choose no");
            } else {
                System.out.println("choose cancel");
            }

            // Hiện một bảng thông báo khác sau khi chọn
            String message = result.get().getText();
            Alert alert1 = new Alert(AlertType.INFORMATION); // TÌm hiểu thêm các loại AlertType
            alert1.setTitle("Thông tin");
            alert1.setHeaderText("Thông báo");
            alert1.setContentText(message);
            alert1.showAndWait();
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(btn);
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
