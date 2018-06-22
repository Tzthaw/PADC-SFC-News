package com.padcmyanmar.sfc.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.padcmyanmar.sfc.R;
import com.padcmyanmar.sfc.adapters.NewsImagesPagerAdapter;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.mvp.presenters.NewsDetailPresenter;
import com.padcmyanmar.sfc.mvp.views.NewsDetailView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aung on 11/11/17.
 */

public class NewsDetailsActivity extends BaseActivity implements NewsDetailView{

    @BindView(R.id.vp_news_details_images)
    ViewPager vpNewsDetailsImages;

    @BindView(R.id.tv_news_details)
    TextView tvNewsDetials;

    private static final String IE_NEWS_ID="IE_NEWS_ID";
    private NewsDetailPresenter mPresenter;

    public static Intent newIntent(Context context,String id) {
        Intent intent = new Intent(context, NewsDetailsActivity.class);
        intent.putExtra(IE_NEWS_ID,id);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this, this);

        mPresenter=new NewsDetailPresenter(this);
        mPresenter.onCreate();

        String newsId=getIntent().getStringExtra(IE_NEWS_ID);
        mPresenter.onFinishUIComponent(newsId);

        NewsImagesPagerAdapter newsImagesPagerAdapter = new NewsImagesPagerAdapter(getApplicationContext());
        vpNewsDetailsImages.setAdapter(newsImagesPagerAdapter);

        //TODO get NewsVo by  newsId
        //TODO bind data to UI components
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void displayNewsDetails(NewsVO newsVO) {
        tvNewsDetials.setText(newsVO.getDetails());
    }

    @Override
    public void displayErrorMessage(String msg) {

    }
}
