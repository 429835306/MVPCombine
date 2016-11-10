package com.zhangrui.aipai.mvp.presenter;

import com.zhangrui.aipai.base.BasePresenter;
import com.zhangrui.aipai.mvp.model.GankDayData;
import com.zhangrui.aipai.mvp.view.GankDayView;
import com.zhangrui.aipai.net.Api;
import com.zhangrui.aipai.net.ApiCallBack;
import com.zhangrui.aipai.net.NetClient;

/**
 * DESC:
 * Created by zhangrui on 2016/11/7.
 */

public class GankDayDataPresenter extends BasePresenter<GankDayView> {

    private Api.GankApi mGankApi;

    public GankDayDataPresenter(GankDayView mvpView) {
        super(mvpView);
        mGankApi = NetClient.getInstance().getGankRetrofit().create(Api.GankApi.class);
    }

    public void getGank(int year, int month, int day) {

        mView.showProgress();
        addSubscription(mGankApi.getGankDayData(year, month, day), new ApiCallBack<GankDayData>() {
            @Override
            public void onSuccess(GankDayData model) {
                mView.updateDayData(model);
            }

            @Override
            public void onFinish() {
                mView.dissmissProgress();
            }

            @Override
            public void onFailure(String msg) {
                mView.showError(msg);
            }
        });

    }
}
