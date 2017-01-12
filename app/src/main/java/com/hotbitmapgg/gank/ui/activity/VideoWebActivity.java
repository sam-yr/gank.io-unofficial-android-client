package com.hotbitmapgg.gank.ui.activity;

import butterknife.Bind;
import com.hotbitmapgg.gank.base.RxBaseActivity;
import com.hotbitmapgg.gank.widget.web.LoveVideoView;
import com.hotbitmapgg.studyproject.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class VideoWebActivity extends RxBaseActivity {

  @Bind(R.id.video)
  LoveVideoView mLoveVideoView;

  private static final String EXTRA_URL = "url";

  private String url;


  @Override
  public int getLayoutId() {

    return R.layout.activity_video_web;
  }


  @Override
  public void initViews(Bundle savedInstanceState) {

    Intent intent = getIntent();
    if (intent != null) {
      url = intent.getStringExtra(EXTRA_URL);
    }

    mLoveVideoView.loadUrl(url);
  }


  @Override
  public void initToolBar() {

  }


  @Override
  protected void onPause() {

    mLoveVideoView.reload();
    super.onPause();
  }


  public static void launch(Activity activity, String url) {

    Intent intent = new Intent(activity, VideoWebActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    intent.putExtra(EXTRA_URL, url);
    activity.startActivity(intent);
  }
}
