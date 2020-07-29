package com.example.rss_reader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {


//    static final String BASE_URL_HABR = "https://habr.com";
//    static final String BASE_URL_REDDIT  = "https://www.reddit.com";
//    static final String BASE_URL_MEDUZA = "https://meduza.io";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, Fragment_Recycler.newInstance()).commit();
        }
//****************************GETTING DATA FOR WEBSITES****************************************************

//******************************PARSER WITH MEDUZA*******************************************

//        Retrofit retrofitMeduza = new Retrofit.Builder().baseUrl(BASE_URL_MEDUZA)
//                .addConverterFactory(SimpleXmlConverterFactory.create()).build();
//
//        ParserXML parserXMLMeduza = retrofitMeduza.create(ParserXML.class);
//
//        Call<ParserMeduza> call_meduza = parserXMLMeduza.parserMeduza();
//
//        call_meduza.enqueue(new Callback<ParserMeduza>() {
//            @Override
//            public void onResponse(Call<ParserMeduza> call, Response<ParserMeduza> response) {
//                if(response.isSuccessful()){
//
//                    TextView textView = findViewById(R.id.text);
//                    ParserMeduza parserMeduza = response.body();
//
//                    for(ItemMeduza itemMeduza : parserMeduza.getItemMeduza()){
//                        textView.append(itemMeduza.getTitle() + "\n");
//                        textView.append(itemMeduza.getImage() + "\n");
//                        textView.append(itemMeduza.getDescription() + "\n\n");
//                    }
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ParserMeduza> call, Throwable t) {
//
//            }
//        });

//******************************PARSER WITH REDDIT*******************************************

//        Retrofit retrofitReddit = new Retrofit.Builder().baseUrl(BASE_URL_REDDIT)
//                .addConverterFactory(SimpleXmlConverterFactory.create()).build();
//
//        ParserXML parserXMLReddit = retrofitReddit.create(ParserXML.class);
//
//        Call<ParserReddit> call_reddit = parserXMLReddit.parserReddit();
//
//        call_reddit.enqueue(new Callback<ParserReddit>() {
//            @Override
//            public void onResponse(Call<ParserReddit> call, Response<ParserReddit> response) {
//                if(response.isSuccessful()) {
//                    TextView textView = findViewById(R.id.text);
//                    ParserReddit parserReddit = response.body();
//
//                    for(ItemReddit itemReddit : parserReddit.getItemReddits()){
//                        textView.append(itemReddit.getTitle() + "\n");
//                        textView.append(itemReddit.getPicture() + "\n");
//                        textView.append(Html.fromHtml(itemReddit.getContent()) + "\n\n");
//                    }
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ParserReddit> call, Throwable t) {
//
//            }
//        });

//******************************PARSER WITH HABR*******************************************

//        Retrofit retrofitHabr = new Retrofit.Builder().baseUrl(BASE_URL_HABR)
//                .addConverterFactory(SimpleXmlConverterFactory.create()).build();
//
//        ParserXML parserXMLHabr = retrofitHabr.create(ParserXML.class);
//
//        Call<ParserHabr> call_habr = parserXMLHabr.parserHabr();
//
//        call_habr.enqueue(new Callback<ParserHabr>() {
//            @Override
//            public void onResponse(Call<ParserHabr> call, Response<ParserHabr> response) {
//
//                if(response.isSuccessful()){
//                    TextView textView = findViewById(R.id.text);
//                    ParserHabr parserHabr = response.body();
//                    for(ItemHabr itemHabr : parserHabr.getItemHabrs()){
//                        textView.append(itemHabr.getTitle() + "\n");
//                        textView.append(Html.fromHtml(itemHabr.getDescription()) + "\n");
//                        Document document = Jsoup.parse(itemHabr.getDescription());
//                        Elements elements = document.select("img");
//                        textView.append(elements.attr("src") + "\n\n");
//                    }
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<ParserHabr> call, Throwable t) {
//                Log.e("Error",t.toString());
//            }
//        });

    }

}
