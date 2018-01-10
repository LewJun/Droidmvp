package cn.com.sysa.droidmvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by LewJun on 2018/01/04.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    protected static final String TAG = "BaseActivity";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Activity Name: " + this.getClass().getSimpleName());
        mContext = this;
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

//        使用ButterKnife
        ButterKnife.bind(this);
    }

    /**
     * @return 得到Activity上下文
     */
    protected Context getContext() {
        return mContext;
    }

    /**
     * 显示View
     * @param view View
     */
    public void showView(View view) {
        view.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏View
     * @param view View
     */
    public void hideView(View view) {
        view.setVisibility(View.GONE);
    }

    /**
     * 显示或隐藏
     * @param view View
     * @param isShow 是否显示
     */
    public void showOrHideView(View view, boolean isShow) {
        if(isShow) {
            showView(view);
        } else {
            hideView(view);
        }
    }
    @Override
    public void showMsg(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {
    }

    /**
     * 初始化参数
     */
    public abstract void initParams();
}
