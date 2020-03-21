package com.upil.asignmentlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.upil.asignmentlogin.presenter.LoginPresenter;
import com.upil.asignmentlogin.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    EditText edUser, edPass;
    Button btnLog;
    ProgressBar progressBar;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        loginPresenter = new LoginPresenter(this, new LoginInteractor());


    }

    void initViews() {
        edUser = findViewById(R.id.username);
        edPass = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressbar);
    }

    public void loginMe(View view){
        showProgressbar();
        loginPresenter.validateCredentials(edUser.getText().toString().trim(), edPass.getText().toString().trim());
    }


    @Override
    public void setUsernameError() {
        hideProgressbar();
        edUser.setError("Don't empty the Username!");
    }

    @Override
    public void setPasswordError() {
        hideProgressbar();
        edPass.setError("Don't empty the Password!");
    }

    @Override
    public void showProgressbar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onLoginSucced(String username) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    @Override
    public void onLoginError() {
        hideProgressbar();

        Toast.makeText(this, "Your Username or Password doesn't match", Toast.LENGTH_LONG).show();
    }
}
