package kr.co.woobi.imyeon.coffeeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class SignUpExamActivity extends Activity implements View.OnClickListener {
    public static final int REQUEST_CODE_SIGNUP = 1000;
    private EditText mIdEditText, mPassEditText, mPass2EditText, mEmailEditText;
    private RadioButton mRadioMale, mRadioFemale;
    private RadioGroup mRadioGroupGender;

    private ArrayList<EditText> mEditTextList;
    private String mGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_exam);
        mEditTextList = new ArrayList<>();

        mIdEditText = findViewById(R.id.edit_id);
        mPassEditText = findViewById(R.id.edit_password);
        mPass2EditText = findViewById(R.id.edit_pass2);
        mEmailEditText = findViewById(R.id.edit_email);

        mEditTextList.add(mIdEditText);
        mEditTextList.add(mPassEditText);
        mEditTextList.add(mPass2EditText);
        mEditTextList.add(mEmailEditText);

        mRadioMale = findViewById(R.id.radio_male);
        mRadioFemale = findViewById(R.id.radio_female);

        mRadioGroupGender = findViewById(R.id.radioGroup_gender);
        mRadioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mGender = ((RadioButton) findViewById(checkedId)).getText().toString();
            }
        });
        findViewById(R.id.button_reset).setOnClickListener(this);
        findViewById(R.id.button_signup).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_reset:
                reset();
                break;
            case R.id.button_signup:
                signup();
                break;
        }
    }

    private void signup() {
        if (!isValid()) {
            Toast.makeText(this, "모두 입력 해 주셔야 합니다.", Toast.LENGTH_SHORT).show();
        } else if (!isValidPassword()) {
            Toast.makeText(this, "비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
        } else {
            //가입
            Intent intent = new Intent(this, SignUpExamTargetActivity.class);
            intent.putExtra("id", mIdEditText.getText().toString());
            intent.putExtra("pass", mPassEditText.getText().toString());
            intent.putExtra("email", mEmailEditText.getText().toString());
            intent.putExtra("gender", mGender);
            startActivityForResult(intent, REQUEST_CODE_SIGNUP);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SIGNUP && resultCode == RESULT_OK) {
//            reset();
            Toast.makeText(this, "확인버튼을 누르셨습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    // 빈 공간이 없이 입력해는지 체크한다
    private boolean isValid() {
        for (EditText editText : mEditTextList) {
            if (TextUtils.isEmpty(editText.getText().toString())) {
                return false;
            }
        }
        if (mRadioGroupGender.getCheckedRadioButtonId() == -1) {
            return false;
        }
        return true;
    }

    //패스워드 입력시 같은 번호로 두번 입력했는지 묻는다
    private boolean isValidPassword() {
        return mPassEditText.getText().toString().equals(mPass2EditText.getText().toString());
    }

    private void reset() {
        boolean flag=false;
        for (EditText editText : mEditTextList) {
            editText.setText("");
        }
//                mRadioGroupGender.clearCheck();
    }
}
