package cn.com.sysa.droidmvp.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import cn.com.sysa.droidmvp.R;
import cn.com.sysa.droidmvp.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainContract.View, View.OnClickListener {

    MainContract.Presenter presenter;

    private TextView tv_string;
    private ImageView iv_image;
    private ProgressBar progressbar;
//    下载进度
    private ProgressBar pbProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        initParams();
    }

    @Override
    public void initViews() {
        setContentView(R.layout.activity_main);
        tv_string = findViewById(R.id.tv_string);
        iv_image = findViewById(R.id.iv_image);

        findViewById(R.id.btn_getString).setOnClickListener(this);
        findViewById(R.id.btn_getImage).setOnClickListener(this);
        findViewById(R.id.btn_downloadFile).setOnClickListener(this);
        findViewById(R.id.btn_getJsonObject).setOnClickListener(this);

        progressbar = findViewById(R.id.progress);
        pbProgress = findViewById(R.id.pbProgress);
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
    public void setString(String text) {
        tv_string.setText(text);
    }

    @Override
    public void setImage(Bitmap body) {
        iv_image.setImageBitmap(body);
    }

    @Override
    public void updateDownloadProgress(int progress) {
        pbProgress.setProgress(progress);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_getString:
                presenter.getJsonObject();
                break;

            case R.id.btn_getImage:
                presenter.getImage();
                break;

            case R.id.btn_downloadFile:
                presenter.downloadFile();
                break;

            case R.id.btn_getJsonObject:
                presenter.getJsonObject();
                break;

            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    public static void launch(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
