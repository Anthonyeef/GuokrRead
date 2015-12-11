package io.github.anthonyeef.guokrread.rest.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by anthonyeef on 12/11/15.
 */

@Root( name = "html")
public class Detail {
/*    @Element(name = "head")
    public class Head {
        @Element(name = "title")
        public class Title {
            String title;
        }
    }

    @Element(name = "body")
    public class body {
        String body;
    }*/
    @Element(name = "head")
    public String detail;

    public String getDetail() {
        return this.detail;
    }
}
