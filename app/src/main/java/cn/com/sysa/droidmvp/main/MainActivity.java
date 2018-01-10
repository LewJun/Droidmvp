package cn.com.sysa.droidmvp.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.sysa.droidmvp.R;
import cn.com.sysa.droidmvp.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainContract.View {

    MainContract.Presenter presenter;

    @BindView(R.id.tv_string) TextView tv_string;
    @BindView(R.id.iv_image) ImageView iv_image;
    @BindView(R.id.progress) ProgressBar progressbar;
//    下载进度
    @BindView(R.id.pbProgress) ProgressBar pbProgress;

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

    @OnClick(R.id.btn_getString)
    public void getJsonObject() {
        presenter.getJsonObject();
    }

    @OnClick(R.id.btn_getImage)
    public void getImage() {
        presenter.getImage();
    }

    @OnClick(R.id.btn_downloadFile)
    public void downloadFile() {
        presenter.downloadFile();
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
