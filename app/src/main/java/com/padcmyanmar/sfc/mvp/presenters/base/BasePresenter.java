package com.padcmyanmar.sfc.mvp.presenters.base;

import com.padcmyanmar.sfc.mvp.views.base.BaseView;

import org.greenrobot.eventbus.EventBus;

public abstract class BasePresenter<T extends BaseView> {

    protected  T view;

    public BasePresenter(T view) {
        this.view = view;
    }

    public void onCreate(){
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    public void onStart(){ }

    public void onStop(){
        EventBus eventBus = EventBus.getDefault();
        eventBus.unregister(this);
    }

    public void onPause(){ }

    public void onResume(){ }

    public void onDestroy(){ }

}
