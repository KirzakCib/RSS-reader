package com.example.rss_reader;


import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;


@Root(name = "rss", strict = false)
public class ParserHabr {

    @ElementList(name = "item", inline = true)
    @Path("channel")
    private List<ItemHabr> itemHabrs;

    public List<ItemHabr> getItemHabrs() {
        return itemHabrs;
    }

    public void setItemHabrs(List<ItemHabr> itemHabrs) {
        this.itemHabrs = itemHabrs;
    }
}
