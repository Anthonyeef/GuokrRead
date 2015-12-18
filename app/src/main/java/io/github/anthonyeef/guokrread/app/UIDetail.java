package io.github.anthonyeef.guokrread.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.anthonyeef.guokrread.R;
import io.github.anthonyeef.guokrread.rest.service.ServiceGenerator;

/**
 * Created by anthonyeef on 12/10/15.
 */
public class UIDetail extends AppCompatActivity{
    final static String TAG = UIDetail.class.getSimpleName();

    @Bind(R.id.webview)
    WebView mWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        final String source_link = getIntent().getExtras().getString("RESOURCE_LINK");

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setCacheMode(1);
        mWebView.getSettings().setLoadsImagesAutomatically(true);
        /*TODO: method 2 to load content*/
        final OkHttpClient client = ServiceGenerator.getHttpClient();
        mWebView.post(new Runnable() {
            @Override
            public void run() throws Exception {
               Request request = new Request.Builder()
                       .url(source_link)
                       .build();
                Response response = client.newCall(request).execute();
            }
        })

        final OkHttpClient client = ServiceGenerator.getHttpClient();

        final Request request = new Request.Builder()
                .url(source_link)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();

        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
//                try {
                    //Your code goes here
                    Call call = client.newCall(request);
                Response response = null;
                try {
                    response = call.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (response.isSuccessful()) {
                    String content = response.body().toString();
                    Log.v(TAG, content);
//                    mWebView.loadDataWithBaseURL("file:///android_asset/", content, "text/html", "UTF-8", null);
                    mWebView.loadData(content,"text/html", "UTF-8");
                }

                /*    StringBuffer stringBuffer = new StringBuffer(0);
                    String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/articleInline_normal.css\" type=\"text/css\">";
                    String divider = "</head>";
                    String [] split = content.split(divider);
                    stringBuffer.append(split[0]);
                    Log.v(TAG, stringBuffer.toString());
                    stringBuffer.append(css);
                    Log.v(TAG, stringBuffer.toString());
                    stringBuffer.append(divider);
                    Log.v(TAG, stringBuffer.toString());
                    stringBuffer.append(split[1]);
                    Log.v(TAG, stringBuffer.toString());
                    content = stringBuffer.toString();
                    Log.v(TAG, stringBuffer.toString());*/
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
        });
        thread.start();

        /*call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code" + response);
                }
//                System.out.println(response.body().string());
                String content = response.body().string();
                StringBuffer stringBuffer = new StringBuffer(0);
                String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/articleInline_normal.css\" type=\"text/css\">";
                String divider = "</head>";
                String [] split = content.split(divider);
                stringBuffer.append(split[0]);
                stringBuffer.append(css);
                stringBuffer.append(divider);
                stringBuffer.append(split[1]);
                content = stringBuffer.toString();
                mWebView.loadDataWithBaseURL("x-data://base", content, "text/html", "UTF-8", null);
//                parsehtml(response.toString());
            }
        });*/
    }
    /*private void parsehtml(String response) {
        *//*TODO: try using Jsoup*//*
      *//*  Document doc = Jsoup.parse(response);
        Element content = doc.select("div.article").first();
        org.jsoup.nodes.Element body = doc.select("body").first();
        Log.v(TAG, body.toString());
        Log.v(TAG, content.toString());*//*
        *//*TODO: try using regex*//*
//        mWebView.loadData(response, "text/html", "UTF-8");
        Pattern p = Pattern.compile("<body>|<\\/body>|<div.*|<p.*|<h\\d.*|<\\/div.*(.*?)");
        Matcher m = p.matcher(response);
        if (m.find()) {
            Log.v(TAG, m.group(0));
//            mWebView.loadData(m.group(0), "text/html", "UTF-8");

        }
    }*/



}
