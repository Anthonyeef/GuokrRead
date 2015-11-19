package io.github.anthonyeef.guokrread.api;

import java.util.List;

import io.github.anthonyeef.guokrread.model.Post;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by anthonyeef on 11/19/15.
 */
public interface HanpickApi {
//    @GET("/article.json?retrivetype=bysince")
    @GET("/article.json")
    void getFeed(
            @Query("retrivetype") String type,
            @Query("limit") int limit,
            @Query("category") String category,
            Callback<List<Post>> response);
}
