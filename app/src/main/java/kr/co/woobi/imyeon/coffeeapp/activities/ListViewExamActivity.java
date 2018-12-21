package kr.co.woobi.imyeon.coffeeapp.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import kr.co.woobi.imyeon.coffeeapp.R;

public class ListViewExamActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Integer> mData;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_exam);

        FloatingActionButton fab = findViewById(R.id.fab_listexam);
        fab.setOnClickListener(this);

        mData = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            mData.add(i);
        }

        mAdapter = new MyAdapter(mData);

        ListView listView = findViewById(R.id.listviewexam);
        listView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        //데이터 뒤집기
        Collections.reverse(mData);
        mAdapter.notifyDataSetChanged();
    }


    private static class MyAdapter extends BaseAdapter {
        private final List<Integer> mData;

        public MyAdapter(List<Integer> data) {
            mData = data;
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
        public View getView(int position, android.view.View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listviewexam, parent, false);
                viewHolder.textView = (TextView) convertView.findViewById(R.id.text_listexam);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            //데이터 표시
            int data = mData.get(position);
            viewHolder.textView.setText("" + data);
            return convertView;
        }
    }

    private static class ViewHolder {
        TextView textView;
    }
}
