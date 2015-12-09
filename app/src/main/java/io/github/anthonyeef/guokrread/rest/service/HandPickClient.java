package io.github.anthonyeef.guokrread.rest.service;

import io.github.anthonyeef.guokrread.rest.model.ResponseModel;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by anthonyeef on 11/19/15.
 */
public interface HandPickClient {

    /*@GET("/article.json?retrivetype=by_since")*/

 /*   @GET("/handpick/article.json?")
    Call<List<Post>> postList(@Query("retrive_type") String type,
                              @Query("limit") String limit,
                              @Query("category") String category);*/


    @GET("/handpick/article.json?")
    Call<ResponseModel> fetchResponse(@Query("retrive_type") String type,
                                      @Query("limit") String limit,
                                      @Query("category") String category);
}




