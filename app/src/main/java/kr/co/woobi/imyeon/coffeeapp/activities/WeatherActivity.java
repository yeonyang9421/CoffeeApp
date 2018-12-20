package kr.co.woobi.imyeon.coffeeapp.activities;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import kr.co.woobi.imyeon.coffeeapp.R;
import kr.co.woobi.imyeon.coffeeapp.adapters.WeatherAdapter;
import kr.co.woobi.imyeon.coffeeapp.models.Weather;

public class WeatherActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private ListView mListView;
    private  GridView mGridView;
    private Spinner mSpinner;
    private WeatherAdapter mAdapter;
    private List<Weather> mWeatherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        mListView = findViewById(R.id.listview_weather);
        mGridView=findViewById(R.id.gridview);
        mSpinner=findViewById(R.id.spinner);

        mWeatherList = new ArrayList<>();

        mWeatherList.add(new Weather(R.drawable.weather_01, "서울", "0도"));
        mWeatherList.add(new Weather(R.drawable.weather_02, "벤쿠버", "30도"));
        mWeatherList.add(new Weather(R.drawable.weather_03, "세부", "36도"));
        mWeatherList.add(new Weather(R.drawable.weather_04, "괌", "31도"));
        mWeatherList.add(new Weather(R.drawable.weather_11, "베이징", "4도"));
        mWeatherList.add(new Weather(R.drawable.weather_06, "오타루", "15도"));
        mWeatherList.add(new Weather(R.drawable.weather_07, "빅토리아", "36도"));
        mWeatherList.add(new Weather(R.drawable.weather_08, "뉴욕", "31도"));
        mWeatherList.add(new Weather(R.drawable.weather_09, "베를린", "4도"));
        mWeatherList.add(new Weather(R.drawable.weather_10, "시드니", "15도"));
        mWeatherList.add(new Weather(R.drawable.weather_11, "워싱턴", "4도"));
        mWeatherList.add(new Weather(R.drawable.weather_12, "평양", "15도"));
        mWeatherList.add(new Weather(R.drawable.weather_13, "헝거리", "36도"));
        mWeatherList.add(new Weather(R.drawable.weather_14, "도쿄", "4도"));
        mWeatherList.add(new Weather(R.drawable.weather_15, "콜롬비아", "15도"));
        mWeatherList.add(new Weather(R.drawable.weather_16, "헬싱키", "36도"));

        //어댑터
        mAdapter = new WeatherAdapter(this, mWeatherList);

        //어댑터를 뷰에 설정
        mListView.setAdapter(mAdapter);
        mGridView.setAdapter(mAdapter);
        mSpinner.setAdapter(mAdapter);

        //이벤트처리
        mListView.setOnItemClickListener(this);
        mListView.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mAdapter.setSelect(position);
        mWeatherList.add(new Weather(R.drawable.moca, "우리집", "졸립다"));

        //데이터가 변경됨을 알려서 리프레시하게 함
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        mWeatherList.remove(position);
        mAdapter.notifyDataSetChanged();
        return true;
    }
}
