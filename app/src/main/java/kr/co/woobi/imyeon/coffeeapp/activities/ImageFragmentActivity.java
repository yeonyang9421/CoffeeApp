package kr.co.woobi.imyeon.coffeeapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import kr.co.woobi.imyeon.coffeeapp.R;
import kr.co.woobi.imyeon.coffeeapp.fragments.ImageFragment;

public class ImageFragmentActivity extends AppCompatActivity implements ImageFragment.onImageTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_fragment);

        ImageFragment imageFragment=(ImageFragment)getSupportFragmentManager().findFragmentById(R.id.frag_image);
        imageFragment.setOnImageTouchListener(this);
    }

    @Override
    public void onImageTouch(ImageView view, String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
