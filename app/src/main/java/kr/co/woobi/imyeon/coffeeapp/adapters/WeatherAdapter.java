package kr.co.woobi.imyeon.coffeeapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kr.co.woobi.imyeon.coffeeapp.R;
import kr.co.woobi.imyeon.coffeeapp.models.Weather;

public class WeatherAdapter extends BaseAdapter {
    private Context mContext;
    private  List<Weather> mData;

    public WeatherAdapter(Context context, List<Weather> data) {
        mContext=context;
        mData=data;
    }

    //아이템 개수
    @Override
    public int getCount() {
        return mData.size();
    }

    //position 번째 아이템
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    //position 번째 id
    @Override
    public long getItemId(int position) {
        return position;
    }

    //position 번째의 layout 레이아웃을 정의한다.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView : 재사용되는 뷰
        if(convertView==null){
            convertView=LayoutInflater.from(mContext).inflate(R.layout.item_weather,parent,false);
        }
        //레이아웃 들고 오기
        ImageView imageView=convertView.findViewById(R.id.imageView_weahter);
        TextView textLocation=convertView.findViewById(R.id.text_location);
        TextView textTemperature=convertView.findViewById(R.id.text_temperature);

        //데이터 가져오기
        Weather weather=mData.get(position);

        //화면에 뿌리기
        imageView.setImageResource(weather.getImageRes());
        textLocation.setText(weather.getLocation());
        textTemperature.setText(weather.getTemperature());

        return convertView;
    }
}
