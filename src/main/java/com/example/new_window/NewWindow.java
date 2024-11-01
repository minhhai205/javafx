package com.example.new_window;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewWindow {
    static boolean answer;

    public static boolean disPlay(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL); // ngăn chặn việc thoát trang khi click ra ngoài
        window.setTitle(title);

        Label label = new Label(message);

        // Tạo 2 button xác nhận
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layoutV = new VBox(10);
        layoutV.getChildren().addAll(label, yesButton, noButton);

        Scene scene = new Scene(layoutV, 300, 200);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
