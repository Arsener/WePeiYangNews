package com.twt.wepeiyangapp.retrofit;

import com.twt.wepeiyangapp.bean.PageBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Arsener on 2017/3/23.
 */

public interface GitHubService {
    @GET("news/{news}/page/{page}")
    Call<PageBean> getNewsList(@Path("news") int news, @Path("page") int page);
}
