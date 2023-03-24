package com.example.calculatorviewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MainViewModel() {
        calculatorModel = new CalculatorModel();
    }

    private CalculatorModel calculatorModel;
    private MutableLiveData<String> result;

    public MutableLiveData<String> getResult() {
        if (result == null) {
            result = new MutableLiveData<>();
        }
        return result;
    }

    public void add(int a, int b) {
        int data = calculatorModel.add(a, b);
        Log.e("add()", " add -> " + data);
        getResult().setValue(String.valueOf(data));
    }

    public void sub(int a, int b) {
        int data = calculatorModel.sub(a, b);
        Log.e("sub()", " sub -> " + data);
        getResult().setValue(String.valueOf(data));
    }

    public void multi(int a, int b) {
        getResult().setValue(String.valueOf(calculatorModel.multi(a, b)));
    }

    public void div(int a, int b) {
        getResult().setValue(String.valueOf(calculatorModel.div(a, b)));
    }
}
