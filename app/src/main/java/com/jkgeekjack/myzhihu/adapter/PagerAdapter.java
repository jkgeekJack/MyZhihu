package com.jkgeekjack.myzhihu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jkgeekjack.myzhihu.ui.fragment.SportFragment;
import com.jkgeekjack.myzhihu.ui.fragment.InterestFragment;
import com.jkgeekjack.myzhihu.ui.fragment.SafetyFragment;
import com.jkgeekjack.myzhihu.ui.fragment.TodayFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public class PagerAdapter extends FragmentPagerAdapter {
    private final String[] title={"今日日报","不许无聊","互联网安全","体育日报"};
    private List<Fragment>fragments=new ArrayList<Fragment>();
    public PagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new TodayFragment());
        fragments.add(new InterestFragment());
        fragments.add(new SafetyFragment());
        fragments.add(new SportFragment());
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
