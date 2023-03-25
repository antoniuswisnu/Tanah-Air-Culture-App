package com.example.tanahair;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class DetailAdapter extends PagerAdapter {

    Context ctx;

    public DetailAdapter(Context ctx) {
        this.ctx = ctx;
    }


    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        LayoutInflater layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_detail,container,false);

        ImageView img = view.findViewById(R.id.img);
        TextView tv2 = view.findViewById(R.id.tv2);
        SpringDotsIndicator springDotsIndicator = view.findViewById(R.id.spring_dots_indicator);

        switch (position)
        {
            case 0:
                img.setImageResource(R.drawable.gudeg1);

                tv2.setText(R.string.gudeg1);
                springDotsIndicator.setVisibility(View.INVISIBLE);
                break;
            case 1:
                img.setImageResource(R.drawable.gudeg2);

                tv2.setText(R.string.gudeg2);
                springDotsIndicator.setVisibility(View.INVISIBLE);
                break;
            case 2:
                img.setImageResource(R.drawable.gudeg3);

                tv2.setText(R.string.gudeg3);
                springDotsIndicator.setVisibility(View.INVISIBLE);
                break;
        }
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}