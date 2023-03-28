package com.example.tanahair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CultureActivity extends AppCompatActivity {

    private RecyclerView rvCultures;
    private ArrayList<Cultures> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture);

        rvCultures = findViewById(R.id.rvCultures);
        rvCultures.setHasFixedSize(true);

        list.addAll(Data.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvCultures.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(list);
        rvCultures.setAdapter(listAdapter);
    }
}