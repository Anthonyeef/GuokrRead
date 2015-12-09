package io.github.anthonyeef.guokrread.rest.model;

import java.util.List;

import io.github.anthonyeef.guokrread.model.Post;

/**
 * Created by anthonyeef on 12/9/15.
 */
public class ResponseModel {
    private String now;
    private String ok;

    public List<Post> result;

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<Post> getResult() {
        return result;
    }

    public void setResult(List<Post> result) {
        this.result = result;
    }

/*    @Override
    public String toString() {
        return "Result={" +
                "now=" + now +
                "ok status=" + ok +
                "}";
    }*/
}
