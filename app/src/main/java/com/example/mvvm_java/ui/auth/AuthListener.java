package com.example.mvvm_java.ui.auth;

public interface AuthListener {
    void onStarted();
    void onSuccess();
    void onFailure(String message);
}
