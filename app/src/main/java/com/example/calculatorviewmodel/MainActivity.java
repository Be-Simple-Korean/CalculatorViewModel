package com.example.calculatorviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);


        viewModel.getResult().observe(this, result -> Log.e("MainActivity", "resullt ->" + result));

        delayRequest("+",1,2);
        delayRequest("-",3,1);
        delayRequest("*",2,2);
        delayRequest("/",3,4);

    }

    private void delayRequest(String operation,int a, int b){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (operation){
                    case "+":
                        viewModel.add(a, b);
                        break;
                    case "-":
                        viewModel.sub(a, b);
                        break;
                    case "*":
                        viewModel.multi(a, b);
                        break;
                    case "/":
                        viewModel.div(a, b);
                        break;
                    default:
                        break;
                }
            }
        },1000);
    }
}