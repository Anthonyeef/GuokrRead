package io.github.anthonyeef.guokrread.model;

/**
 * Created by anthonyeef on 11/19/15.
 */

/*TO DO: implement pacel plugin*/
public class Post {

    public Post() {

    }

    private String id;
    private String category;
    private String link_source;
    private String title;
    private String source_name;
    private String author;
    private String summary;
    private boolean is_top;
    private String headline_img;
    private String replies_count;
    private String link_v2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReplies_count() {
        return replies_count;
    }

    public void setReplies_count(String replies_count) {
        this.replies_count = replies_count;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getLink_v2() {
        return link_v2;
    }

    public void setLink_v2(String link_v2) {
        this.link_v2 = link_v2;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink_source() {
        return link_source;
    }

    public void setLink_source(String link_source) {
        this.link_source = link_source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean is_top() {
        return is_top;
    }

    public void setIs_top(boolean is_top) {
        this.is_top = is_top;
    }

    public String getHeadline_img() {
        return headline_img;
    }

    public void setHeadline_img(String headline_img) {
        this.headline_img = headline_img;
    }
}
