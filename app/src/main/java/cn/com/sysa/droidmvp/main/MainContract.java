package cn.com.sysa.droidmvp.main;

import android.graphics.Bitmap;

import cn.com.sysa.droidmvp.base.BasePresenter;
import cn.com.sysa.droidmvp.base.BaseView;

/**
 * Created by LewJun on 2018/01/05.
 */
interface MainContract {
    interface View extends BaseView {
        /**
         * 设置method返回值
         *
         * @param text 值
         */
        void setString(String text);

        void setImage(Bitmap body);

        void updateDownloadProgress(int progress);
    }

    interface Presenter extends BasePresenter {
        /**
         * getImage
         */
        void getImage();

        void downloadFile();

        void getJsonObject();
    }
}
