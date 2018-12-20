package kr.co.woobi.imyeon.coffeeapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.woobi.imyeon.coffeeapp.R;

public class SignUpExamTargetActivity extends AppCompatActivity {
private TextView mResultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_exam_target);
        mResultTextView=findViewById(R.id.text_result);

        if(getIntent()!=null){
            String id=getIntent().getStringExtra("id");
            String pass=getIntent().getStringExtra("pass");
            String email=getIntent().getStringExtra("email");
            String gender=getIntent().getStringExtra("gender");
            String result = String.format("아이디 : %s\n 비밀번호 : %s \n이메일 :  %s \n 성별 : %s" ,id ,pass, email, gender);
//            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            mResultTextView.setText(result);
        }

        findViewById(R.id.button_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setResult(RESULT_OK);
               finish();
            }
        });
    }
}
