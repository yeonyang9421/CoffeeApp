package kr.co.woobi.imyeon.coffeeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CoffeeActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = CoffeeActivity.class.getSimpleName();
    public static final int QUANTITY_MAX = 10;
    public static final int QUANTITY_MIN = 0;
    public static final int COFFEE_PRICE = 3000;
    private static  final  int CREAM_PRICE=500;

    private Button mMinusButton, mPlusButton, mOrderButton;
    private TextView mQuantityTextview, mPriceTexview;
    private CheckBox mCreamCheckBox;
    private EditText mCommentEditText;
    private int count;
    private boolean mIsCream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        count=0;

        mMinusButton = findViewById(R.id.buttonminus);
        mPlusButton = findViewById(R.id.buttonplus);
        mOrderButton = findViewById(R.id.buttonOrder);
        mQuantityTextview = findViewById(R.id.textviewcount);
        mPriceTexview = findViewById(R.id.textprice);
        mCreamCheckBox=findViewById(R.id.cream_check);
        mCommentEditText=findViewById(R.id.comment_edit);

        mMinusButton.setOnClickListener(this);
        mPlusButton.setOnClickListener(this);
        mOrderButton.setOnClickListener(this);

      mCreamCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              mIsCream=isChecked;
              display();
          }
      });
}

    @Override
    public void onClick(View v) {
        int price = COFFEE_PRICE;
        String result;
        switch (v.getId()) {
            case R.id.buttonplus:
                Log.d(TAG, "mPlussBttoncLICK");
                Log.v(TAG, "일반로그");
                Log.e(TAG, "에러로그");
                Log.i(TAG, "정보로그");
                Log.w(TAG, "경고로그");
                count += 1;
                if (count > QUANTITY_MAX) {
                    count = QUANTITY_MAX;
                    Toast.makeText(this, "최대주문양은 10개까지 입니다.", Toast.LENGTH_SHORT).show();
                }
                display();
                break;
            case R.id.buttonminus:
                count -= 1;
                if (count < QUANTITY_MIN) {
                    count = QUANTITY_MIN;
                }
                display();
                break;
            case R.id.buttonOrder:
                String message=mPriceTexview.getText().toString();
                Intent intent=new Intent(this, OrderCheckActivity.class);
                intent.putExtra("result", message);
                intent.putExtra("comment",mCommentEditText.getText().toString());
                startActivity(intent);
//                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void display() {
        mQuantityTextview.setText(""+count);

        int tottal = COFFEE_PRICE * count;

        if(mIsCream) {
            tottal += CREAM_PRICE;
        }else{
            tottal-=CREAM_PRICE;
        }
        String result;
        result = String.format("가격 : %d원\n 수량 :  %d개 \n 휘핑크림 : %s\n 감사합니다.",
        tottal,
        count,
        mIsCream);
        mPriceTexview.setText(result);
    }
}
