package io.github.anthonyeef.guokrread.rest.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by anthonyeef on 12/11/15.
 */

@Root(name = "html")
public class Detail {
    /**
     * body : html content
     * header_img: header image display on header
     */

    @Element(name = "body")
    private String body;

    public Detail() {
        super();
    }

    public String getBody() {
        return body;
    }
}