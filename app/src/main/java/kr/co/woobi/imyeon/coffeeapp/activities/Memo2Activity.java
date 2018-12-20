package kr.co.woobi.imyeon.coffeeapp.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toolbar;

import java.util.PropertyResourceBundle;

import kr.co.woobi.imyeon.coffeeapp.R;
import kr.co.woobi.imyeon.coffeeapp.models.Memo;

public class Memo2Activity extends AppCompatActivity {
    private EditText mEdtitTitle, mEditContent;
    private  long mId=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo2);

        mEdtitTitle = findViewById(R.id.edit_title);
        mEditContent = findViewById(R.id.edit_content);

//        Toolbar toolbar=findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        if(getIntent()!=null){
            if(getIntent().hasExtra("memo")){
                //보여주기
                mId=getIntent().getLongExtra("id",-1);
                Memo memo=(Memo)getIntent().getSerializableExtra("memo");
                mEdtitTitle.setText(memo.getTitle());
                mEditContent.setText(memo.getContent());

            }
        }
    }

    //메뉴를 붙이는 부분
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_memo2, menu);
        return true;
    }


    //옵션메뉴 클릭시 이벤트 처리하기
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                save();
                return true;
            case R.id.action_cancel:
                cancel();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void cancel() {
        setResult(RESULT_CANCELED);
        finish();
    }

    private void save() {
        Intent intent = new Intent();
        intent.putExtra("title", mEdtitTitle.getText().toString());
        intent.putExtra("content", mEditContent.getText().toString());
        intent.putExtra("id",mId);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1000 && resultCode==RESULT_OK && data !=null){
            if(getIntent().hasExtra("memo")){
                //보여주기
                mId=getIntent().getLongExtra("id",-1);
                Memo memo=(Memo)getIntent().getSerializableExtra("memo");
                mEdtitTitle.setText(memo.getTitle());
                mEditContent.setText(memo.getContent());

            }
        }
    }
}

