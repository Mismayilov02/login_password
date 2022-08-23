package com.example.m.ismayilov.login_password;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Splash extends Fragment {
    SharedPreferenceManager sharedPreferenceManager;

    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_splash, container, false);
        sharedPreferenceManager = new SharedPreferenceManager(getActivity());


        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(sharedPreferenceManager.getBoolean("create_pasword" , false)){
                    Navigation.findNavController(v).navigate(R.id.navhost_splash_tologin);
                }
                else  {
                    Navigation.findNavController(v).navigate(R.id.navhost_splash_tocreate);
                }
            }
        };handler.postDelayed(runnable , 3000);

        return  v;
    }
}