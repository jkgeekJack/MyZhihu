package com.jkgeekjack.myzhihu.ui.activity;



import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.jkgeekjack.myzhihu.adapter.PagerAdapter;
import com.jkgeekjack.myzhihu.R;

public class MainActivity extends FragmentActivity {
    private static String baseUrl="http://news-at.zhihu.com";
    private ListView lvnews;
    private TextView textView;
    private ViewPager pager;
    private PagerSlidingTabStrip tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvnews= (ListView) findViewById(R.id.lvnews);
        pager= (ViewPager) findViewById(R.id.pager);
        tab= (PagerSlidingTabStrip) findViewById(R.id.tab);
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tab.setViewPager(pager);
    }
}
