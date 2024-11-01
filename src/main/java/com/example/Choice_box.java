package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Choice_box extends Application {
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Choice Box");

        Button btn = new Button("Submit");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        // Xét các item cho choice box
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().addAll("Bacon", "Banana");

        // Xét giá trị mặc định cho choice box
        choiceBox.setValue("Apples");

        // Thêm sự kiện lấy giá trị của choicebox bằng nút btn
        // btn.setOnAction(e -> {
        // getChoiceBox(choiceBox);
        // });

        // Lắng nghe sự kiện khi người dùng thay đổi lựa chọn
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            System.out.println(v);
            System.out.println(oldValue);
            System.out.println(newValue + '\n');
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(choiceBox, btn);

        Scene scene = new Scene(layout, 600, 400);
        window.setScene(scene);
        window.show();
    }

    @SuppressWarnings("unused")
    private void getChoiceBox(ChoiceBox<String> choiceBox) {
        String food = choiceBox.getValue();
        System.out.println(food);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
