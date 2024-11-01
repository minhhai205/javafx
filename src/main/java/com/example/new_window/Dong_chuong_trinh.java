package com.example.new_window;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Dong_chuong_trinh extends Application {
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Button btn = new Button("Click");

        // Xét xác nhận khi người dùng click nút x đóng chương trình
        window.setOnCloseRequest(e -> {
            e.consume(); // Chặn sự kiện đóng cửa sổ tiếp tục lan truyền.
            closeProgram();
        });

        // Click button đóng ctr, có thể phát triển khi ghi nhận một yêu cầu từ người từ
        // dùng
        btn.setOnAction(e -> {
            closeProgram();
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(btn);
        Scene scene = new Scene(root, 600, 400);

        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        Boolean answer = NewWindow.disPlay("Title", "Ban co muon thoat");
        if (answer) {
            window.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
