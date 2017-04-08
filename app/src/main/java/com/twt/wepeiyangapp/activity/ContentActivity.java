package com.twt.wepeiyangapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twt.wepeiyangapp.retrofit.GithubServiceForContent;
import com.twt.wepeiyangapp.R;
import com.twt.wepeiyangapp.bean.ContentBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Arsener on 2017/4/2.
 */


public class ContentActivity extends Activity {
    private WebView wv_content;
    private Toolbar toolbar;

    private GithubServiceForContent service;
    private Retrofit retrofit;
    private final Gson gson = new GsonBuilder().create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_main);

        wv_content = (WebView) findViewById(R.id.wv_content);
        toolbar = (Toolbar) findViewById(R.id.tb);

        Intent intent = getIntent();
        int news = intent.getIntExtra("index", 0);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://open.twtstudio.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(GithubServiceForContent.class);

        Call<ContentBean> contentbean = service.getContent(news);
        contentbean.enqueue(new Callback<ContentBean>() {
            @Override
            public void onResponse(Call<ContentBean> call, Response<ContentBean> response) {
                ContentBean content = response.body();

                String html = "<h1 style=\"text-size=20dp\">"
                        + content.data.subject
                        + "</h1>"
                        + content.data.content
                        + "<p style=\"font-size:10px\">新闻来源"
                        + content.data.newscome
                        + "<br/></p>"
                        + "<p style=\"font-size:10px\">供稿"
                        + content.data.gonggao
                        + "<br/></p>"
                        + "<p style=\"font-size:10px\">审稿"
                        + content.data.shengao
                        + "<br/></p>"
                        + "<p style=\"font-size:10px\">摄影"
                        + content.data.sheying
                        + "<br/></p>"
                        + "<p style=\"font-size:10px\">浏览量"
                        + content.data.visitcount
                        + "<br/></p>";
//                html = content.data.content;
                wv_content.loadDataWithBaseURL(null, html,
                        "text/html", "utf-8", null);
            }

            @Override
            public void onFailure(Call<ContentBean> call, Throwable t) {
                t.printStackTrace();
            }
        });

//        html = "<h1 style=\"text-size=20dp\">"
//                        + "hahahaha"
//                        + "</h1>";
    }
}
