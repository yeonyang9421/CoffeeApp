package kr.co.woobi.imyeon.coffeeapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import kr.co.woobi.imyeon.coffeeapp.R;

public class TargetActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        mValueTextView = findViewById(R.id.text_value);
        if (getIntent() != null) {
            String value = getIntent().getStringExtra("value");
            mValueTextView.setText(value);
        }
        findViewById(R.id.buttonResult).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        intent.putExtra("result","이것은 내가 지정한 문구이다.");
        intent.putExtra("int",9421);
        setResult(RESULT_OK,intent);
        finish();

    }
}
