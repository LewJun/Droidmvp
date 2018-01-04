package cn.com.sysa.droidmvp.login;

/**
 * 登录业务
 * Created by LewJun on 2018/01/04.
 */
public interface LoginInteractor {
    /**
     * 登录验证
     * @param username 姓名
     * @param password 密码
     * @param listener 回调
     */
    void login(String username, String password, OnLoginFinishedListener listener);
}
