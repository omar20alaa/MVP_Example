package com.mvp.omar.mvp_example.FirsrtActivity.Interactor;


import android.os.Handler;

public class LoginInteractorImplementation implements LoginInteractor
{

    @Override
    public void login(final String username,final String password,final OnLoginFinihedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (username.length() < 6 ){
                    listener.onUsernameError();
                    return;
                }
                else if (password.length() < 6){
                    listener.onPasswordError();
                    return;
                }
                else {
                    listener.onLoginFinish();
                }
            }
        } , 2000);
    }
}
