package kr.co.woobi.imyeon.coffeeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<Map<String, Object>> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //뷰
        mListView = findViewById(R.id.list_view);

        //데이터
        mDataList = new ArrayList<>();
        addItem("커피앱", "CheckBox", CoffeeActivity.class);
        addItem("Intent 기초", "주거니받거니", StartActivityResult.class);
        addItem("Intent 기초2", "고객관리버튼 토스트로 넘기기", IntentExamActivity.class);
        addItem("Intent 응용", "회원가입", SignUpExamActivity.class);
        addItem("암시적 인텐트", "전화걸기", ImplicitActivity.class);
        addItem("웹브라우저", "WebView", ImplicitActivity.class);


        MyAdapter adapter = new MyAdapter(mDataList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> map=(Map<String, Object>) parent.getItemAtPosition(position);
                Intent intent= (Intent)map.get("intent");
                startActivity(intent);
            }
        });

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "롱클릭"+position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void addItem(String title, String desc, Class cls) {
        Map<String, Object> map= new HashMap<>();
        map.put("title", title);
        map.put("desc", desc);
        map.put("intent", new Intent(this, cls));
        mDataList.add(map);
    }

    private class MyAdapter  extends BaseAdapter {
        private  final List<Map<String, Object>> mData;

        private MyAdapter(List<Map<String, Object>> data) {
            this.mData = data;
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
            if(convertView==null){
                convertView=LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2,parent,false);
            }
            TextView text1=convertView.findViewById(android.R.id.text1);
            TextView text2 = convertView.findViewById(android.R.id.text2);

            Map<String, Object> item= mData.get(position);
            text1.setText((String)item.get("title"));
            text2.setText((String)item.get("desc"));;
            return convertView;
        }
    }
}