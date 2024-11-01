package com.example;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class BookApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Tạo một DoubleProperty để lưu trữ giá trị của slider
        DoubleProperty sliderValue = new SimpleDoubleProperty();

        // Tạo slider
        Slider slider = new Slider(0, 100, 50);
        slider.valueProperty().bindBidirectional(sliderValue);

        // Tạo label để hiển thị giá trị
        Label label = new Label();
        label.textProperty().bind(sliderValue.asString());

        // Tạo layout và thêm các control vào
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(slider, label);

        // Tạo scene và stage
        Scene scene = new Scene(root, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DoubleProperty Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}