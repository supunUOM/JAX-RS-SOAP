package com.example.business;

import com.example.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductServiceImpl {
    List<String> bookList = new ArrayList<>();
    List<String> musicList = new ArrayList<>();
    List<String> movieList = new ArrayList<>();

    public ProductServiceImpl() {
        bookList.add("Inferno");
        bookList.add("ToyLand");
        bookList.add("The Game of Thrones");

        musicList.add("Random Access Memories");
        musicList.add("Night visions");
        musicList.add("Unorthodox jukebox");

        movieList.add("0z the great powerful");
        movieList.add("Despicable me");
        movieList.add("Start Trek into Darkness");
    }

    public List<String> getProductCategories() {
        return Arrays.asList("Books", "Music", "Movies");
    }

    public List<String> getProducts(String category) {
        switch (category.toLowerCase()) {
            case "books":
                return bookList;
            case "music":
                return musicList;
            case "movies":
                return movieList;
        }
        return null;
    }

    public List<Product> getProductsV2(String category) {

        return Arrays.asList(
                new Product("Java brains book", "1234", 9999.9),
                new Product("Another book", "1234", 9977.9),
                new Product("Java brains book", "1234", 9988.9)
        );
    }

    public boolean addProduct(String category, String product) {
        switch (category.toLowerCase()) {
            case "books":
                bookList.add(product);
                break;
            case "music":
                musicList.add(product);
                break;
            case "movies":
                movieList.add(product);
                break;
            default:
                return false;
        }
        return true;
    }
}
