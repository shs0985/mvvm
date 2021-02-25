package com.example.mvvm_java.ui.auth;

import android.view.View;

import androidx.lifecycle.ViewModel;

public class AuthViewModel extends ViewModel {
    String email = null;
    String password = null;

    AuthListener authListener = null;

    void onLoginButtonClick(View view){
        if(authListener == null)
            return;

        authListener.onStarted();
        if(email.isEmpty() || password.isEmpty()){
            authListener.onFailure("Invalied email or password");
        }

        authListener.onSuccess();
    }

}
