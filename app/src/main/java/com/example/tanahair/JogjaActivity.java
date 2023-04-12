package com.example.tanahair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class JogjaActivity extends AppCompatActivity {
    private boolean isFragmentDisplayed = false;
    ImageView help;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogja);

        help = findViewById(R.id.help);

        findViewById(R.id.jogja).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(JogjaActivity.this, DetailActivity.class));
            }
        });

        findViewById(R.id.help).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFragmentDisplayed) {
                    displayFragment();
                } else {
                    closeFragment();
                }
            }
        });

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(JogjaActivity.this, MainActivity.class));
            }
        });
    }

    public void displayFragment() {
        SimpleFragment simpleFragment = SimpleFragment.newInstance();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        help.setImageResource(R.drawable.close);

        fragmentTransaction.add(R.id.fragment_container,
                simpleFragment).addToBackStack(null).commit();
        isFragmentDisplayed = true;
    }

    public void closeFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();

        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager
                .findFragmentById(R.id.fragment_container);

        if (simpleFragment != null) {

            FragmentTransaction fragmentTransaction =
                    fragmentManager.beginTransaction();
            fragmentTransaction.remove(simpleFragment).commit();
        }

        help.setImageResource(R.drawable.help);

        isFragmentDisplayed = false;
    }
}