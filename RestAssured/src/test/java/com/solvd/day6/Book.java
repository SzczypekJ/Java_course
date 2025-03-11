package com.solvd.day6;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private String title;
    private String author;
    private String category;
    private String isbn;
    private double price;

    public Book(String title, String author, String category, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.isbn = isbn;
        this.price = price;
    }
}
