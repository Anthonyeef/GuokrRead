package io.github.anthonyeef.guokrread.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.InputStream;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.anthonyeef.guokrread.R;

/**
 * Created by anthonyeef on 12/10/15.
 */
public class UIDetail extends AppCompatActivity{
    final static String TAG = UIDetail.class.getSimpleName();

    @Bind(R.id.webview)
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        final String source_link = getIntent().getExtras().getString("RESOURCE_LINK");

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//        mWebView.getSettings().setAllowFileAccess(true);
//        mWebView.getSettings().setAllowContentAccess(true);
//        mWebView.getSettings().setLoadsImagesAutomatically(true);
        mWebView.getSettings().setDefaultTextEncodingName("UTF-8");
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setDatabaseEnabled(true);
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.loadUrl(source_link);
//        mWebView.loadDataWithBaseURL(source_link, , "text/html", "UTF-8",null);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {

                try {
                    InputStream inputStream = getAssets().open("articleInline_normal.css");
                    byte[] buffer = new byte[inputStream.available()];
                    inputStream.read(buffer);
                    inputStream.close();
                    String encoded = Base64.encodeToString(buffer, Base64.NO_WRAP);
                    mWebView.loadUrl("javascript:(function() {" +
                            "var parent = document.getElementsByTagName('head').item(0);" +
                            "var style = document.createElement('style');" +
                            "style.type = 'text/css';" +
                            // Tell the browser to BASE64-decode the string into your script !!!
                            "style.innerHTML = window.atob('" + encoded + "');" +
                            "parent.appendChild(style)" +
                            "})()");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // Inject CSS when page is done loading
//                injectCSS();
                super.onPageFinished(view, url);
            }
        });
        mWebView.loadUrl(source_link);

//        public void injectCSS(); {
//
//        }

//        OkHttpClient client = ServiceGenerator.getHttpClient();
      /*  HandPickClient client = ServiceGenerator.createPostService(HandPickClient.class);
        retrofit.Call<Detail> call =
                client.getDetail(16887);
        call.enqueue(new Callback<Detail>() {
            @Override
            public void onResponse(Response<Detail> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    Log.v(TAG, response.toString());
                    Detail detail = response.body();
                    String body = detail.getBody();
                    Log.v(TAG, body.toString());
//                    mWebView.loadDataWithBaseURL("x-data://base", body, "text/html","UTF-8", null);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });*/
/*        final Request request = new Request.Builder()
//                .url("http://jingxuan.guokr.com/pick/v2/16844/")
                .url(source_link)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
//                loadArticleSource(response.toString());
                mWebView.loadDataWithBaseURL(source_link, response.toString(), "text/html", "UTF-8",null);
            }
        });*/
    }

}
