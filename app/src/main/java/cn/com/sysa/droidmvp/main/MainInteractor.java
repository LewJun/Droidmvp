package cn.com.sysa.droidmvp.main;

import android.graphics.Bitmap;

import java.io.File;

import cn.com.sysa.droidmvp.net.ApiResult;
import cn.com.sysa.droidmvp.model.ServerModel;
import cn.com.sysa.droidmvp.util.HttpRequestCallBackListener;

/**
 * Created by LewJun on 2018/01/05.
 */
public interface MainInteractor {
    void getBitmap(Object obj, String param1, HttpRequestCallBackListener<Bitmap> listener);
    void downloadFile(Object obj, String param1, HttpRequestCallBackListener<File> listener);

    void getJsonObject(Object obj, String param1, HttpRequestCallBackListener<ApiResult<ServerModel>> httpRequestCallBackListener);

    void destroy(Object obj);
}