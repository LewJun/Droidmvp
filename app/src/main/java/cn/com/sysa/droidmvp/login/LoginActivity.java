package cn.com.sysa.droidmvp.login;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.sysa.droidmvp.R;
import cn.com.sysa.droidmvp.base.BaseActivity;
import cn.com.sysa.droidmvp.main.MainActivity;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.progress) ProgressBar progressBar;
    @BindView(R.id.username) EditText username;
    @BindView(R.id.password) EditText password;

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
    }

    @OnClick(R.id.btn_login)
    public void login() {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
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
