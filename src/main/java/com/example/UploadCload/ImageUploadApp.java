package com.example.UploadCload;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.File;

public class ImageUploadApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Tạo nút upload
        Button uploadButton = new Button("Upload Image");

        // Sự kiện khi bấm nút upload
        uploadButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters()
                    .add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
            File file = fileChooser.showOpenDialog(primaryStage);

            if (file != null) {
                try {
                    // Upload ảnh lên Cloudinary
                    CloudinaryUploader uploader = new CloudinaryUploader();
                    String imageUrl = uploader.uploadImage(file);

                    System.out.println(imageUrl);
                    // Hiển thị URL của ảnh vừa được upload
                    showCustomAlert("Image Uploaded", "Upload Successful", "Image URL: " + imageUrl);
                } catch (Exception e) {
                    e.printStackTrace();

                    // Hiển thị lỗi nếu quá trình upload thất bại
                    showCustomAlert("Error", "Upload Failed", "An error occurred: " + e.getMessage());
                }
            }
        });

        // Tạo giao diện với nút upload
        StackPane root = new StackPane(uploadButton);
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Image Upload to Cloudinary");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showCustomAlert(String title, String header, String content) {
        // Tạo một cửa sổ thông báo mới
        Stage alertStage = new Stage();
        alertStage.setTitle(title);
        alertStage.setWidth(800);
        alertStage.setHeight(600);

        // Tạo nội dung cho cửa sổ thông báo
        VBox alertContent = new VBox();
        alertContent.getChildren().addAll(
                new Label(header),
                new Label(content));

        Scene alertScene = new Scene(alertContent, 800, 600);
        alertStage.setScene(alertScene);
        alertStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
