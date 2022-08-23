package com.example.m.ismayilov.login_password;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.m.ismayilov.login_password.databinding.FragmentLoginPasswordBinding;

import java.util.ArrayList;
import java.util.List;


public class Login_Password extends Fragment {

    FragmentLoginPasswordBinding binding;
 String password1 = "";
 SharedPreferenceManager sharedPreferenceManager;
    List<RadioButton> radioList1 = new ArrayList<>();
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater ,R.layout.fragment_login__password, container, false);
        v = binding.getRoot();

        sharedPreferenceManager = new SharedPreferenceManager(getActivity());
        sharedPreferenceManager.getString("password" , "de");
        radioList1.add(binding.radio1);
        radioList1.add(binding.radio2);
        radioList1.add(binding.lradio3);
        radioList1.add(binding.radio4);

        binding.lbtnx.setOnClickListener(view -> {
            if(password1.length() > 0){
                password1 =  password1.substring(0 , password1.length() -1);
                radio1True(password1.length());
                System.out.println(password1);
            }
        });


        binding.lbtn0.setOnClickListener(view -> {
            poswordCheck("0");
        });
        binding.lbtn1.setOnClickListener(view -> {
            poswordCheck("1");
        });
        binding.lbtn2.setOnClickListener(view -> {
            poswordCheck("2");
        });
        binding.lbtn3.setOnClickListener(view -> {
            poswordCheck("3");
        });
        binding.lbtn4.setOnClickListener(view -> {
            poswordCheck("4");
        });
        binding.lbtn5.setOnClickListener(view -> {
            poswordCheck("5");
        });
        binding.lbtn6.setOnClickListener(view -> {
            poswordCheck("6");
        });
        binding.lbtn7.setOnClickListener(view -> {
            poswordCheck("7");
        });
        binding.lbtn8.setOnClickListener(view -> {
            poswordCheck("8");
        });
        binding.lbtn9.setOnClickListener(view -> {
            poswordCheck("9");
        });

        binding.btne.setOnClickListener(view -> {
            getActivity().finish();
        });



        return v;
    }

    public void poswordCheck(String number){
        if(password1.length() <= 3){
            password1 += number;
            radio1True(password1.length());
        }

        checkPasswordEguals();
    }
    public void checkPasswordEguals(){
        if(password1.length() == 4 ){
            if (password1.equals(sharedPreferenceManager.getString("password" , "88888888888"))){
                binding.loginText.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity() , "succes login" ,Toast.LENGTH_SHORT).show();
            }else {
                password1 ="";
                radio1True(password1.length());
            }
        }
    }

    public void radio1True(int size){
        for(int i = 0 ; i<4 ; i++){
            if(i<size){
                radioList1.get(i).setChecked(true);
            }else {
                radioList1.get(i).setChecked(false);
            }

        }
    }
}