package com.example.rss_reader;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thoughtbot.expandablerecyclerview.ExpandableListUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class Fragment_Recycler extends Fragment {

    static final String BASE_URL_MEDUZA = "https://meduza.io";
    RecyclerView recyclerView;
    ArrayList<DataList> dataLists =  new ArrayList<>();
    Adapter adapter;
    Integer count = 10;

    public static Fragment_Recycler newInstance() {
        return new Fragment_Recycler();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new Adapter(dataLists);
        recyclerView.setAdapter(adapter);

                Retrofit retrofitMeduza = new Retrofit.Builder().baseUrl(BASE_URL_MEDUZA)
                .addConverterFactory(SimpleXmlConverterFactory.create()).build();

        ParserXML parserXMLMeduza = retrofitMeduza.create(ParserXML.class);

        Call<ParserMeduza> call_meduza = parserXMLMeduza.parserMeduza();

        call_meduza.enqueue(new Callback<ParserMeduza>() {
            @Override
            public void onResponse(Call<ParserMeduza> call, Response<ParserMeduza> response) {
                if(response.isSuccessful()){
                    ParserMeduza parserMeduza = response.body();
                        int size = 0;
                    for(ItemMeduza itemMeduza : parserMeduza.getItemMeduza()){
                        if(size == 10)
                            continue;
                            ArrayList<Child> childList = new ArrayList<>();
                            childList.add(new Child(itemMeduza.getDescription()));
                            DataList dataList = new DataList(itemMeduza.getTitle(),BASE_URL_MEDUZA,itemMeduza.getImage(),childList);
                            dataLists.add(dataList);
                            size++;
                    }
                    ExpandableListUtils.notifyGroupDataChanged(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ParserMeduza> call, Throwable t) {
                Toast.makeText(getActivity(),"Пожалуйста, проверьте ваше подключение к сети." + "\n" + "С уважением.",Toast.LENGTH_SHORT).show();
            }
        });

        final LinearLayoutManager linearLayoutManager
                = (LinearLayoutManager) recyclerView.getLayoutManager();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                Log.e("linearLayoutManager.getItemCount()", String.valueOf(linearLayoutManager.getItemCount()));
                Log.e("linearLayoutManager.findLastVisibleItemPosition()", String.valueOf(linearLayoutManager.findLastVisibleItemPosition()));

                if ((linearLayoutManager.getItemCount() == (linearLayoutManager.findLastVisibleItemPosition() + 1)) && (count <= (linearLayoutManager.findLastVisibleItemPosition() + 1))) {

                    Toast.makeText(getContext(),"Загрузка данных...",Toast.LENGTH_SHORT).show();

                    Call<ParserMeduza> meduza = parserXMLMeduza.parserMeduza();


                        meduza.enqueue(new Callback<ParserMeduza>() {
                            @Override
                            public void onResponse(Call<ParserMeduza> call, Response<ParserMeduza> response) {
                                if (response.isSuccessful()) {
                                    ParserMeduza parserMeduza = response.body();
                                    int size = 0;
                                    for (ItemMeduza itemMeduza : parserMeduza.getItemMeduza()) {

                                        if (size == count + 10)
                                            continue;
                                        if (!(size < count)) {
                                            ArrayList<Child> childList = new ArrayList<>();
                                            childList.add(new Child(itemMeduza.getDescription()));
                                            DataList dataList = new DataList(itemMeduza.getTitle(), BASE_URL_MEDUZA, itemMeduza.getImage(), childList);
                                            dataLists.add(dataList);
                                            size++;
                                        } else {
                                            size++;
                                        }
                                    }
                                    ExpandableListUtils.notifyGroupDataChanged(adapter);
                                    adapter.notifyDataSetChanged();
                                }
                            }

                            @Override
                            public void onFailure(Call<ParserMeduza> call, Throwable t) {
                                Toast.makeText(getActivity(), "Пожалуйста, проверьте ваше подключение к сети." + "\n" + "С уважением.", Toast.LENGTH_SHORT).show();
                            }
                        });

                    count += 10;
                }
            }
        });
    }
}
