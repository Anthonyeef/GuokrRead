package io.github.anthonyeef.guokrread.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.anthonyeef.guokrread.R;
import io.github.anthonyeef.guokrread.adapter.ArticleRecyclerAdapter;
import io.github.anthonyeef.guokrread.rest.model.ResponseModel;
import io.github.anthonyeef.guokrread.rest.model.result;
import io.github.anthonyeef.guokrread.rest.service.HandPickClient;
import io.github.anthonyeef.guokrread.rest.service.ServiceGenerator;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by anthonyeef on 12/7/15.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = HomeFragment.class
            .getSimpleName();

    private SwipeRefreshLayout swipeContainer;
    private List<result> mResults = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
                             savedInstanceState) {
        final View view = inflater.inflate(R.layout.home_fragment, container, false);

        final RecyclerView rv = (RecyclerView) view.findViewById(R.id.recyclerview);
        setupRecyclerView(rv, mResults);


        swipeContainer = (SwipeRefreshLayout) view.findViewById(R.id.swipeContainer);
        swipeContainer.setColorSchemeColors(R.color.pretty_green);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchData(rv);
            }
        });

        if (mResults == null) {
            swipeContainer.post(new Runnable() {
                @Override
                public void run() {
                    swipeContainer.setRefreshing(true);
                    fetchData(rv);
                }
            });
        }

        return view;
    }

    private void setupRecyclerView(RecyclerView recyclerView, List<result> results) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new ArticleRecyclerAdapter(getContext(), results));
    }

    public void fetchData(RecyclerView recyclerView) {
        setupRecyclerView(recyclerView, mResults);
        setupRetrofit(recyclerView);
    }
    private void setupRetrofit(final RecyclerView recyclerView) {

        HandPickClient client = ServiceGenerator.createService(HandPickClient.class);
        Call<ResponseModel> call =
                client.fetchResponse("by_since", "15", "40", "science");
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Response<ResponseModel> response, Retrofit retrofit) {
                ResponseModel responseModel = response.body();
                mResults = responseModel.getResult();
                setupRecyclerView(recyclerView, mResults);
                swipeContainer.setRefreshing(false);
//                Log.v(TAG, responseModel.getNow());
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });



    }
}
