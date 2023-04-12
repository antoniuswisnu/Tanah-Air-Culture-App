package com.example.tanahair;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SimpleFragment extends Fragment {

    TextView dialog;
    ImageView karakter;
    public SimpleFragment() {
    }

    public static SimpleFragment newInstance(){
        return new SimpleFragment();
    }

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_simple_fragment, container, false);

        dialog = rootView.findViewById(R.id.dialog);
        karakter = rootView.findViewById(R.id.karakter);

        rootView.findViewById(R.id.awan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setText(R.string.dialog_2);
                karakter.setImageResource(R.drawable.doni);
            }
        });

        return rootView;
    }
}