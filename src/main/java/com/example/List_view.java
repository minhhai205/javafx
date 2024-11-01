package com.example;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class List_view extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Choice Box");

        Button btn = new Button("Submit");

        // Khai bao listview
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("chon 1", "chon 2");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // click btn
        btn.setOnAction(e -> {
            String message = "";
            ObservableList<String> list;
            list = listView.getSelectionModel().getSelectedItems();

            for (String s : list) {
                message = message + s + " ";
            }

            System.out.println(message);
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listView, btn);

        Scene scene = new Scene(layout, 600, 400);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
