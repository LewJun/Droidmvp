package cn.com.sysa.droidmvp.base;

import android.view.View;

/**
 * Created by LewJun on 2018/01/04.
 */
public interface BaseView {

    /**
     * 初始化视图
     */
    void initViews();

    /**
     * 显示消息
     *
     * @param msg 消息
     */
    void showMsg(String msg);

    /**
     * finish
     */
    void finish();

    /**
     * 显示View
     *
     * @param view View
     */
    void showView(View view);

    /**
     * 隐藏View
     *
     * @param view View
     */
    void hideView(View view);

    /**
     * 显示或隐藏
     *
     * @param view   View
     * @param isShow 是否显示
     */
    void showOrHideView(View view, boolean isShow);

    /**
     * 显示滚动条
     */
    void showProgress();

    /**
     * 隐藏滚动条
     */
    void hideProgress();

}
