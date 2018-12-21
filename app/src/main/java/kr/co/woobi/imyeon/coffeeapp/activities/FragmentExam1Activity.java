package kr.co.woobi.imyeon.coffeeapp.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import kr.co.woobi.imyeon.coffeeapp.R;
import kr.co.woobi.imyeon.coffeeapp.fragments.ColorFragment;
import kr.co.woobi.imyeon.coffeeapp.fragments.TextFragment;

public class FragmentExam1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_exam1);
    }

    private void addFragment(int containerId, int Color, String text) {
        TextFragment textFragment = new TextFragment();
        textFragment.setColor(Color);
        getSupportFragmentManager().beginTransaction().add(containerId, textFragment).commit();
        textFragment.setText(text);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                addFragment(R.id.container1, Color.RED, "1번 프래그먼트");
                break;
            case R.id.button2:
                addFragment(R.id.container2, Color.BLUE, "2번 프래그먼트");
                break;
            case R.id.button3:
                addFragment(R.id.container3, Color.YELLOW, "3번 프래그먼트");
                break;
        }
    }
}
