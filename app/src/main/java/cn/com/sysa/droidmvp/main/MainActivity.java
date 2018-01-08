package cn.com.sysa.droidmvp.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import cn.com.sysa.droidmvp.R;
import cn.com.sysa.droidmvp.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainContract.View, View.OnClickListener {

    MainContract.Presenter presenter;

    private TextView tv_method;
    private ImageView iv_image;
    private Button btn_method;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        initParams();
    }

    @Override
    public void initViews() {
        setContentView(R.layout.activity_main);
        tv_method = findViewById(R.id.tv_method);
        iv_image = findViewById(R.id.iv_image);
        btn_method = findViewById(R.id.btn_method);
        btn_method.setOnClickListener(this);

        progressbar = findViewById(R.id.progress);
    }

    @Override
    public void initParams() {
        presenter = new MainPresenter(this, new MainInteractorImpl());
    }

    @Override
    public void showProgress() {
        showView(progressbar);
    }

    @Override
    public void hideProgress() {
        hideView(progressbar);
    }

    @Override
    public void setMethodTxt(String text) {
        tv_method.setText(text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_method:
                presenter.getMethod();
                break;

                default:break;
        }
    }

    public static void launch(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
