package io.github.anthonyeef.guokrread.app;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import com.squareup.okhttp.Callback;
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
    private Handler mHandler;

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
        Request request = new Request.Builder()
                .url(source_link)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.e(TAG, e.toString());
            }

            @Override
            public void onResponse(final Response response) throws IOException {
//                Log.v(TAG, response.body().toString());
                final String content = response.body().string();
                mHandler = new Handler(Looper.getMainLooper());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/articleInline_normal.css\" type=\"text/css\">";
                        String html = content;
                        html = css + html;
                        mWebView.loadDataWithBaseURL(source_link, html,"text/html", "utf-8",null);
                    }
                });
            }
        });
    }

}
