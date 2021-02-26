package com.example.mvvm_java.ui.auth;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm_java.R;

public class AuthViewModel extends ViewModel {

    AuthListener authListener = null;

    public String email = null;
    public String password = null;

//    public void emil(String email){
//        this.email = email;
//    }
//    public void password(String password){
//        this.password = password;
//    }

    public void setAuthListener(AuthListener authListener) {
        this.authListener = authListener;
    }

    public void onLoginButtonClick(View view){
        if(authListener == null)
            return;

        authListener.onStarted();
        if(email.isEmpty() || password.isEmpty()){
            authListener.onFailure("Invalied email or password");
        }

        authListener.onSuccess();
        Log.d("email", email);
        Log.d("password", password);
    }

}
