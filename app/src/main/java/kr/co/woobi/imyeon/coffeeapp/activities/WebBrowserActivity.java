package kr.co.woobi.imyeon.coffeeapp.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.woobi.imyeon.coffeeapp.R;

public class WebBrowserActivity extends AppCompatActivity {
    EditText mEditUrl;
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);

        mEditUrl = findViewById(R.id.edit_url);
        mWebView = findViewById(R.id.web_view);

        //자바스크립트 사용 할 수 있도록
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient());

        //키보드의 돋보기 누르면 이동하기 구현
        mEditUrl.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_SEARCH){
                    mWebView.loadUrl(mEditUrl.getText().toString());

                    //키보드 아래로 숨기는 코드
                    InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mEditUrl.getWindowToken(),0);
                }
                return true;
            }
        });



        findViewById(R.id.button_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.loadUrl(mEditUrl.getText().toString());
                //키보드 아래로 숨기는 코드
                InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mEditUrl.getWindowToken(),0);
            }
        });
    }

//뒤로 가기 키 캐치
    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    //메뉴를 붙이는 부분
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_webview, menu);
        return true;
    }

    //옵션메뉴 클릭시 이벤트 처리하기
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_back:
                if (mWebView.canGoBack()) {
                    mWebView.goBack();
                }
                return true;
            case R.id.action_forward:
                if (mWebView.canGoForward()) {
                    mWebView.goForward();
                }
                return true;
            case R.id.action_reload:
                mWebView.reload();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
