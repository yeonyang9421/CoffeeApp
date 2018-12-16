package kr.co.woobi.imyeon.coffeeapp.adapters;

import android.content.Context;
import android.graphics.Color;
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
    private List<Weather> mData;

    public WeatherAdapter(Context context, List<Weather> data) {
        mContext = context;
        mData = data;
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
        ViewHolder viewHolder;

        //convertView : 재사용되는 뷰
        if (convertView == null) {
            viewHolder = new ViewHolder();

            //뷰를 새로 만들 떄
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_weather, parent, false);

            //레이아웃 들고 오기
            ImageView imageView = convertView.findViewById(R.id.imageView_weahter);
            TextView textLocation = convertView.findViewById(R.id.text_location);
            TextView textTemperature = convertView.findViewById(R.id.text_temperature);

            //뷰홀더에 엮어서 넣는다.
            viewHolder.imageWeather = imageView;
            viewHolder.textLocation = textLocation;
            viewHolder.textTemperature = textTemperature;

            //뷰홀더를 컨버트뷰에 엮는다.
            convertView.setTag(viewHolder);
        } else {
            //재사용 할때
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //데이터 가져오기
        Weather weather = mData.get(position);

        //화면에 뿌리기
        viewHolder.imageWeather.setImageResource(weather.getImageRes());
        viewHolder.textLocation.setText(weather.getLocation());
        viewHolder.textTemperature.setText(weather.getTemperature());

        //홀수줄에 파란색 짝수줄에 하얀색
        if (position % 2 == 1) {
            convertView.setBackgroundColor(213);
        } else {
            convertView.setBackgroundColor(Color.WHITE);
        }

        //클릭 된 아이템은 노란색으로 변경한다
        if (mSelectedPostion == position) {
            convertView.setBackgroundColor(Color.YELLOW);
        }
        return convertView;
    }

    //-1이면 선택된게 없다.
    private int mSelectedPostion = -1;

    public void setSelect(int position) {
        mSelectedPostion = position;
    }

    //findViewById로 가져온 View 들을 복원하여 getview에서 재사용시 매번 findviewbyid 를 하지 않아도 되도록 한다.
    private static class ViewHolder {
        ImageView imageWeather;
        TextView textLocation;
        TextView textTemperature;
    }
}