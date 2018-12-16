package kr.co.woobi.imyeon.coffeeapp;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.woobi.imyeon.coffeeapp.adapters.WeatherAdapter;
import kr.co.woobi.imyeon.coffeeapp.models.Weather;

public class WeatherActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private WeatherAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        mListView = findViewById(R.id.listview_weather);

        List<Weather> weatherList=new ArrayList<>();

        weatherList.add(new Weather(R.drawable.weather_01, "서울","0도"));
        weatherList.add(new Weather(R.drawable.weather_02, "벤쿠버","30도"));
        weatherList.add(new Weather(R.drawable.weather_03, "세부","36도"));
        weatherList.add(new Weather(R.drawable.weather_04, "괌","31도"));
        weatherList.add(new Weather(R.drawable.weather_11, "베이징","4도"));
        weatherList.add(new Weather(R.drawable.weather_06, "오타루","15도"));
        weatherList.add(new Weather(R.drawable.weather_07, "빅토리아","36도"));
        weatherList.add(new Weather(R.drawable.weather_08, "뉴욕","31도"));
        weatherList.add(new Weather(R.drawable.weather_09, "베를린","4도"));
        weatherList.add(new Weather(R.drawable.weather_10, "시드니","15도"));
        weatherList.add(new Weather(R.drawable.weather_11, "워싱턴","4도"));
        weatherList.add(new Weather(R.drawable.weather_12, "평양","15도"));
        weatherList.add(new Weather(R.drawable.weather_13, "헝거리","36도"));
        weatherList.add(new Weather(R.drawable.weather_14, "도쿄","4도"));
        weatherList.add(new Weather(R.drawable.weather_15, "콜롬비아","15도"));
        weatherList.add(new Weather(R.drawable.weather_16, "헬싱키","36도"));

        //어댑터
        mAdapter =new WeatherAdapter(this, weatherList);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mAdapter.setSelect(position);

        //데이터가 변경됨을 알려서 리프레시하게 함
        mAdapter.notifyDataSetChanged();
    }
}
