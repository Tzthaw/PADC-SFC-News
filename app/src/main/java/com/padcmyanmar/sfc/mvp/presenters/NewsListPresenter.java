package com.padcmyanmar.sfc.mvp.presenters;

import android.support.design.widget.Snackbar;

import com.padcmyanmar.sfc.data.models.NewsModel;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.delegates.NewsItemDelegate;
import com.padcmyanmar.sfc.events.RestApiEvents;
import com.padcmyanmar.sfc.mvp.presenters.base.BasePresenter;
import com.padcmyanmar.sfc.mvp.views.NewsListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class NewsListPresenter extends BasePresenter<NewsListView> implements NewsItemDelegate{


    public NewsListPresenter(NewsListView view) {
        super(view);
    }

    @Override
    public void onCreate(){
        super.onCreate();
        NewsModel.getInstance().startLoadingMMNews();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsDataLoaded(RestApiEvents.NewsDataLoadedEvent event) {
        if(event.getLoadNews()==null){
            view.displayErrorMessage("Empty Data");
        }else{
            view.displayLoadedNews(event.getLoadNews());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorInvokingAPI(RestApiEvents.ErrorInvokingAPIEvent event) {
        view.displayErrorMessage(event.getErrorMsg());
    }

    @Override
    public void onTapComment() {

    }

    @Override
    public void onTapSendTo() {

    }

    @Override
    public void onTapFavorite() {

    }

    @Override
    public void onTapStatistics() {

    }

    @Override
    public void onTapNews(NewsVO newsVO) {
        view.displayTabNews(newsVO);
    }
}
