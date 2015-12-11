package io.github.anthonyeef.guokrread.rest.service;

import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.SimpleXmlConverterFactory;

/**
 * Created by anthonyeef on 12/9/15.
 */
public class ServiceGenerator {

    public static final String API_BASE_URL = "http://apis.guokr.com";
    public static final String POST_BASE_URL = "http://jingxuan.guokr.com";

    private static OkHttpClient httpClient = new OkHttpClient();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build();


    private static Retrofit retrofitPost = new Retrofit.Builder()
            .baseUrl(POST_BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .client(httpClient)
            .build();

    public static <S> S createPostService(Class<S> serviceClass) {
        return retrofitPost.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
