package kr.co.woobi.imyeon.coffeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import kr.co.woobi.imyeon.coffeeapp.managers.Bank;
import kr.co.woobi.imyeon.coffeeapp.models.Account;

public class CheckAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mIdEditText;
    private EditText mPassEditText;
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_account);

        mIdEditText = (EditText) findViewById(R.id.edit_inputId);
        mPassEditText = (EditText) findViewById(R.id.edit_inputpass);
        mResultTextView = (TextView) findViewById(R.id.text_result);

        findViewById(R.id.button_accountlogin).setOnClickListener(this);
        findViewById(R.id.button_close).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_accountlogin:
                Bank bank=Bank.newInstance();
                String id=mIdEditText.getText().toString();
                String pass=mPassEditText.getText().toString();

                Account account= bank.login(id, pass);
                if(account!=null){
                    mResultTextView.setText(account.toString());
                }
                break;
            case R.id.button_close:
                finish();
                break;
        }

    }
}
