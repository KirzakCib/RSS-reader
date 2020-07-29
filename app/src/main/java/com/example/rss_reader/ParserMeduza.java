package com.example.rss_reader;


import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "rss", strict = false)
class ParserMeduza {

    @ElementList(name = "item", inline = true)
    @Path("channel")
    private List<ItemMeduza> itemMeduza;

    public List<ItemMeduza> getItemMeduza() {
        return itemMeduza;
    }

    public void setItemMeduza(List<ItemMeduza> itemMeduza) {
        this.itemMeduza = itemMeduza;
    }
}
