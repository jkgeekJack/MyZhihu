package com.jkgeekjack.myzhihu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jkgeekjack.myzhihu.R;
import com.jkgeekjack.myzhihu.bean.StoriesEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/5/26.
 */
public class NewsAdapter extends BaseAdapter {
    private List<StoriesEntity> newsList;
    private LayoutInflater mInflater;
    private Context context;
    public NewsAdapter(ArrayList<StoriesEntity> newsList, Context context){
        this.newsList=newsList;
        this.context=context;
        mInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=null;
        if (convertView==null){
            convertView=mInflater.inflate(R.layout.news_item,null);
            holder=new Holder(convertView);
            convertView.setTag(holder);
        }
        holder= (Holder) convertView.getTag();
        StoriesEntity news=newsList.get(position);
        TextView tvnews=holder.tvnews;
        ImageView ivnews=holder.ivnews;
        tvnews.setText(news.getTitle());
        //记得判空，不然后会空指针异常
        if (news.getImages()==null){
            ivnews.setVisibility(View.GONE);
        }else {
            ivnews.setVisibility(View.VISIBLE);
            //用Glide根据URL加载图片
            Glide.with(context).load(news.getImages().get(0)).into(ivnews);
        }
        return convertView;
    }

    private class Holder {
        ImageView ivnews;
        TextView tvnews;
        public  Holder(View view){
            ivnews= (ImageView) view.findViewById(R.id.ivnews);
            tvnews= (TextView) view.findViewById(R.id.tvnews);
        }
    }
}
