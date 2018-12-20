package kr.co.woobi.imyeon.coffeeapp.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kr.co.woobi.imyeon.coffeeapp.R;
import kr.co.woobi.imyeon.coffeeapp.models.Memo;
import kr.co.woobi.imyeon.coffeeapp.models.Weather;

public class MemoAdapter extends BaseAdapter {
    private final List<Memo> mData;

    public MemoAdapter(List<Memo> mMemoList) {
        mData = mMemoList;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        //convertView : 재사용되는 뷰
        if (convertView == null) {
            viewHolder = new ViewHolder();

            //뷰를 새로 만들 떄
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memo, parent, false);

            //레이아웃 들고 오기
            TextView textTitle = convertView.findViewById(R.id.text_title);
            TextView textContent = convertView.findViewById(R.id.text_content);

            //뷰홀더에 엮어서 넣는다.
            viewHolder.texttitle = textTitle;
            viewHolder.textcontent = textContent;

            //뷰홀더를 컨버트뷰에 엮는다.
            convertView.setTag(viewHolder);
        } else {
            //재사용 할때
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //데이터 가져오기
        Memo memo = mData.get(position);

        //화면에 뿌리기
        viewHolder.texttitle.setText(memo.getTitle());
        viewHolder.textcontent.setText(memo.getContent());

        return convertView;
    }

    //-1이면 선택된게 없다.
    private int mSelectedPostion = -1;

    public void setSelect(int position) {
        mSelectedPostion = position;
    }

    //findViewById로 가져온 View 들을 복원하여 getview에서 재사용시 매번 findviewbyid 를 하지 않아도 되도록 한다.
    private static class ViewHolder {
        TextView texttitle;
        TextView textcontent;
    }
}

