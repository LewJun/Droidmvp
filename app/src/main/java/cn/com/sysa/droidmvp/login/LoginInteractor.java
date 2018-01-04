package cn.com.sysa.droidmvp.login;

/**
 * 登录业务
 * Created by LewJun on 2018/01/04.
 */
public interface LoginInteractor {
    void login(String username, String password, OnLoginFinishedListener listener);
}
