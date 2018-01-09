package cn.com.sysa.droidmvp.util;

import com.lzy.okgo.model.Progress;

/**
 * Created by LewJun on 2018/01/05.
 */
public interface HttpRequestCallBackListener<T> {


    void onStart();


    void onCacheSuccess(T body);


    void onError(Throwable exception);


    void onSuccess(T body);


    void uploadProgress(Progress progress);


    void downloadProgress(Progress progress);

    void onFinish();
}
