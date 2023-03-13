package com.example.tanahair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp1 extends AppCompatActivity {

    Button btnAdventurer, btnMerchant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);

        btnAdventurer = findViewById(R.id.btnAdventurer);
        btnMerchant = findViewById(R.id.btnMerchant);

        btnAdventurer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp1.this, SignUp2.class);
                startActivity(intent);
            }
        });

        btnMerchant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp1.this, SignUp2.class);
                startActivity(intent);
            }
        });

    }
}