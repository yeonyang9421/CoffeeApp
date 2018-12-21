package kr.co.woobi.imyeon.coffeeapp.activities;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import kr.co.woobi.imyeon.coffeeapp.R;
import kr.co.woobi.imyeon.coffeeapp.fragments.ColorFragment;

public class ColorFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_fragment);


        //프래그먼트 가져오기
        ColorFragment colorFragment = (ColorFragment)getSupportFragmentManager().findFragmentById(R.id.color_frag);
        colorFragment.setColor(Color.BLUE);

        //동적으로 프래그먼트 추가
        ColorFragment colorFragment2 = new ColorFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container,colorFragment2).commit();
    }


    public void onClick(View view) {
        ColorFragment newColorFragment = new ColorFragment();
        int color = Color.YELLOW ;
        newColorFragment.setColor(color);
        //기존의프로그먼트로 교체
        getSupportFragmentManager().beginTransaction().replace(R.id.container, newColorFragment).commit();




    }
}
