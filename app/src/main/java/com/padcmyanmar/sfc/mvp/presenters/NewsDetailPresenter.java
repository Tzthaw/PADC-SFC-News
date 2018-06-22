package com.padcmyanmar.sfc.mvp.presenters;

import com.padcmyanmar.sfc.data.models.NewsModel;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.events.RestApiEvents;
import com.padcmyanmar.sfc.mvp.presenters.base.BasePresenter;
import com.padcmyanmar.sfc.mvp.views.NewsDetailView;
import com.padcmyanmar.sfc.mvp.views.NewsListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class NewsDetailPresenter extends BasePresenter<NewsDetailView>{


    public NewsDetailPresenter(NewsDetailView view) {
        super(view);
    }


    public void onFinishUIComponent(String id){
        NewsVO newsVO=NewsModel.getInstance().getNewsById(id);
        view.displayNewsDetails(newsVO);
    }

    public void onCreate(){

    }
    public void onStart(){
        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }
    public void onStop(){
        if(EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
    public void onResume(){

    }
    public void onPause(){

    }
    public void onDestroy(){

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorInvokingAPI(RestApiEvents.ErrorInvokingAPIEvent event) {
        view.displayErrorMessage(event.getErrorMsg());
    }

}
