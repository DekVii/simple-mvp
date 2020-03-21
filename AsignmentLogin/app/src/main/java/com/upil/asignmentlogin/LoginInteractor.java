package com.upil.asignmentlogin;

import android.os.Handler;
import android.text.TextUtils;

public class LoginInteractor {
    public interface OnLoginFinishedListener{
        void onUsernameError();

        void onPasswordError();

        void onLoginSucced(String username);

        void onLoginError();
    }

    public void canLogin(final String username, final String password, final OnLoginFinishedListener listener){
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                if (TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    return;
                }
                if (username.equalsIgnoreCase("Vina Aulia") && password.equalsIgnoreCase("0274")){
                    listener.onLoginSucced(username);
                    return;
                }
                listener.onLoginError();
            }
        }, 2000);
    }
}
