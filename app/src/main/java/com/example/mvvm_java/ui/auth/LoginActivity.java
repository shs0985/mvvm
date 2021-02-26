package com.example.mvvm_java.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.mvvm_java.R;
import com.example.mvvm_java.databinding.ActivityLoginBinding;
import com.example.mvvm_java.util.ViewUtils;

public class LoginActivity extends AppCompatActivity implements AuthListener {
    private ViewModelProvider.AndroidViewModelFactory viewModelFactory;
    private ActivityLoginBinding binding;
    private AuthViewModel viewModel;
    private ProgressBar progressBar;// = findViewById(R.id.progress_bar);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        progressBar = findViewById(R.id.progress_bar);

        //binding.setLifecycleOwner(this);

        if(viewModelFactory == null){
            viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        }

        viewModel = new ViewModelProvider(this, viewModelFactory).get(AuthViewModel.class);
        binding.setViewmodel(viewModel);

        viewModel.setAuthListener(this);
    }

    @Override
    public void onStarted() {
        ViewUtils.show(progressBar);
    }

    @Override
    public void onSuccess() {
        ViewUtils.hide(progressBar);
    }

    @Override
    public void onFailure(String message) {
        ViewUtils.toast(message, this);
        ViewUtils.hide(progressBar);
    }

}