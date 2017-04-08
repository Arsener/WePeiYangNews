package com.twt.wepeiyangapp.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twt.wepeiyangapp.view.EndlessRecyclerOnScrollListener;
import com.twt.wepeiyangapp.retrofit.GitHubService;
import com.twt.wepeiyangapp.view.MyRecyclerAdapter;
import com.twt.wepeiyangapp.R;
import com.twt.wepeiyangapp.bean.PageBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView rv;
    private SwipeRefreshLayout srl;
    private MyRecyclerAdapter myRecyclerAdapter;
    private EndlessRecyclerOnScrollListener eros;
    private LinearLayoutManager layoutManager;

    private int page;
    private int news;
    private GitHubService service;
    private Retrofit retrofit;
    private final Gson gson = new GsonBuilder().create();
    private List<PageBean.NewsBean> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        srl = (SwipeRefreshLayout) findViewById(R.id.srl);
        srl.setColorSchemeResources(
                R.color.HeaderView_blue,
                R.color.HeaderView_green,
                R.color.HeaderView_pink,
                R.color.HeaderView_yellow
        );
        rv = (RecyclerView) findViewById(R.id.rv);
        myRecyclerAdapter = new MyRecyclerAdapter(this, data);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(myRecyclerAdapter);

        srl.setOnRefreshListener(this);
        eros = new EndlessRecyclerOnScrollListener(layoutManager) {
            @Override
            public void onLoadMore() {

                simulateLoadMoreData();
            }
        };
        rv.addOnScrollListener(eros);

        page = 1;
        news = 1;

        retrofit = new Retrofit.Builder()
                .baseUrl("http://open.twtstudio.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(GitHubService.class);
        initData(news, page);
    }

    public void initData(int news,final int page) {
        Call<PageBean> content = service.getNewsList(news, page);
        final int tmp = page;
        content.enqueue(new Callback<PageBean>() {
            @Override
            public void onResponse(Call<PageBean> call, Response<PageBean> response) {
                try {
                    PageBean info = response.body();

                    data.addAll(info.data);
                    if (tmp != 1) {
                        View footer = LayoutInflater.from(MainActivity.this).inflate(R.layout.footer_view, rv, false);
                        myRecyclerAdapter.setFooterView(footer);
                    }

                    myRecyclerAdapter.notifyDataSetChanged();
                }
                catch (Exception e){
                    add();
                    simulateLoadMoreData();
                }
            }

            @Override
            public void onFailure(Call<PageBean> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void add(){
        page++;
    }

    @Override
    public void onRefresh() {
        fetchingNewData();
        srl.setRefreshing(false);
        myRecyclerAdapter.notifyDataSetChanged();
    }

    private void fetchingNewData() {
        data.clear();
        page = 1;
        news = 1;
        eros.restart();
        initData(1, 1);
    }

    private void simulateLoadMoreData() {
        page++;
        initData(news, page);

    }
}
