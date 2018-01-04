package cn.com.sysa.droidmvp.login;

import cn.com.sysa.droidmvp.base.OnBaseListener;

/**
 * Created by LewJun on 2018/01/04.
 */
public interface OnLoginFinishedListener extends OnBaseListener {
    /**
     * 姓名错误
     */
    void onUsernameError();

    /**
     * 密码错误
     */
    void onPasswordError();
}
