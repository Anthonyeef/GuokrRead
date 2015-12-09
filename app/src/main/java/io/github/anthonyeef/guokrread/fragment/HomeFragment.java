package io.github.anthonyeef.guokrread.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.anthonyeef.guokrread.R;
import io.github.anthonyeef.guokrread.adapter.ArticleRecyclerAdapter;
import io.github.anthonyeef.guokrread.model.Post;
import io.github.anthonyeef.guokrread.rest.model.ResponseModel;
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

    private List<Post> mPosts = null;

    public static HomeFragment newInstance() {
        return newInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
                             savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.home_content_fragment, container,false);
        setupRecyclerView(rv);
        setupRetrofit(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new ArticleRecyclerAdapter(getContext(), mPosts));
    }

    private void setupRetrofit(final RecyclerView recyclerView) {

        HandPickClient client = ServiceGenerator.createService(HandPickClient.class);

        Call<ResponseModel> call =
                client.fetchResponse("by_since", "20", "all");
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Response<ResponseModel> response, Retrofit retrofit) {
                ResponseModel responseModel = response.body();
                Log.v(TAG, getString(responseModel.getResult().size()));
                Log.v(TAG, responseModel.toString());
                Log.v(TAG, responseModel.getResult().toString());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
/*        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Response<ResponseModel> response, Retrofit retrofit) {
                if (response.isSuccess()){
                    Log.e(TAG, response.body().getOk());
                    mPosts = response.body().getResult();
                    Log.e(TAG, mPosts.get(0).getTitle());
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });*/













        /*Setup Gson*//*
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Post.class, new PostDeserializer())
                .create();

        *//*Specify the BASE_URL and converter for Retrofit*//*


        Retrofit retrofitGenerator = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(gson)
                .build();
        *//*Create service and make the call*//*
        HandPickClient hanpickService = retrofitGenerator.create(HandPickClient.class);

        Call<List<Post>> call = hanpickService.postList("by_since", "20", "all");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Response<List<Post>> response, Retrofit retrofit) {
                Log.e(TAG, response.body().toString());
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                ArticleRecyclerAdapter adapter = new ArticleRecyclerAdapter(getContext(), response.body());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
//                Log.e(TAG, "ya bug here");
            }
        });*/
    }
}
