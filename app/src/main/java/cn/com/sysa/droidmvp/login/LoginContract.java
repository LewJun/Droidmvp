package cn.com.sysa.droidmvp.login;

/**
 * 登录契约
 * Created by LewJun on 2018/01/04.
 */
public interface LoginContract {
    interface View {
        void showProgress();

        void hideProgress();

        void setUsernameError();

        void setPasswordError();

        void navigateToHome();
    }

    interface Presenter {
        void validateCredentials(String username, String password);

        void onDestroy();
    }

}
