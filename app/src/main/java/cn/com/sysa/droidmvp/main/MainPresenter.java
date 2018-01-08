package cn.com.sysa.droidmvp.main;

import cn.com.sysa.droidmvp.net.ApiResult;
import cn.com.sysa.droidmvp.net.ServerModel;
import cn.com.sysa.droidmvp.util.HttpRequestCallBackListener;

/**
 * Created by LewJun on 2018/01/05.
 */
public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private MainInteractor mainInteractor;

    MainPresenter(MainContract.View view, MainInteractor mainInteractor) {
        this.view = view;
        this.mainInteractor = mainInteractor;
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void getMethod() {
        String param1 = "param1";
        mainInteractor.getMethod(param1, new HttpRequestCallBackListener<ApiResult<ServerModel>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onCacheSuccess() {

            }

            @Override
            public void onError(Throwable exception) {

            }

            @Override
            public void onSuccess(ApiResult<ServerModel> body) {

            }

            @Override
            public void uploadProgress() {

            }

            @Override
            public void downloadProgress() {

            }
        });
    }
}
