package com.jkgeekjack.myzhihu;

import com.jkgeekjack.myzhihu.bean.RootEntity;
import com.jkgeekjack.myzhihu.bean.StoryDetailsEntity;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2016/5/26.
 */
public interface ZhiHuService {

    @GET("/api/4/news/latest")
    Observable<RootEntity> getLatestNews();

    @GET("/api/4/news/{id}")
    Observable<StoryDetailsEntity> getNewsDetails(@Path("id") int id);

    @GET("/api/4/theme/10")
    Observable<RootEntity> getSafety();

    @GET("/api/4/theme/11")
    Observable<RootEntity> getInterest();

    @GET("/api/4/theme/8")
    Observable<RootEntity> getSport();

}
