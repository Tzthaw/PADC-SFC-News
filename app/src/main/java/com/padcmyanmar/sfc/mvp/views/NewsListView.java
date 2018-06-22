package com.padcmyanmar.sfc.mvp.views;

import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.mvp.views.base.BaseView;

import java.util.List;

public interface NewsListView extends BaseView {
    void displayLoadedNews(List<NewsVO> newsVOS);
    void displayTabNews(NewsVO newsVO);
}
