package cn.com.sysa.droidmvp.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import cn.com.sysa.droidmvp.R;
import cn.com.sysa.droidmvp.base.BaseActivity;
import cn.com.sysa.droidmvp.main.MainActivity;

public class LoginActivity extends BaseActivity implements LoginContract.View, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;

    private LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        initParams();
    }

    @Override
    public void initParams() {
        presenter = new LoginPresenter(this, new LoginInteractorImpl());
    }

    @Override
    public void initViews() {
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progress);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        findViewById(R.id.btn_login).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                presenter.validateCredentials(username.getText().toString(), password.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void showProgress() {
        showView(progressBar);
    }

    @Override
    public void hideProgress() {
        hideView(progressBar);
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        MainActivity.launch(this);
        finish();
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }
}
