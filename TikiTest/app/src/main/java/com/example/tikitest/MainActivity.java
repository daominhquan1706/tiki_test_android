package com.example.tikitest;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tikitest.Interface.Api;
import com.example.tikitest.Model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    RecyclerView rcv_products;
    Product_RecyclerView_Adapter adapter;
    ScrollView scrollview;
    AppBarLayout appBarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Product>> call = api.getProducts();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                List<Product> products = response.body();
                adapter = new Product_RecyclerView_Adapter(MainActivity.this, products);
                rcv_products.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "vui lòng kiểm tra lại kết nối internet", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void init() {
        scrollview = (ScrollView) findViewById(R.id.scrollview);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setVisibility(View.VISIBLE);
        rcv_products = (RecyclerView) findViewById(R.id.rcv_products);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);
        setupScrollView();
    }

    private void setupScrollView() {
        final Animation slideDown_toolbar = AnimationUtils.loadAnimation(this, R.anim.toolbar_slidedown);
        final Animation slideUp_toolbar = AnimationUtils.loadAnimation(this, R.anim.toolbar_slideup);
        scrollview.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY - oldScrollY > 10 && appBarLayout.getVisibility() == View.VISIBLE) {
                    appBarLayout.setVisibility(View.INVISIBLE);
                    appBarLayout.startAnimation(slideUp_toolbar);


                } else if (scrollY - oldScrollY < -10 && appBarLayout.getVisibility() == View.INVISIBLE) {

                    appBarLayout.setVisibility(View.VISIBLE);
                    appBarLayout.startAnimation(slideDown_toolbar);
                }
            }
        });
    }
    SearchView searchView;
    MenuItem menuItem;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);



        return true;
    }
}
