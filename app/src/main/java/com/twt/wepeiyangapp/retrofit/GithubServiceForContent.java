package com.twt.wepeiyangapp.retrofit;

import com.twt.wepeiyangapp.bean.ContentBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Arsener on 2017/4/2.
 */

public interface GithubServiceForContent {
    @GET("news/{news}")
    Call<ContentBean> getContent(@Path("news") int news);
}
