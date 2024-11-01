package com.example.home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.util.List;

public class LibraryHomePageController {

    @FXML
    private TilePane booksContainer;

    public void initialize() {
        List<Book> books = getBookList();
        loadBooks(books);
    }

    private List<Book> getBookList() {
        return List.of(

                new Book("Harry Potter", "J.K. Rowling", "com/example/home/data.jpg"),
                new Book("Lord of the Rings", "J.R.R. Tolkien", "com/example/home/data.jpg"),
                new Book("Lord of the Rings", "J.R.R. Tolkien", "com/example/home/data.jpg"),
                new Book("Lord of the Rings", "J.R.R. Tolkien", "com/example/home/data.jpg"),
                new Book("Lord of the Rings", "J.R.R. Tolkien", "com/example/home/data.jpg"),
                new Book("Lord of the Rings", "J.R.R. Tolkien", "com/example/home/data.jpg"),
                new Book("Lord of the Rings", "J.R.R. Tolkien", "com/example/home/data.jpg"),
                new Book("Lord of the Rings", "J.R.R. Tolkien", "com/example/home/data.jpg"),
                new Book("Lord of the Rings", "J.R.R. Tolkien", "com/example/home/data.jpg"),
                new Book("Lord of the Rings", "J.R.R. Tolkien", "com/example/home/data.jpg"),
                new Book("Lord of the Rings", "J.R.R. Tolkien", "com/example/home/data.jpg"),
                new Book("Lord of the Rings", "J.R.R. Tolkien", "com/example/home/data.jpg"),
                new Book("Lord of the Rings", "J.R.R. Tolkien", "com/example/home/data.jpg"),
                new Book("Lord of the Rings", "J.R.R. Tolkien", "com/example/home/data.jpg"),
                new Book("Lord of the Rings", "J.R.R. Tolkien", "com/example/home/data.jpg")
        // Thêm sách khác
        );
    }

    private void loadBooks(List<Book> books) {
        for (Book book : books) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/home/BookBlock.fxml"));
                VBox bookBlock = loader.load();

                BookBlockController controller = loader.getController();
                controller.setBookData(book);

                booksContainer.getChildren().add(bookBlock);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
