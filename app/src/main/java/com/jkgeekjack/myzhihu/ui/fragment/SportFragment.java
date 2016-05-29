package com.jkgeekjack.myzhihu.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jkgeekjack.myzhihu.R;
import com.jkgeekjack.myzhihu.ZhiHuService;
import com.jkgeekjack.myzhihu.adapter.NewsAdapter;
import com.jkgeekjack.myzhihu.bean.RootEntity;
import com.jkgeekjack.myzhihu.bean.StoriesEntity;
import com.jkgeekjack.myzhihu.ui.activity.StoryDetailActivity;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 */
public class SportFragment extends BaseFragment {
    private ListView lv;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        lv= (ListView) view.findViewById(R.id.lvnews);
        loadDataSetLis(service.getSport(),lv);
    }
}
