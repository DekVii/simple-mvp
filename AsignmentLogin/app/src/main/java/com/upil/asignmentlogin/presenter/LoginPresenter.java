package com.upil.asignmentlogin.presenter;

import com.upil.asignmentlogin.LoginInteractor;
import com.upil.asignmentlogin.view.LoginView;

public class LoginPresenter implements LoginInteractor.OnLoginFinishedListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenter(LoginView loginView, LoginInteractor loginInteractor){
        this.loginInteractor = loginInteractor;
        this.loginView = loginView;
    }

    public void validateCredentials(String username, String password){
        if (loginView != null){
            loginInteractor.canLogin(username, password, this);
        }
    }

    @Override
    public void onUsernameError() {
        if (loginView != null){
            loginView.setUsernameError();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null){
            loginView.setPasswordError();
        }
    }

    @Override
    public void onLoginSucced(String username) {
        if (loginView != null){
            loginView.onLoginSucced(username);
        }
    }

    @Override
    public void onLoginError() {
        if (loginView != null){
            loginView.onLoginError();
        }
    }
}
