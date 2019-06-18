package com.example.tikitest.Interface;

import com.example.tikitest.Model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://raw.githubusercontent.com/tikivn/android-home-test/v3/";

    @GET("products.json")
    Call<List<Product>> getProducts();
}
