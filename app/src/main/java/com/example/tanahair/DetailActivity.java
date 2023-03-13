package com.example.tanahair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class DetailActivity extends AppCompatActivity {

    public static ViewPager viewPager;
    DetailAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        SpringDotsIndicator springDotsIndicator = findViewById(R.id.spring_dots_indicator);

        //Init dotIndicator and PagerAdapter
        viewPager = findViewById(R.id.viewPager);
        adapter = new DetailAdapter(this);
        viewPager.setAdapter(adapter);
        springDotsIndicator.setViewPager(viewPager);
    }
}