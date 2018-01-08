package cn.com.sysa.droidmvp.main;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
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
    public void getMethod(String param1, HttpRequestCallBackListener<ApiResult<ServerModel>> listener) {
        {
            System.out.println("------------------------------------------->");
            String url = Urls.URL_METHOD;
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("param1", param1);
            HttpEngine.getInstance().get(url, paramMap, null, listener);
            System.out.println("<-------------------------------------------");
        }

        {
            System.out.println("------------------------------------------->");
            String url = Urls.URL_IMAGE;
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("param1", param1);
            HttpEngine.getInstance().get(url, paramMap, null, listener);
            System.out.println("<-------------------------------------------");
        }

        {
            System.out.println("------------------------------------------->");
            String url = Urls.URL_DOWNLOAD;
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("param1", param1);
            HttpEngine.getInstance().get(url, paramMap, null, listener);
            System.out.println("<-------------------------------------------");
        }
    }
}
