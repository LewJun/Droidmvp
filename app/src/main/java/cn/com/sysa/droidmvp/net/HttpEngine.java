/**
 * Copyright (C) 2015. Keegan小钢（http://keeganlee.me）
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.com.sysa.droidmvp.net;

import android.graphics.Bitmap;
import android.util.Log;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.callback.BitmapCallback;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.base.Request;

import java.io.File;
import java.lang.reflect.Type;
import java.util.Map;

import cn.com.sysa.droidmvp.util.FileUtil;
import cn.com.sysa.droidmvp.util.HttpRequestCallBackListener;
import okhttp3.ResponseBody;

public class HttpEngine {
    private static final String TAG = "HttpEngine";
    private static HttpEngine instance = null;

    private HttpEngine() {

    }

    public static HttpEngine getInstance() {
        if (instance == null) {
            instance = new HttpEngine();
        }
        return instance;
    }

    /**
     * 得到Bitmap
     * @param tag
     * @param url
     * @param params
     * @param listener
     */
    public void getBitmap(final Object tag, final String url, final Map<String, String> params, final HttpRequestCallBackListener<Bitmap> listener) {
        GetRequest<Bitmap> request = OkGo.<Bitmap>get(url)
                .tag(tag);

        request.execute(new BitmapCallback() {
            @Override
            public void onStart(Request<Bitmap, ? extends Request> request) {
                super.onStart(request);
                listener.onStart();
            }

            @Override
            public void onCacheSuccess(Response<Bitmap> response) {
                super.onCacheSuccess(response);
                listener.onCacheSuccess(response.body());
            }

            @Override
            public void onError(Response<Bitmap> response) {
                super.onError(response);
                listener.onError(response.getException());
            }

            @Override
            public void onFinish() {
                super.onFinish();
                listener.onFinish();
            }

            @Override
            public void uploadProgress(Progress progress) {
                super.uploadProgress(progress);
                listener.uploadProgress(progress);
            }

            @Override
            public void downloadProgress(Progress progress) {
                super.downloadProgress(progress);
                listener.downloadProgress(progress);
            }

            @Override
            public void onSuccess(Response<Bitmap> response) {
                listener.onSuccess(response.body());
            }
        });
    }

    /**
     *  文件下载
     * @param tag
     * @param url
     * @param params
     * @param listener
     */
    public void downloadFile(Object tag, String url, Map<String, String> params, final HttpRequestCallBackListener<File> listener) {
        GetRequest<File> request = OkGo.<File>get(url)
                .tag(tag);

        request.execute(new FileCallback(FileUtil.getDownloadPath(), null) {
            @Override
            public void onStart(Request<File, ? extends Request> request) {
                super.onStart(request);
                Log.d(TAG, "onStart: ");
                listener.onStart();
            }

            @Override
            public void onSuccess(Response<File> response) {
                Log.d(TAG, "onSuccess: ");
                listener.onSuccess(response.body());
            }

            @Override
            public void onCacheSuccess(Response<File> response) {
                super.onCacheSuccess(response);
                Log.d(TAG, "onCacheSuccess: ");
                listener.onCacheSuccess(response.body());
            }

            @Override
            public void onError(Response<File> response) {
                super.onError(response);
                Log.d(TAG, "onError: ");
                listener.onError(response.getException());
            }

            @Override
            public void onFinish() {
                super.onFinish();
                Log.d(TAG, "onFinish: ");
                listener.onFinish();
            }

            @Override
            public void uploadProgress(Progress progress) {
                super.uploadProgress(progress);
                Log.d(TAG, "uploadProgress: ");
                listener.uploadProgress(progress);
            }

            @Override
            public void downloadProgress(Progress progress) {
                super.downloadProgress(progress);
                Log.d(TAG, "downloadProgress: ");
                listener.downloadProgress(progress);
            }
        });
    }

    /**
     * 得到api result
     * @param tag
     * @param url
     * @param params
     * @param typeOfT
     * @param listener
     * @param <T>
     */
    public <T> void getApiResult(Object tag, String url, Map<String, String> params, final Type typeOfT, final HttpRequestCallBackListener<T> listener) {
        GetRequest<T> request = OkGo.<T>get(url).tag(tag);
        request.execute(new AbsCallback<T>() {
            @Override
            public void onSuccess(Response<T> response) {
                Log.d(TAG, "onSuccess: " + response.body());
                listener.onSuccess(response.body());
            }

            @Override
            public T convertResponse(okhttp3.Response response) throws Throwable {
                ResponseBody responseBody = response.body();
                String string = responseBody.string();
                Log.d(TAG, "convertResponse: " + string);
                return new Gson().fromJson(string, typeOfT);
            }

            @Override
            public void onStart(Request<T, ? extends Request> request) {
                super.onStart(request);
                Log.d(TAG, "onStart: ");
                listener.onStart();
            }

            @Override
            public void onCacheSuccess(Response<T> response) {
                super.onCacheSuccess(response);
                Log.d(TAG, "onCacheSuccess: ");
                listener.onCacheSuccess(response.body());
            }

            @Override
            public void onError(Response<T> response) {
                super.onError(response);
                Log.d(TAG, "onError: ");
                listener.onError(response.getException());
            }

            @Override
            public void onFinish() {
                super.onFinish();
                Log.d(TAG, "onFinish: ");
                listener.onFinish();
            }
        });
    }

    /**
     * 取消请求
     * @param obj
     */
    public void cancel(Object obj) {
        OkGo.getInstance().cancelTag(obj);
    }

}
