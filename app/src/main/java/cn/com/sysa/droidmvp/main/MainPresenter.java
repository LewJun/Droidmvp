package cn.com.sysa.droidmvp.main;

import android.graphics.Bitmap;
import android.util.Log;

import com.lzy.okgo.model.Progress;

import java.io.File;

import cn.com.sysa.droidmvp.net.ApiResult;
import cn.com.sysa.droidmvp.net.ServerModel;
import cn.com.sysa.droidmvp.util.HttpRequestCallBackListener;

/**
 * Created by LewJun on 2018/01/05.
 */
public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private MainInteractor mainInteractor;

    private static final String TAG = "MainPresenter";

    MainPresenter(MainContract.View view, MainInteractor mainInteractor) {
        this.view = view;
        this.mainInteractor = mainInteractor;
    }

    @Override
    public void start() {
        Log.d(TAG, "start: ");
    }

    @Override
    public void destroy() {
        Log.d(TAG, "destroy: ");
        mainInteractor.destroy(this);
    }

    @Override
    public void getImage() {
        Log.d(TAG, "getImage: ");
        String param1 = "param1";
        mainInteractor.getBitmap(this, param1, new HttpRequestCallBackListener<Bitmap>() {
            @Override
            public void onStart() {
                Log.d(TAG, "onStart: ");
                view.showProgress();
            }

            @Override
            public void onCacheSuccess(Bitmap body) {
                Log.d(TAG, "onCacheSuccess: ");
            }

            @Override
            public void onError(Throwable exception) {
                Log.e(TAG, "onError: ", exception);
            }

            @Override
            public void onSuccess(Bitmap body) {
                Log.d(TAG, "onSuccess: ");
                view.setImage(body);
            }

            @Override
            public void uploadProgress(Progress progress) {
                Log.d(TAG, "uploadProgress: ");
            }

            @Override
            public void downloadProgress(Progress progress) {
                Log.d(TAG, "downloadProgress: ");
            }

            @Override
            public void onFinish() {
                Log.d(TAG, "onFinish: ");
                view.hideProgress();
            }
        });
    }

    @Override
    public void downloadFile() {
        Log.d(TAG, "downloadFile: ");
        String param1 = "param1";
        mainInteractor.downloadFile(this, param1, new HttpRequestCallBackListener<File>() {
            @Override
            public void onStart() {
                Log.d(TAG, "onStart: ");
            }

            @Override
            public void onCacheSuccess(File body) {
                Log.d(TAG, "onCacheSuccess: ");
            }

            @Override
            public void onError(Throwable exception) {
                Log.e(TAG, "onError: ", exception);
            }

            @Override
            public void onSuccess(File body) {
                Log.d(TAG, "onSuccess: " + body.getAbsolutePath());
            }

            @Override
            public void uploadProgress(Progress progress) {
                Log.d(TAG, "uploadProgress: ");
            }

            @Override
            public void downloadProgress(Progress progress) {
                Log.d(TAG, "downloadProgress: " + progress);
                view.updateDownloadProgress((int) (progress.fraction * 100));
            }

            @Override
            public void onFinish() {
                Log.d(TAG, "onFinish: ");
            }
        });
    }

    @Override
    public void getJsonObject() {
        Log.d(TAG, "getApiResult: ");
        String param1 = "param1";

        mainInteractor.getJsonObject(this, param1, new HttpRequestCallBackListener<ApiResult<ServerModel>>() {
            @Override
            public void onStart() {
                Log.d(TAG, "onStart: ");
            }

            @Override
            public void onCacheSuccess(ApiResult<ServerModel> body) {
                Log.d(TAG, "onCacheSuccess: ");
            }

            @Override
            public void onError(Throwable exception) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onSuccess(ApiResult<ServerModel> body) {
                Log.d(TAG, "onSuccess: " + body.data.url);
                view.setString(body.data.author.github);
            }

            @Override
            public void uploadProgress(Progress progress) {
                Log.d(TAG, "uploadProgress: ");

            }

            @Override
            public void downloadProgress(Progress progress) {
                Log.d(TAG, "downloadProgress: ");

            }

            @Override
            public void onFinish() {
                Log.d(TAG, "onFinish: ");

            }
        });
    }
}
