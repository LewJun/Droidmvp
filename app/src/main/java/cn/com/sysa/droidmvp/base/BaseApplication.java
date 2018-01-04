package cn.com.sysa.droidmvp.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by LewJun on 2018/01/04.
 */
public class BaseApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    /**
     * @return 得到应用上下文
     */
    public static Context getContext() {
        return mContext;
    }
}
