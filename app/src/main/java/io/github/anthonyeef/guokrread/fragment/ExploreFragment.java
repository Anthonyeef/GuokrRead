package io.github.anthonyeef.guokrread.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.anthonyeef.guokrread.R;
import io.github.anthonyeef.guokrread.adapter.ChannelAdapter;
import io.github.anthonyeef.guokrread.rest.model.Channel;

/**
 * Created by anthonyeef on 12/11/15.
 */
public class ExploreFragment extends Fragment{
    private static final String TAG = ExploreFragment.class
            .getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.component_recyclerview, container, false);
        final RecyclerView rv = (RecyclerView) view.findViewById(R.id.recyclerview);
        setupRecyclerView(rv);

        return view;
    }


    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        recyclerView.setAdapter(new ChannelAdapter(getActivity(),
                Channel.getChannelList()));
    }
}
