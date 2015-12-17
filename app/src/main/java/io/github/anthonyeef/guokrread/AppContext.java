package io.github.anthonyeef.guokrread;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

/**
 * Created by anthonyeef on 11/19/15.
 */
public class AppContext extends Application{
    public static Context mContext;

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
