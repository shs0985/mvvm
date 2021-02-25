package com.example.mvvm_java.util;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ViewUtils{
    public static void toast(String message, Context context){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void show(ProgressBar progressBar){
        progressBar.setVisibility(View.VISIBLE);
    }

    public static void hide(ProgressBar progressBar){
        progressBar.setVisibility(View.GONE);
    }
}