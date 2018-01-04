package cn.com.sysa.droidmvp.login;

/**
 * Created by LewJun on 2018/01/04.
 */
public class LoginPresenter implements LoginContract.Presenter, OnLoginFinishedListener {

    private LoginContract.View view;
    private LoginInteractor loginInteractor;

    public LoginPresenter(LoginContract.View view, LoginInteractor loginInteractor) {
        this.view = view;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (view != null) {
            view.showProgress();
        }

        loginInteractor.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void onUsernameError() {
        if (view != null) {
            view.setUsernameError();
            view.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (view != null) {
            view.setPasswordError();
            view.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (view != null) {
            view.navigateToHome();
        }
    }
}
