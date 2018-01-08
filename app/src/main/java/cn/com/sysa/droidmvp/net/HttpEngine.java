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

import android.util.Log;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.lang.reflect.Type;
import java.util.Map;

import cn.com.sysa.droidmvp.util.HttpRequestCallBackListener;

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

    public <T> void get(String url, Map<String, String> paramMap, final Type typeOfT, final HttpRequestCallBackListener<T> listener) {
        OkGo.<T>get(url)
                .execute(new Callback<T>() {
                    @Override
                    public void onStart(Request<T, ? extends Request> request) {
                        Log.d(TAG, "onStart: ");
                    }

                    @Override
                    public void onSuccess(Response<T> response) {
                        Log.d(TAG, "onSuccess: ");
                        listener.onSuccess(response.body());
                    }

                    @Override
                    public void onCacheSuccess(Response<T> response) {
                        Log.d(TAG, "onCacheSuccess: " + response.body());
                    }

                    @Override
                    public void onError(Response<T> response) {
                        Log.d(TAG, "onError: ");
                        listener.onError(response.getException());
                    }

                    @Override
                    public void onFinish() {
                        Log.d(TAG, "onFinish: ");
                    }

                    @Override
                    public void uploadProgress(Progress progress) {
                        Log.d(TAG, "uploadProgress: " + progress);
                    }

                    @Override
                    public void downloadProgress(Progress progress) {
                        Log.d(TAG, "downloadProgress: " + progress);
                    }

                    @Override
                    public T convertResponse(okhttp3.Response response) throws Throwable {
                        Log.d(TAG, "convertResponse: " + response.body().contentType().type());
                        return null;
                    }
                });
    }
}
