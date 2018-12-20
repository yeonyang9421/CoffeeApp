package kr.co.woobi.imyeon.coffeeapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import kr.co.woobi.imyeon.coffeeapp.R;

public class LifeCycleActivity extends AppCompatActivity {

    private static final String TAG=LifeCycleActivity.class.getSimpleName();
    private TextView mScoreTextView;
    private int mScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        mScoreTextView=findViewById(R.id.text_score);
        setScore(mScore);
        Log.d(TAG, "onCreate: ");

        //복원
        if(savedInstanceState !=null){
            mScore=savedInstanceState.getInt("score");
            setScore(mScore);
        }
    }

    //복원하는 또다른 콜백함수 이니까 알아두라고
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        //복원
//        if(savedInstanceState !=null){
//            mScore=savedInstanceState.getInt("score");
//            setScore(mScore);
//        }
    }

    private void setScore(int score) {
        mScoreTextView.setText("점수 : " + score);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart : ");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume : ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop : ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onReStart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    public void onClick(View view) {
      mScore +=100;
      setScore(mScore);
    }

    //인스턴스의 상태를 저장
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
        outState.putInt("score", mScore);
    }
}
