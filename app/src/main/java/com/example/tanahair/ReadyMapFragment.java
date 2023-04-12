package com.example.tanahair;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class ReadyMapFragment extends Fragment {

    Button startMap;
    private RecyclerView rvCultures;
    private ArrayList<Cultures> list = new ArrayList<>();

    public ReadyMapFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ready_map, container, false);

        rvCultures = view.findViewById(R.id.rvCultures);
//        rvCultures.setHasFixedSize(true);

        list.addAll(Data.getListData());
//        showRecyclerList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvCultures.setLayoutManager(layoutManager);

        ListAdapter listAdapter = new ListAdapter(list);
        rvCultures.setAdapter(listAdapter);

        view.findViewById(R.id.startMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MapsActivity.class));
            }
        });

        view.findViewById(R.id.startWeather).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), WeatherActivity.class));
            }
        });

        view.findViewById(R.id.startCompass).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), CompassActivity.class));
            }
        });

        view.findViewById(R.id.startCurrency).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), CurrencyActivity.class));
            }
        });

        return view;
    }

//    private void showRecyclerList(){
//        LinearLayoutManager layoutManager
//                = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
//        rvCultures.setLayoutManager(layoutManager);
//        ListAdapter listAdapter = new ListAdapter(list);
//        rvCultures.setAdapter(listAdapter);
//    }
}