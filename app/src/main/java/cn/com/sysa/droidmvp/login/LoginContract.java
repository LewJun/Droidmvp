package cn.com.sysa.droidmvp.login;

import cn.com.sysa.droidmvp.base.BasePresenter;
import cn.com.sysa.droidmvp.base.BaseView;

/**
 * 登录契约
 * Created by LewJun on 2018/01/04.
 */
public interface LoginContract {
    interface View extends BaseView {
        /**
         * 显示滚动条
         */
        void showProgress();

        /**
         * 隐藏滚动条
         */
        void hideProgress();

        /**
         * 显示姓名错误信息
         */
        void setUsernameError();

        /**
         * 显示密码错误信息
         */
        void setPasswordError();

        /**
         * 进入首页
         */
        void navigateToHome();
    }

    interface Presenter extends BasePresenter {
        /**
         * 登录验证
         *
         * @param username 姓名
         * @param password 密码
         */
        void validateCredentials(String username, String password);
    }

}
