package cn.com.sysa.droidmvp.base;

/**
 * Created by LewJun on 2018/01/04.
 */
public interface OnBaseListener {
    /**
     * 成功
     */
    void onSuccess();

    /**
     * 失败
     * @param msg 失败消息
     */
    void onError(String msg);
}
