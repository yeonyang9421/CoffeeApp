package kr.co.woobi.imyeon.coffeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kr.co.woobi.imyeon.coffeeapp.adapters.MemoAdapter;
import kr.co.woobi.imyeon.coffeeapp.models.Memo;

public class MemoActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_NEW_MEMO = 1000;
    public static final String TAG = MemoActivity.class.getSimpleName();

    private List<Memo> mMemoList;
    private MemoAdapter mAdapter;
    private ListView mMemoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mMemoListView=findViewById(R.id.list_view_memo);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MemoActivity.this, Memo2Activity.class);
                startActivityForResult(intent, REQUEST_CODE_NEW_MEMO);
            }
        });

        //데이터
        mMemoList = new ArrayList<>();

        //어댑터
       mAdapter=new MemoAdapter(mMemoList);

       mMemoListView.setAdapter(mAdapter);;


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE_NEW_MEMO && resultCode==RESULT_OK){
            String title= data.getStringExtra("title");
            String content = data.getStringExtra("content");

            mMemoList.add(new Memo(title,content));
            mAdapter.notifyDataSetChanged();

            Log.d(TAG,"onActivityResult : " + title + "," +content);
            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "취소되었습니다.", Toast.LENGTH_SHORT).show();
        }
    }

}
