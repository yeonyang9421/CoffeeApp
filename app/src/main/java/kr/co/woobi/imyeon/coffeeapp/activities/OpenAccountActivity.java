package kr.co.woobi.imyeon.coffeeapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import kr.co.woobi.imyeon.coffeeapp.R;
import kr.co.woobi.imyeon.coffeeapp.managers.Bank;
import kr.co.woobi.imyeon.coffeeapp.models.Account;

public class OpenAccountActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_account);

        findViewById(R.id.button_open).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Bank bank= Bank.newInstance();
        String id=((EditText)findViewById(R.id.edit_accountId)).getText().toString();
        String pass=((EditText)findViewById(R.id.edit_accountpass)).getText().toString();
        int balance=Integer.parseInt(((EditText)findViewById(R.id.edit_accountbalance)).getText().toString());

        Account account=new Account(id, pass, balance);
        bank.open(account);

        Toast.makeText(this, "개설 되었습니다.", Toast.LENGTH_SHORT).show();
        finish();
    }
}
