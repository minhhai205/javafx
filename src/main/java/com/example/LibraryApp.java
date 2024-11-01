package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

class Book {
    private String title;
    private String authors;
    private String description;
    private String isbn;
    private String categories;

    public Book(String title, String authors, String description, String isbn, String categories) {
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.isbn = isbn;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                "\nAuthors: " + authors +
                "\nDescription: " + description +
                "\nISBN: " + isbn +
                "\nCategories: " + categories +
                "\n\n";
    }

    // Getters and Setters (Nếu cần)
}

public class LibraryApp extends Application {

    private static final String API_KEY = "AIzaSyBIX64n61xL9ctLvYqoM-zPhZN-2_eLKoI"; // Thay bằng API Key của bạn
    private TextArea bookInfoArea;
    private TextField searchField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library App - Google Books API");

        searchField = new TextField();
        searchField.setPromptText("Enter book title or ISBN");

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> searchBooks());

        bookInfoArea = new TextArea();
        bookInfoArea.setEditable(false);

        VBox vbox = new VBox(10, searchField, searchButton, bookInfoArea);
        Scene scene = new Scene(vbox, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void searchBooks() {
        String query = searchField.getText();
        if (query.isEmpty()) {
            bookInfoArea.setText("Please enter a search term.");
            return;
        }

        String formattedQuery = query.trim().replace(" ", "+");

        // API URL với từ khóa tìm kiếm và API Key
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + formattedQuery + "&maxResults=1&key=" + API_KEY;

        // Sử dụng HttpClient để gửi yêu cầu
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::parseBookInfo)
                .thenAccept(books -> {
                    StringBuilder result = new StringBuilder();
                    for (Book book : books) {
                        result.append(book.toString());
                    }
                    bookInfoArea.setText(result.toString());
                })
                .exceptionally(e -> {
                    e.printStackTrace();
                    bookInfoArea.setText("Error: Unable to retrieve book information.");
                    return null;
                });
    }

    // Phương thức phân tích kết quả JSON trả về từ Google Books API
    private List<Book> parseBookInfo(String responseBody) {
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONArray items = jsonObject.optJSONArray("items");
        List<Book> books = new ArrayList<>();

        if (items == null || items.length() == 0) {
            bookInfoArea.setText("No books found.");
            return books; // Trả về danh sách rỗng
        }

        for (int i = 0; i < items.length(); i++) {
            JSONObject bookJson = items.getJSONObject(i).getJSONObject("volumeInfo");

            String title = bookJson.optString("title", "No Title");
            String authors = bookJson.optJSONArray("authors") != null
                    ? bookJson.getJSONArray("authors").join(", ").replace("\"", "")
                    : "No Authors";
            String description = bookJson.optString("description", "No Description");
            String isbn = bookJson.optJSONArray("industryIdentifiers") != null
                    ? bookJson.getJSONArray("industryIdentifiers").getJSONObject(0).getString("identifier")
                    : "No ISBN";
            String category = bookJson.optJSONArray("categories") != null
                    ? bookJson.getJSONArray("categories").join(", ").replace("\"", "")
                    : "No Categories";

            books.add(new Book(title, authors, description, isbn, category));
        }

        return books;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
