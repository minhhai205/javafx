package com.example;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

public class Dialog_login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Khai bao dialog
        Dialog<Pair<String, String>> dialog = new Dialog<>(); // hộp thoại trả về 1 cặp giá trị
        dialog.setTitle("login");
        dialog.setHeaderText("Sign up");

        // tạo button có sẵn trong java
        // chỉ sửa giá trị login mới khai báo thế này
        ButtonType loginButtonType = new ButtonType("login", ButtonBar.ButtonData.OK_DONE);
        // không thì khai báo như ButtonType.CANCEL luôn
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10); // xét chiều ngang với các cái khác
        grid.setVgap(10); // xét chiều dọc với các cái khác
        grid.setPadding(new Insets(20, 150, 10, 10)); // Xét phần đệm với các viền xung quanh

        // Tạo 2 textfiled
        TextField userName = new TextField();
        userName.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(userName, 1, 0);
        grid.add(new Label("Password"), 0, 1);
        grid.add(password, 1, 1);

        // gắn gridpane vào dialog
        dialog.getDialogPane().setContent(grid);

        // Viết phương thức trả về giá trị username và password khi bấm nút
        dialog.setResultConverter((dialogButton) -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(userName.getText(), password.getText());
            }
            return null;
        });

        // hiển thị kết quả sau khi người dùng ấn nút
        Optional<Pair<String, String>> result = dialog.showAndWait();
        // nếu trả về đúng giá trị pair mới goi vào hàm
        result.ifPresent(e -> {
            System.out.println("usename: " + e.getKey() + ", password: " + e.getValue());
        });
    }

}
