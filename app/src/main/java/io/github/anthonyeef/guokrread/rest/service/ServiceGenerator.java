package io.github.anthonyeef.guokrread.rest.service;

import com.facebook.stetho.okhttp.StethoInterceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.SimpleXmlConverterFactory;

/**
 * Created by anthonyeef on 12/9/15.
 */
public class ServiceGenerator {

    public static final String API_BASE_URL = "http://apis.guokr.com";
    public static final String POST_BASE_URL = "http://jingxuan.guokr.com";
    public static int HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 3*1024*1024;

    public static OkHttpClient httpClient = new OkHttpClient();

    public static OkHttpClient getHttpClient() {
        return httpClient;
    }


    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
//            .client(setLog(httpClient))
//            .client(httpClient)
            .build();


    private static Retrofit retrofitPost = new Retrofit.Builder()
            .baseUrl(POST_BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
//            .client(setLog(httpClient))
//            .client(httpClient)
            .build();

    public static <S> S createPostService(Class<S> serviceClass) {
        return retrofitPost.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

    public static OkHttpClient setLog(OkHttpClient client){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.NONE);
//        OkHttpClient httpClient = new OkHttpClient();
        client.interceptors().add(logging);

        /*set Stetho*/
        client.networkInterceptors().add(new StethoInterceptor());


        /*set Cache*/
//        final  File baseDir = AppContext.mContext.getCacheDir();
//        if (baseDir != null) {
//            final File cacheDir = new File(baseDir, "HttpResponseCache");
//            client.setCache(new Cache(cacheDir, HTTP_RESPONSE_DISK_CACHE_MAX_SIZE));
//        }

        return client;
    }
}
