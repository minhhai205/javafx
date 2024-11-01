package com.example;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.File;

public class FileUploadExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File Upload Example");

        // Tạo một nút để mở FileChooser
        Button uploadButton = new Button("Upload File");
        Text fileInfoText = new Text();

        // Sự kiện khi nhấn nút upload
        uploadButton.setOnAction(e -> {
            // Tạo FileChooser
            FileChooser fileChooser = new FileChooser();

            // Đặt tiêu đề cho FileChooser
            fileChooser.setTitle("Select a File");

            // Cấu hình bộ lọc (chỉ chọn các tệp .txt hoặc tất cả các tệp)
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));

            // Hiển thị hộp thoại FileChooser
            File selectedFile = fileChooser.showOpenDialog(primaryStage);

            // Kiểm tra nếu người dùng chọn tệp
            if (selectedFile != null) {
                fileInfoText.setText("File selected: " + selectedFile.getAbsolutePath());
            } else {
                fileInfoText.setText("No file selected");
            }
        });

        // Sắp xếp các thành phần trong VBox
        VBox vbox = new VBox(10, uploadButton, fileInfoText);

        // Tạo Scene và hiển thị
        Scene scene = new Scene(vbox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
