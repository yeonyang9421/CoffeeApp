package kr.co.woobi.imyeon.coffeeapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import kr.co.woobi.imyeon.coffeeapp.R;
import kr.co.woobi.imyeon.coffeeapp.managers.Bank;

public class BankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_account_open:
                //계좌개설
                startActivity(new Intent(this, OpenAccountActivity.class));
                break;
            case R.id.button_account_check:
                startActivity(new Intent(this, CheckAccountActivity.class));
                break;
            case  R.id.button_account_admin:
                showAdminDialog();
                break;
            case R.id.button_account_exit:
                finish();
                break;
        }
    }

    private void showAdminDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        View view=LayoutInflater.from(this).inflate(R.layout.dialog_login, null, false);
        final EditText idEditText=view.findViewById(R.id.id_edit);
        final EditText passEditText=view.findViewById(R.id.password_edit);

        builder.setView(view);
        builder.setPositiveButton("로그인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String id=idEditText.getText().toString();
                String pass=passEditText.getText().toString();
                Bank bank= Bank.newInstance();
                if(bank.isAdmin(id, pass)){
                    //관리자라면
                    startActivity(new Intent(BankActivity.this, AdminModeActivity.class));
                }
            }
        });
        builder.setNegativeButton("닫기",null);
        builder.show();
    }
}
