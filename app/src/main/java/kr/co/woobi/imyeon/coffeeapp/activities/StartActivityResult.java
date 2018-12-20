package kr.co.woobi.imyeon.coffeeapp.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import kr.co.woobi.imyeon.coffeeapp.R;

public class StartActivityResult extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE = 1000;
    private static final String TAG =StartActivityResult.class.getSimpleName() ;
    private EditText mValueEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_result);

        mValueEditText=findViewById(R.id.value_edit);
        findViewById(R.id.submit_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent =new Intent(this, TargetActivity.class);
        intent.putExtra("value", mValueEditText.getText().toString());
        //주거니 받거니 할때 사용
        startActivityForResult(intent, REQUEST_CODE);
    }

    //받을 때 호출 되는 콜백 메소드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if(requestCode==REQUEST_CODE && resultCode==RESULT_OK && data !=null){
           Log.d(TAG,"onActivityResult : " + requestCode);
           Log.d(TAG,"onActivityResult : " + resultCode);
           Log.d(TAG,"onActivityResult : " + data);
           String result=data.getStringExtra("result");
           int value= data.getIntExtra("int",-1);
            Toast.makeText(this, result + value, Toast.LENGTH_SHORT).show();
        }
    }
}
