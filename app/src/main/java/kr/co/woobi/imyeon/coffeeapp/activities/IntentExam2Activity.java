package kr.co.woobi.imyeon.coffeeapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import kr.co.woobi.imyeon.coffeeapp.R;

public class IntentExam2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_exam2);

        findViewById(R.id.button_custom).setOnClickListener(this);
        findViewById(R.id.button_sales).setOnClickListener(this);
        findViewById(R.id.button_product).setOnClickListener(this);

        if(getIntent() !=null){
            String id= getIntent().getStringExtra("id");
            String pass=getIntent().getStringExtra("password");

            Toast.makeText(this, "id :" + id+ ",    password: " +pass, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        String text=((Button)v).getText().toString();
        Intent intent=new Intent();
        intent.putExtra("result", text);
        setResult(RESULT_OK,intent);
        finish();

//        switch (v.getId()){
//            case R.id.button_custom:
//
//                break;
//            case R.id.button_sales:
//
//                break;
//            case R.id.button_product:
//
//                break;
//
//        }
    }
}
