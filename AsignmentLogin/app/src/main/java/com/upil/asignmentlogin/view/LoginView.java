package com.upil.asignmentlogin.view;

public interface LoginView {
    void setUsernameError();
    void setPasswordError();
    void showProgressbar();
    void hideProgressbar();
    void onLoginSucced(String username);
    void onLoginError();
}
