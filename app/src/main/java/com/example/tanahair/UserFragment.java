package com.example.tanahair;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class UserFragment extends Fragment {

    static SharedPreferences mSharedPref;
    private final String sharedPrefFile = "com.example.tanahair";
    private Boolean mLogin;
    static String KEY = "key";

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        SharedPreferences mSharedPref = this.getActivity().getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE);
        mLogin = mSharedPref.getBoolean(KEY, false);

//        view.findViewById(R.id.btnLogout).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences.Editor editor = mSharedPref.edit();
//                editor.putBoolean(KEY, false);
//                editor.apply();
//                Toast.makeText(getContext(), "Logout Success", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(getContext(), LoginActivity.class));
//            }
//        });

        view.findViewById(R.id.language).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
            }
        });

        return view;
    }
}