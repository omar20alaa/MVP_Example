package com.mvp.omar.mvp_example.FirsrtActivity.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mvp.omar.mvp_example.FirsrtActivity.Presenter.LoginPresenter;
import com.mvp.omar.mvp_example.FirsrtActivity.Presenter.LoginPresenterImplementation;
import com.mvp.omar.mvp_example.R;
import com.mvp.omar.mvp_example.SecondActivity.View.SecondActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter presenter;

    //FindingUsername
    @BindView(R.id.edUsername)
    EditText username;

    //FindingPassword
    @BindView(R.id.edPassword)
    EditText password;

    //FindingButtonLogin
    @BindView(R.id.btnLogin)
    Button btnLogin;

    //FindingProgressbar
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;

    //when button clicked
    @OnClick(R.id.btnLogin)
    public void submit() {
        presenter.validation(username.getText().toString(), password.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ButterKnife.bind(this);

        presenter = new LoginPresenterImplementation(this);
    }

    @Override
    public void showProgressBar() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        pbLoading.setVisibility(View.GONE);

    }

    @Override
    public void setUsernameError() {
        username.setError("You enter wrong username");
    }

    @Override
    public void setPasswordError() {
        password.setError("You enter wrong password");

    }

    @Override
    public void setNavigationDone() {

        Toast.makeText(this, "Done Successfully", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
}
