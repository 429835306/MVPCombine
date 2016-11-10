package com.zhangrui.aipai.net;

import com.zhangrui.aipai.mvp.model.Gank;
import com.zhangrui.aipai.mvp.model.GankDayData;
import com.zhangrui.aipai.mvp.model.Video;
import com.zhangrui.aipai.viewmodel.Story;
import com.zhangrui.aipai.mvp.model.Zhihu;

import java.util.HashMap;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * DESC:
 * Created by zhangrui on 2016/11/3.
 */

public class Api {

    public interface AiPaiApi {
          String AIPAI_BASE_URL = "http://newapi.meipai.com/output/";

        /**
         * 获取美拍视频列表
         *
         * @param map
         * @return
         */
        @GET("channels_topics_timeline.json")
        Observable<List<Video>> getVideos(@QueryMap HashMap<String, Object> map);
    }

    public interface GankApi {

         String GANK_BASE_URL = "http://gank.io/api/";

        @GET("data/{type}/{pageSize}/{page}")
        Observable<Gank> getGankData(@Path("type") String type,@Path("pageSize") int pageSize, @Path("page") int page);

        @GET("day/{year}/{month}/{day}")
        Observable<GankDayData> getGankDayData(@Path("year") int year, @Path("month") int month,
                                            @Path("day") int day);
    }

    public interface ZhihuApi {

         String ZHIHU_BASE_URL = "http://news-at.zhihu.com";

        @GET("/api/4/news/latest")
        Observable<Zhihu> getLastZhihuDaily();

        @GET("/api/4/news/before/{date}")
        Observable<Zhihu> getZhihuDaily(@Path("date") String date);

        @GET("/api/4/news/{id}")
        Observable<Story> getZhihuStory(@Path("id") String id);

    }

}
