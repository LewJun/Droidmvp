package cn.com.sysa.droidmvp.base;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import butterknife.ButterKnife;
import cn.com.sysa.droidmvp.R;

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
        //无title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);

        super.setContentView(layoutResID);

//        不显示默认标题栏
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

//        显示自定义标题栏
        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

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
