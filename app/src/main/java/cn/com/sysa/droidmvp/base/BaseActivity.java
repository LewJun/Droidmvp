package cn.com.sysa.droidmvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by LewJun on 2018/01/04.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    private static final String TAG = "BaseActivity";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Activity Name: " + this.getClass().getSimpleName());
        mContext = this;
    }

    protected Context getContext() {
        return mContext;
    }

    protected void viewDisplay(@NonNull View v, boolean isVisible) {
        v.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public abstract void initParams();
}
