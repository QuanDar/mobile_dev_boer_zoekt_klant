package be.bzk.boerzoektklant.models;

import android.graphics.Bitmap;

import java.util.List;

public class Business {
    private int id;
    private String title;
    private String description;
    private String excerpt;
    private Bitmap imageBitmap;
    private int rating;
    private String phoneNumber;
    private List<Prices> prices;
    private List<Category> categories;

    public Business() {
    }

    public Business(int id, String title, String description, String excerpt, Bitmap imageUrl, int rating, String phoneNumber, List<Prices> prices) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.excerpt = excerpt;
        this.imageBitmap = imageUrl;
        this.rating = rating;
        this.phoneNumber = phoneNumber;
        this.prices = prices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Prices> getPrices() {
        return prices;
    }

    public void setPrices(List<Prices> prices) {
        this.prices = prices;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public void setImageBitmap(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
    }
}





