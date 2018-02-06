package com.mvp.omar.mvp_example.FirsrtActivity.Presenter;


import com.mvp.omar.mvp_example.FirsrtActivity.Interactor.LoginInteractor;
import com.mvp.omar.mvp_example.FirsrtActivity.Interactor.LoginInteractorImplementation;
import com.mvp.omar.mvp_example.FirsrtActivity.View.LoginView;

public class LoginPresenterImplementation implements LoginPresenter, LoginInteractorImplementation.OnLoginFinihedListener {

    LoginView loginView;
    LoginInteractor loginInteractor;

    public LoginPresenterImplementation(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImplementation();
    }

    @Override
    public void validation(String username, String password) {
    loginView.showProgressBar();
    loginInteractor.login(username , password ,this);
    }

    @Override
    public void onUsernameError() {
        loginView.setUsernameError();
        loginView.hideProgressBar();
    }

    @Override
    public void onPasswordError() {
        loginView.setPasswordError();
        loginView.hideProgressBar();

    }

    @Override
    public void onLoginFinish() {
        loginView.setNavigationDone();
        loginView.hideProgressBar();

    }
}
