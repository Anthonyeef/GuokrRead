package io.github.anthonyeef.guokrread.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import io.github.anthonyeef.guokrread.R;
import io.github.anthonyeef.guokrread.fragment.HomeFragment;

/**
 * Created by anthonyeef on 11/19/15.
 */
public class PagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragments = new ArrayList<>();
//    private final List<String> mFragmentTitles = new ArrayList<>();
    private static final int[] TITLES = {
        R.string.page_title_home
};
    private Context mContext;

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }


    @Override
    public Fragment getItem(int position) {
        final Fragment fragment;
        switch (position) {
            case 0:
                fragment = HomeFragment.newInstance();
                break;
            default:
                fragment = null;
                break;
        }
        return fragment;
//        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        return mFragmentTitles.get(position);
        return mContext.getString(TITLES[position]);
   /*     final String title;
        switch (position) {
            case 0:
                title = "Home";
                break;
            default:
                title = "null";
                break;
        }
        return title;*/
    }
}
