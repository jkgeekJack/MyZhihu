package com.jkgeekjack.myzhihu.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jkgeekjack.myzhihu.R;
import com.jkgeekjack.myzhihu.ZhiHuService;
import com.jkgeekjack.myzhihu.adapter.NewsAdapter;
import com.jkgeekjack.myzhihu.adapter.PagerAdapter;
import com.jkgeekjack.myzhihu.bean.RootEntity;
import com.jkgeekjack.myzhihu.bean.StoriesEntity;
import com.jkgeekjack.myzhihu.ui.activity.StoryDetailActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {

    private String baseUrl="http://news-at.zhihu.com";//baseUrl一定要设为这个
    public ZhiHuService service;//要靠他来获取消息，子Fragment都要用

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        service=getService();
        return inflater.inflate(R.layout.fragment_base, container, false);
    }


    public ZhiHuService getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        service=retrofit.create(ZhiHuService.class);
        return service;
    }

    public void loadDataSetLis(Observable<RootEntity> rootEntityObservable, final ListView listView){
        rootEntityObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<RootEntity, ArrayList<StoriesEntity>>() {
                    @Override
                    public ArrayList<StoriesEntity> call(RootEntity rootEntity) {
                        return rootEntity.getStories();
                    }
                })
                .subscribe(new Subscriber<ArrayList<StoriesEntity>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(final ArrayList<StoriesEntity> storiesEntities) {
                        listView.setAdapter(new NewsAdapter(storiesEntities,getContext()));
                        //点击item跳转到详细页面
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent=new Intent(getActivity(),StoryDetailActivity.class);
                                intent.putExtra("id",storiesEntities.get(position).getId());
                                startActivity(intent);
                            }
                        });
                    }
                });
    }
}
