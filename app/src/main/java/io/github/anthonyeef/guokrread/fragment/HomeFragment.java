package io.github.anthonyeef.guokrread.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.util.HashMap;

import io.github.anthonyeef.guokrread.R;

/**
 * Created by anthonyeef on 11/19/15.
 */
public class HomeFragment extends Fragment{
    public static final String TAB_INDEX_FIELD = "tab.index";
    private static final int RETRY_COUNT = 5;
    private int mIndex;
    private SwipeRefreshLayout mRefreshLayout;
    private ListView mList;
//    private RecyclerView mList;
    private View mHeader;
    private RelativeLayout mFooter;
    private ProgressBar mFootProgress;

    private HashMap<Integer, Integer> homeItemsH = new HashMap<Integer, Integer>(),
                                      exploreItemsH = new HashMap<Integer, Integer>();

    private int mLastScrollY;

    private Runnable mTimeOut = new Runnable() {
        @Override
        public void run() {
            mRefreshLayout.setRefreshing(false);
        }
    };

    private HashMap<String, String> mRelatedLinks;
    private boolean mCanScroll = true;
    private boolean mCanLoadMore = true;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        mIndex = getArguments().getInt(TAB_INDEX_FIELD);

        if (mList == null) {

            mRefreshLayout = (SwipeRefreshLayout) inflater.inflate(R.layout.home_content_fragment, container, false);
            mList = (ListView) mRefreshLayout.findViewById(R.id.home_content_fragment);

            mHeader = new View(getActivity());
            AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int)getResources().getDimension(R.dimen.navbar_home_height));
            mHeader.setLayoutParams(params);
            mList.addHeaderView(mHeader);

            mFooter = (RelativeLayout) inflater.inflate(R.layout.home_list_footer, null, false);
            AbsListView.LayoutParams footParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) getResources().getDimension(R.dimen.home_footer_height));
            mFooter.setLayoutParams(footParams);
            mList.addFooterView(mFooter);

            mList.setDivider(null);
            mList.setFriction(ViewConfiguration.getScrollFriction());
        }
    }
}
