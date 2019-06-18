package com.example.tikitest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tikitest.Model.Badge_Product;
import com.example.tikitest.Model.Product;

import java.util.List;

public class Product_RecyclerView_Adapter extends RecyclerView.Adapter<Product_RecyclerView_Adapter.ViewHolder> {
    private List<Product> products;
    private Context mContext;
    private static final String TAG = "Product_RecyclerView_Adapter";

    public Product_RecyclerView_Adapter(Context mContext, List<Product> products) {
        this.products = products;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final Product product = products.get(i % products.size());

        Glide.with(mContext.getApplicationContext())
                .load(product.getThumbnail_url())
                .apply(new RequestOptions().fitCenter())
                .into(viewHolder.img_product);
        StringBuilder badge = new StringBuilder();
        setUpBadge(viewHolder, product, badge);
        viewHolder.tv_product_name.setText(product.getName());
        viewHolder.tv_product_price.setText(String.valueOf(String.format("%,.0f", product.getPrice()) + " đ̲"));
        viewHolder.tv_product_discount.setText(String.valueOf("-" + product.getDiscount_rate() + "%"));
        viewHolder.tv_count_rating.setText(String.valueOf("(" + product.getReview_count() + ")"));
        viewHolder.rt_product.setRating(product.getRating_average());
    }

    private void setUpBadge(ViewHolder viewHolder, Product product, StringBuilder badge) {
        for (Badge_Product b : product.getBadges()) {
            badge.append(b.getCode());
        }
        if (badge.toString().contains("tikinow")) {
            viewHolder.img_tiki_now.setVisibility(View.VISIBLE);
        } else {
            viewHolder.img_tiki_now.setVisibility(View.GONE);
        }
        if (badge.toString().contains("fast_delivery")) {
            viewHolder.lnl_fast_delivery.setVisibility(View.VISIBLE);
        } else {
            viewHolder.lnl_fast_delivery.setVisibility(View.GONE);
        }
        if (badge.toString().contains("option_color")) {
            viewHolder.tv_option_color.setText("Nhiều màu");
            viewHolder.lnl_option_nhieu_mau.setVisibility(View.VISIBLE);
        } else {
            viewHolder.lnl_option_nhieu_mau.setVisibility(View.GONE);
        }
    }


    public int getItemCount() {
        return products == null ? 0 : products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_product, img_tiki_now;
        TextView tv_product_name, tv_product_price, tv_product_discount, tv_count_rating, tv_option_color;
        LinearLayout lnl_fast_delivery, lnl_option_nhieu_mau;
        RatingBar rt_product;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_product = (ImageView) itemView.findViewById(R.id.img_product);
            img_tiki_now = (ImageView) itemView.findViewById(R.id.img_tiki_now);
            tv_product_name = (TextView) itemView.findViewById(R.id.tv_product_name);
            tv_product_price = (TextView) itemView.findViewById(R.id.tv_product_price);
            tv_product_discount = (TextView) itemView.findViewById(R.id.tv_product_discount);
            tv_count_rating = (TextView) itemView.findViewById(R.id.tv_count_rating);
            lnl_fast_delivery = (LinearLayout) itemView.findViewById(R.id.lnl_fast_delivery);
            lnl_option_nhieu_mau = (LinearLayout) itemView.findViewById(R.id.lnl_option_nhieu_mau);
            rt_product = (RatingBar) itemView.findViewById(R.id.rt_product);
            tv_option_color = (TextView) itemView.findViewById(R.id.tv_option_color);
        }

    }
}
