package io.github.anthonyeef.guokrread.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.anthonyeef.guokrread.R;
import io.github.anthonyeef.guokrread.adapter.ArticleRecyclerAdapter;
import io.github.anthonyeef.guokrread.api.HanpickApi;
import io.github.anthonyeef.guokrread.model.Post;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by anthonyeef on 12/7/15.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = HomeFragment.class
            .getSimpleName();

    public static final String BASE_URL = "http://apis.guokr.com";

    public static HomeFragment newInstance() {
        return newInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
                             savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.home_content_fragment, container,false);
//        setupRecyclerView(rv);
        setupRetrofit(rv);
        return rv;
    }

//    private void setupRecyclerView(RecyclerView recyclerView) {
//        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
//        recyclerView.setAdapter(new ArticleRecyclerAdapter());
//    }

    private void setupRetrofit(final RecyclerView recyclerView) {
        /*Specify the BASE_URL and converter for Retrofit*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        /*Create service and make the call*/
        HanpickApi hanpickService = retrofit.create(HanpickApi.class);

        Call<List<Post>> call = hanpickService.postList("by_since", 20, "all");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Response<List<Post>> response, Retrofit retrofit) {
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                ArticleRecyclerAdapter adapter = new ArticleRecyclerAdapter(getContext(), response.body());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
