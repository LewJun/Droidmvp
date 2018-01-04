package cn.com.sysa.droidmvp.login;

/**
 * Created by LewJun on 2018/01/04.
 */
public interface LoginInteractor {

    void login(String username, String password, OnLoginFinishedListener listener);

}
