package io.github.anthonyeef.guokrread.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import io.github.anthonyeef.guokrread.R;

/**
 * Created by anthonyeef on 11/19/15.
 */
public class PagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mTitles = new ArrayList<>();

    private static final int[] TITLES = {
        R.string.page_title_home, R.string.page_title_explore
};
    private Context mContext;

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getString(TITLES[position]);
    }
}
