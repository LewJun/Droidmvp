package cn.com.sysa.droidmvp.main;

import android.graphics.Bitmap;

import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import cn.com.sysa.droidmvp.net.ApiResult;
import cn.com.sysa.droidmvp.net.HttpEngine;
import cn.com.sysa.droidmvp.net.ServerModel;
import cn.com.sysa.droidmvp.util.HttpRequestCallBackListener;
import cn.com.sysa.droidmvp.util.Urls;

/**
 * Created by LewJun on 2018/01/05.
 */
public class MainInteractorImpl implements MainInteractor {
    @Override
    public void getBitmap(Object obj, String param1, HttpRequestCallBackListener<Bitmap> listener) {
        Map<String, String> params = new HashMap<>();
        params.put("param1", param1);
        HttpEngine.getInstance().getBitmap(obj, Urls.URL_IMAGE, params, listener);
    }

    @Override
    public void downloadFile(Object obj, String param1, HttpRequestCallBackListener<File> listener) {
        HttpEngine.getInstance().downloadFile(obj, Urls.URL_DOWNLOAD, null, listener);
    }

    @Override
    public void getJsonObject(Object obj, String param1, HttpRequestCallBackListener<ApiResult<ServerModel>> listener) {
        HttpEngine.getInstance().getApiResult(this, Urls.URL_JSONOBJECT, null, new TypeToken<ApiResult<ServerModel>>() {
        }.getType(), listener);
    }

    @Override
    public void destroy(Object obj) {
        HttpEngine.getInstance().cancel(obj);
    }
}
