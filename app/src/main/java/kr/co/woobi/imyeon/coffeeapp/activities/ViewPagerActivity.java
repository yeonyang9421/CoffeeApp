package kr.co.woobi.imyeon.coffeeapp.activities;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import kr.co.woobi.imyeon.coffeeapp.R;
import kr.co.woobi.imyeon.coffeeapp.fragments.ColorFragment;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mViewPager=findViewById(R.id.pager);
        mTabLayout=findViewById(R.id.tab);

        MyPagerApdapter adapter=new MyPagerApdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);

    }

    private  static  class MyPagerApdapter extends FragmentPagerAdapter {
        public MyPagerApdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
           switch (i){
               case 0:
                   return ColorFragment.newInstance(Color.RED);
               case 1:
                   return ColorFragment.newInstance(Color.CYAN);
               case 2:
                   return ColorFragment.newInstance(Color.GRAY);
               case 3:
                   return ColorFragment.newInstance(Color.GREEN);
               case 4:
                   return ColorFragment.newInstance(Color.YELLOW);
           };
           return null;
        }

        @Override
        public int getCount() {
            return 5;
        }

        //제목 표시
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "RED";
                case 1:
                    return "CYAN";
                case 2:
                    return "GRAY";
                case 3:
                    return "GREEN";
                case 4:
                    return "YELLOW";
            }
            return  null;
        }
    }
}
