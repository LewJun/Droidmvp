package cn.com.sysa.droidmvp.login;

/**
 * Created by LewJun on 2018/01/04.
 */
public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
