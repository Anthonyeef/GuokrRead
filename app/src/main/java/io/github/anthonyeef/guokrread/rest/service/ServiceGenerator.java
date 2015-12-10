package io.github.anthonyeef.guokrread.rest.service;

import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by anthonyeef on 12/9/15.
 */
public class ServiceGenerator {

    public static final String API_BASE_URL = "http://apis.guokr.com";

    private static OkHttpClient httpClient = new OkHttpClient();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
