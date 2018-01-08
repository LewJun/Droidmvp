package cn.com.sysa.droidmvp.login;

/**
 * Created by LewJun on 2018/01/04.
 */
class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private LoginInteractor loginInteractor;

    LoginPresenter(LoginContract.View view, LoginInteractor loginInteractor) {
        this.view = view;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void validateCredentials(String username, String password) {
        view.showProgress();

        loginInteractor.login(username, password, new OnLoginFinishedListener() {
            @Override
            public void onUsernameError() {
                view.setUsernameError();
                view.hideProgress();
            }

            @Override
            public void onPasswordError() {
                view.setPasswordError();
                view.hideProgress();
            }

            @Override
            public void onSuccess() {
                view.navigateToHome();
            }

            @Override
            public void onError(String msg) {
                view.showMsg(msg);
            }
        });
    }

    @Override
    public void destroy() {
        view = null;
    }

    @Override
    public void start() {

    }
}
