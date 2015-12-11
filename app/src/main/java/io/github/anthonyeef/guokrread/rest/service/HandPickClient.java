package io.github.anthonyeef.guokrread.rest.service;

import io.github.anthonyeef.guokrread.rest.model.Detail;
import io.github.anthonyeef.guokrread.rest.model.ResponseModel;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by anthonyeef on 11/19/15.
 */
public interface HandPickClient {

    @GET("/handpick/article.json")
    Call<ResponseModel> fetchResponse(@Query("retrieve_type") String type,
                                      @Query("ad") String ad,
                                      @Query("limit") String limit,
                                      @Query("category") String category);

    @GET("/pick/v2/{id}")
    Call<Detail> getDetail(@Path("id") long id);
}




