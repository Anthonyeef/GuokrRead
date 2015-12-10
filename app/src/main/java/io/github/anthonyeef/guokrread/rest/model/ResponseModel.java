package io.github.anthonyeef.guokrread.rest.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by anthonyeef on 12/9/15.
 */
public class ResponseModel {
    private String now;
    private String ok;

    public List<io.github.anthonyeef.guokrread.rest.model.result> result;

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

    public List<io.github.anthonyeef.guokrread.rest.model.result> getResult() {
        return result;
    }

    public void add(io.github.anthonyeef.guokrread.rest.model.result result) {
        if (this.result == null) {
            this.result = new LinkedList<>();
        }
        this.result.add(result);
    }


/*    @Override
    public String toString() {
        return "Result={" +
                "now=" + now +
                "ok status=" + ok +
                "}";
    }*/
}
