package kr.co.woobi.imyeon.coffeeapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import kr.co.woobi.imyeon.coffeeapp.R;

public class ListViewFragment extends Fragment {
    private List<String> mData;

    public static  ListViewFragment newInstance(List<String> data){
        ListViewFragment fragment=new ListViewFragment();
        Bundle bundle=new Bundle();
        bundle.putSerializable("data",(Serializable)data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_list_view, container,false);
        return  view;
    }


    //숨겨진 콜백 꿀팁!!!
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView= view.findViewById(R.id.list_view);
        Bundle bundle=getArguments();
        mData=(List<String>)bundle.getSerializable("data");

        MyAdapter adapter=new MyAdapter(mData);

        listView.setAdapter(adapter);
    }

    private  static  class MyAdapter extends BaseAdapter{

        private final List<String> mmData;

        public MyAdapter(List<String> data) {
            mmData=data;
        }

        @Override
        public int getCount() {
            return mmData.size();
        }

        @Override
        public Object getItem(int position) {
            return mmData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, android.view.View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView ==null){
                viewHolder=new ViewHolder();
                convertView=LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
                viewHolder.textView=(TextView)convertView.findViewById(android.R.id.text1);
                convertView.setTag(viewHolder);
            }else{
                viewHolder=(ViewHolder)convertView.getTag();
            }
            String data= mmData.get(position);
            viewHolder.textView.setText(data);
            return convertView;
        }
    }

    private static  class  ViewHolder{
        TextView textView;
    }
}
