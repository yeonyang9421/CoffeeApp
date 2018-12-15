package kr.co.woobi.imyeon.coffeeapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ImplicitActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mUrlEditText, mPhoneEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mUrlEditText = findViewById(R.id.edit_url);
        mPhoneEditText = findViewById(R.id.edit_tel);
        findViewById(R.id.button_tel).setOnClickListener(this);
        findViewById(R.id.button_url).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_tel:
                String phoneNumber = mPhoneEditText.getText().toString();
                dailPhone(phoneNumber);
                break;
            case R.id.button_url:
                String url = mUrlEditText.getText().toString();
                showUrl(url);
                break;
        }
    }

    private void showUrl(String url) {
        if (!url.startsWith("http://")) {
            url = "http://" + url;
        }
        Uri webPage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "실행할 앱이 없습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    public void dailPhone(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "실행할 앱이 없습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
