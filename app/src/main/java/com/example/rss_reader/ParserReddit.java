package com.example.rss_reader;


import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "feed", strict = false)
public class ParserReddit {

    @ElementList(name = "entry", inline = true)
    private List<ItemReddit> itemReddits;

    public List<ItemReddit> getItemReddits() {
        return itemReddits;
    }

    public void setItemReddits(List<ItemReddit> itemReddits) {
        this.itemReddits = itemReddits;
    }
}
