package cn.com.sysa.droidmvp.base;

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
}
