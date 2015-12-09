package io.github.anthonyeef.guokrread.api;

import java.util.List;

import io.github.anthonyeef.guokrread.model.Post;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by anthonyeef on 11/19/15.
 */
public interface HanpickApi {

    /*@GET("/article.json?retrivetype=by_since")*/

    @GET("/handpick/article.json")
    Call<List<Post>> postList(@Query("retrivetype") String type,
                              @Query("limit") int limit,
                              @Query("category") String category);

}









/*    void getFeed(
            @Query("retrivetype") String type,
            @Query("limit") int limit,
            @Query("category") String category,
            Callback<List<Post>> response);*/

