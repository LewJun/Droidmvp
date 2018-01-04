package cn.com.sysa.droidmvp.main;

import android.os.Bundle;

import cn.com.sysa.droidmvp.R;
import cn.com.sysa.droidmvp.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        initParams();
    }

    @Override
    public void initViews() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initParams() {

    }

}
