package com.twt.wepeiyangapp.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.twt.wepeiyangapp.R;
import com.twt.wepeiyangapp.activity.ContentActivity;
import com.twt.wepeiyangapp.bean.PageBean;

import java.util.List;


/**
 * Created by Arsener on 2017/3/25.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyHolder> {

    private Context context;
    private List<PageBean.NewsBean> data;
    private View mFooterView;

    public static int NORMAL_TYPE = 0;//without footer
    public static int FOOTER_TYPE = 1;//with footer

    public MyRecyclerAdapter(Context context, List<PageBean.NewsBean> data) {

        super();
        this.context = context;
        this.data = data;
    }

    public View getFooterView() {
        return mFooterView;
    }

    public void setFooterView(View footerView) {
        mFooterView = footerView;
        notifyItemInserted(getItemCount() - 1);
    }


    //what mean???
    @Override
    public int getItemViewType(int position) {
        if (mFooterView == null) {
            return NORMAL_TYPE;
        }
        if (position == getItemCount() - 1) {
            //最后一个,应该加载Footer
            return FOOTER_TYPE;
        }
        return NORMAL_TYPE;
    }

    @Override
    public int getItemCount() {
        // TODO Auto-generated method stub
        //return data.size();
        if (mFooterView == null) {
            return data.size();
        } else {
            return data.size() + 1;
        }
    }

    @Override
    // 填充onCreateViewHolder方法返回的holder中的控件
    public void onBindViewHolder(MyHolder holder, final int position) {
        // TODO Auto-generated method stub
        //holder.tv.setText(data.get(position));
        if (getItemViewType(position) == NORMAL_TYPE) {
            //这里加载数据的时候要注意，是从position-1开始，因为position==0已经被header占用了
            holder.tv_title.setText(data.get(position).subject);
            holder.tv_summary.setText(data.get(position).summary);
            holder.tv_visit.setText("访问量：" + data.get(position).visitcount
                    + "|评论数：" + data.get(position).comments);
            if (!(data.get(position).pic.equals(""))) {
                holder.iv_icon.setVisibility(View.VISIBLE);
                Glide.with(context)
                        .load(data.get(position).pic)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_icon);
            } else {
                holder.iv_icon.setVisibility(View.GONE);
            }

            holder.cdv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ContentActivity.class);
                    intent.putExtra("index", data.get(position).index);
                    context.startActivity(intent);//注意这里的context！！！
                }
            });
        }
    }

    @Override
    // 重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 填充布局
        if (mFooterView != null && viewType == FOOTER_TYPE) {
            return new MyHolder(mFooterView);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.cardview, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private TextView tv_summary;
        private TextView tv_visit;
        private ImageView iv_icon;
        private CardView cdv;

        public MyHolder(View view) {
            super(view);
            if (view != mFooterView) {
                tv_title = (TextView) view.findViewById(R.id.tv_title);
                tv_summary = (TextView) view.findViewById(R.id.tv_summary);
                tv_visit = (TextView) view.findViewById(R.id.tv_visit);
                iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
                cdv = (CardView) view.findViewById(R.id.cdv);
                cdv.setRadius(8);//设置图片圆角的半径大小
                cdv.setCardElevation(0);//设置阴影部分大小
            }
        }
    }
}
