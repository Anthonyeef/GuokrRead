package io.github.anthonyeef.guokrread.rest.model;

import java.util.List;

/**
 * Created by anthonyeef on 11/19/15.
 */

/*TO DO: implement pacel plugin*/
public class result {

    private String category;
    private String link_v2_sync_img;
    private String source_name;
    private String title;
    private String page_source;
    private List<String> images;
    private String author;
    private long date_picked;
    private long reply_root_id;
    private String summary;
    private String source;
    private boolean is_top;
    private long date_created;
    private String link;
    private String link_v2;
    private String headline_img;
    private long replies_count;
    private String headline_img_tb;
    private String id;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink_v2_sync_img() {
        return link_v2_sync_img;
    }

    public void setLink_v2_sync_img(String link_v2_sync_img) {
        this.link_v2_sync_img = link_v2_sync_img;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPage_source() {
        return page_source;
    }

    public void setPage_source(String page_source) {
        this.page_source = page_source;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getDate_picked() {
        return date_picked;
    }

    public void setDate_picked(long date_picked) {
        this.date_picked = date_picked;
    }

    public long getReply_root_id() {
        return reply_root_id;
    }

    public void setReply_root_id(long reply_root_id) {
        this.reply_root_id = reply_root_id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean is_top() {
        return is_top;
    }

    public void setIs_top(boolean is_top) {
        this.is_top = is_top;
    }

    public long getDate_created() {
        return date_created;
    }

    public void setDate_created(long date_created) {
        this.date_created = date_created;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink_v2() {
        return link_v2;
    }

    public void setLink_v2(String link_v2) {
        this.link_v2 = link_v2;
    }

    public String getHeadline_img() {
        return headline_img;
    }

    public void setHeadline_img(String headline_img) {
        this.headline_img = headline_img;
    }

    public long getReplies_count() {
        return replies_count;
    }

    public void setReplies_count(long replies_count) {
        this.replies_count = replies_count;
    }

    public String getHeadline_img_tb() {
        return headline_img_tb;
    }

    public void setHeadline_img_tb(String headline_img_tb) {
        this.headline_img_tb = headline_img_tb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "result{" +
                "id=" + id +
                ",title=" + title +
                ",author=" + author +
                "headline_img=" + headline_img +
                '}';
    }
}
