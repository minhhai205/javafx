package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Tree_view extends Application {
    Stage window;
    TreeView<String> tree;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Tree view");

        TreeItem<String> root, bucky, megan;

        // Root
        root = new TreeItem<>();
        root.setExpanded(false);

        // Megan
        megan = makeBranch("Megan", root);
        makeBranch("Glitter", megan);
        makeBranch("Makeup", megan);

        // Bucky
        bucky = makeBranch("Bucky", root);
        makeBranch("Chicken", bucky);
        makeBranch("YouTube", bucky);
        makeBranch("Chrome", bucky);

        // Create Tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false); // Ẩn root

        // xét sự kiện
        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue != null) {
                if (newValue.isLeaf()) {
                    // In ra các nút con (nếu là leaf node)
                    System.out.println(newValue.getValue());
                } else {
                    // Mở rộng hoặc thu gọn các mục cha khi click
                    newValue.setExpanded(!newValue.isExpanded());
                }
            }
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 600, 400);
        window.setScene(scene);
        window.show();
    }

    public TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(false);
        parent.getChildren().add(item);
        return item;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
