package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Checkbox extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Progaming language");
        CheckBox box1 = new CheckBox("java");
        CheckBox box2 = new CheckBox("C++");
        CheckBox box3 = new CheckBox("python");

        box1.setSelected(true);
        Button button = new Button("Submit");
        button.setOnAction(e -> {
            if (box1.isSelected()) {
                System.out.println(box1.getText());
            }
            if (box2.isSelected()) {
                System.out.println(box2.getText());
            }
            if (box3.isSelected()) {
                System.out.println(box3.getText());
            }
        });

        HBox layoutH = new HBox(10);
        layoutH.getChildren().addAll(box1, box2, box3);
        VBox layoutV = new VBox(10);
        layoutV.getChildren().addAll(label, layoutH, button);

        Scene scene = new Scene(layoutV, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
