package com.padcmyanmar.sfc.mvp.views;

import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.mvp.views.base.BaseView;

public interface NewsDetailView extends BaseView {
    void displayNewsDetails(NewsVO newsVO);
}
