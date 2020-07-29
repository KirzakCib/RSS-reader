package com.example.rss_reader;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ParserXML {

    @GET("/ru/rss/hubs/all/")
    Call<ParserHabr> parserHabr();

    @GET("/.rss")
    Call<ParserReddit> parserReddit();

    @GET("/rss/podcasts/meduza-v-kurse")
    Call<ParserMeduza> parserMeduza();

}
