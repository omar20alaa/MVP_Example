package com.mvp.omar.mvp_example.FirsrtActivity.Interactor;


    public interface LoginInteractor {

    interface OnLoginFinihedListener {

        void onUsernameError();

        void onPasswordError();

        void onLoginFinish();

    }

    void login(String username, String password, OnLoginFinihedListener listener);

}
