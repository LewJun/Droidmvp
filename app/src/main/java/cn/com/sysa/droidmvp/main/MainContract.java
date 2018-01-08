package cn.com.sysa.droidmvp.main;

import cn.com.sysa.droidmvp.base.BasePresenter;
import cn.com.sysa.droidmvp.base.BaseView;

/**
 * Created by LewJun on 2018/01/05.
 */
interface MainContract {
    interface View extends BaseView {
        /**
         * 设置method返回值
         *
         * @param text 值
         */
        void setMethodTxt(String text);
    }

    interface Presenter extends BasePresenter {
        /**
         * 调用getMethod值
         */
        void getMethod();
    }
}
