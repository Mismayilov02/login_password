package com.example.m.ismayilov.login_password;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.m.ismayilov.login_password.databinding.FragmentCreatePasswordBinding;

import java.util.ArrayList;
import java.util.List;


public class Create_Password extends Fragment {

    FragmentCreatePasswordBinding binding;
    View v;
    SharedPreferenceManager sharedPreferenceManager;
    List<RadioButton> radioList1 = new ArrayList<>();
    List<RadioButton> radioList2 = new ArrayList<>();

    String password1 ="" , gpassword2 = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater ,R.layout.fragment_create__password, container, false);
        v =binding.getRoot();

        sharedPreferenceManager = new SharedPreferenceManager(getActivity());
        radioList2.add(binding.radio1);
        radioList2.add(binding.radio2);
        radioList2.add(binding.radio3);
        radioList2.add(binding.radio4);
        radioList1.add(binding.radio5);
        radioList1.add(binding.radio6);
        radioList1.add(binding.radio7);
        radioList1.add(binding.radio8);

        binding.btn0.setOnClickListener(view -> {
            poswordCheck("0");
        });
        binding.btn1.setOnClickListener(view -> {
            poswordCheck("1");
        });
        binding.btn2.setOnClickListener(view -> {
            poswordCheck("2");
        });
        binding.btn3.setOnClickListener(view -> {
            poswordCheck("3");
        });
        binding.btn4.setOnClickListener(view -> {
            poswordCheck("4");
        });
        binding.btn5.setOnClickListener(view -> {
            poswordCheck("5");
        });
        binding.btn6.setOnClickListener(view -> {
            poswordCheck("6");
        });
        binding.btn7.setOnClickListener(view -> {
            poswordCheck("7");
        });
        binding.btn8.setOnClickListener(view -> {
            poswordCheck("8");
        });
        binding.btn9.setOnClickListener(view -> {
            poswordCheck("9");
        });

        binding.btne.setOnClickListener(view -> {
            getActivity().finish();
        });


        binding.btnx.setOnClickListener(view -> {
            if(gpassword2.length()>0){
                gpassword2 =gpassword2.substring(0 , gpassword2.length()-1);
                radio2True(gpassword2.length());
                System.out.println(gpassword2);
            }else if(password1.length() > 0){
              password1 =  password1.substring(0 , password1.length() -1);
                radio1True(password1.length());
                System.out.println(password1);
            }
        });

        return  v;

    }


public void poswordCheck(String number){
        if(password1.length() <= 3){
            password1 += number;
            radio1True(password1.length());
        }else if(gpassword2.length() <=3){
            gpassword2 += number;
            radio2True(gpassword2.length());
        }

        checkPasswordEguals();
}

public void checkPasswordEguals(){
        if(password1.length() == 4 && gpassword2.length() == 4){
            if (password1.equals(gpassword2)){
                Navigation.findNavController(v).navigate(R.id.navhost_create_to_login);
                sharedPreferenceManager.setValue("password" , password1);
                sharedPreferenceManager.setValue("create_pasword" , true);
            }else {
                password1 ="";
                radio1True(password1.length());
                gpassword2= "";
                radio2True(gpassword2.length());

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

    public void radio2True(int size){
        for(int i = 0 ; i<4 ; i++){
            if(i<size){
                radioList2.get(i).setChecked(true);
            }else {
                radioList2.get(i).setChecked(false);
            }

        }
    }

}