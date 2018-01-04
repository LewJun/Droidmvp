package cn.com.sysa.droidmvp.login;

/**
 * Created by LewJun on 2018/01/04.
 */
public interface OnLoginFinishedListener {
    void onUsernameError();

    void onPasswordError();

    void onSuccess();
}
