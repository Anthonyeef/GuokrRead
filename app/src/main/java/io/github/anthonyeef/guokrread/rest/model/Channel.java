package io.github.anthonyeef.guokrread.rest.model;

import java.util.ArrayList;
import java.util.List;

import io.github.anthonyeef.guokrread.R;

/**
 * Created by anthonyeef on 12/11/15.
 */
public class Channel {
    private static final int AMOUNT = 7;

    public static final String[] channels = {
            "science", "humanities", "nature", "entertainment",
            "health", "life", "mooc"
    };

    public static int getChannelIcon(int position) {
        switch (position) {
            default:
            case 0:
                return R.drawable.ic_menu;
        }
    }
    public static final List<String> getChannelList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < AMOUNT; i++) {
            list.add(channels[i]);
        }
        return list;
    }
}
