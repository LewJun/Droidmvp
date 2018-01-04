package cn.com.sysa.droidmvp.login;

/**
 * Created by LewJun on 2018/01/04.
 */
public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}
