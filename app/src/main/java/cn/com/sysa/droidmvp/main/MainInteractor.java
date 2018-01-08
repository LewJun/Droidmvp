package cn.com.sysa.droidmvp.main;

import cn.com.sysa.droidmvp.net.ApiResult;
import cn.com.sysa.droidmvp.net.ServerModel;
import cn.com.sysa.droidmvp.util.HttpRequestCallBackListener;

/**
 * Created by LewJun on 2018/01/05.
 */
public interface MainInteractor {
    void getMethod(String param1, HttpRequestCallBackListener<ApiResult<ServerModel>> listener);
}
