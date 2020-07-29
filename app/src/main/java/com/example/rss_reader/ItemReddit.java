package com.example.rss_reader;


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(name = "entry", strict = false)
class ItemReddit {

    @Element(name = "title")
    private String title;

    @Element(name = "content")
    private String content;

    @Attribute(name="url")
    @Path("media:thumbnail")
    private String picture;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
