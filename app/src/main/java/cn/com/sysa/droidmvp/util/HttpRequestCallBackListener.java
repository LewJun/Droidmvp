package cn.com.sysa.droidmvp.util;

/**
 * Created by LewJun on 2018/01/05.
 */
public interface HttpRequestCallBackListener<T> {


    void onStart();


    void onCacheSuccess();


    void onError(Throwable exception);


    void onSuccess(T body);


    void uploadProgress();


    void downloadProgress();
}
