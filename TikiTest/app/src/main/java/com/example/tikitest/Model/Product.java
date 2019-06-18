package com.example.tikitest.Model;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    private List<Badge_Product> badges;
    private int discount_rate;
    private int id;
    private String name;
    private BigDecimal price;
    private float rating_average;
    private int review_count;
    private String thumbnail_url;

    public Product(List<Badge_Product> badges, int discount_rate, int id, String name, BigDecimal price, float rating_average, int review_count, String thumbnail_url) {
        this.badges = badges;
        this.discount_rate = discount_rate;
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating_average = rating_average;
        this.review_count = review_count;
        this.thumbnail_url = thumbnail_url;
    }

    public Product() {
    }

    public List<Badge_Product> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge_Product> badges) {
        this.badges = badges;
    }

    public int getDiscount_rate() {
        return discount_rate;
    }

    public void setDiscount_rate(int discount_rate) {
        this.discount_rate = discount_rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public float getRating_average() {
        return rating_average;
    }

    public void setRating_average(float rating_average) {
        this.rating_average = rating_average;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }
}
