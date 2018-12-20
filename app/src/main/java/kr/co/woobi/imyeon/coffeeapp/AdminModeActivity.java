package kr.co.woobi.imyeon.coffeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import kr.co.woobi.imyeon.coffeeapp.managers.Bank;
import kr.co.woobi.imyeon.coffeeapp.models.Account;
import kr.co.woobi.imyeon.coffeeapp.models.Memo;

public class AdminModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mode);

        ListView listView=(ListView)findViewById(R.id.account_info_list);
        Bank bank=Bank.newInstance();

        BankAdapter adapter= new BankAdapter(bank.getAccountList());
        listView.setAdapter(adapter);


    }

    public void onClick(View view) {
        finish();
    }

    private static class BankAdapter extends BaseAdapter {
        private final List<Account> mData;

        public BankAdapter(List<Account> accountList) {
            mData = accountList;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;

            //convertView : 재사용되는 뷰
            if (convertView == null) {
                viewHolder = new ViewHolder();

                //뷰를 새로 만들 떄
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_account_info, parent, false);

                //레이아웃 들고 오기
                TextView idtext = convertView.findViewById(R.id.account_title_text);
                TextView balanceTextView = convertView.findViewById(R.id.balance_text);

                //뷰홀더에 엮어서 넣는다.
                viewHolder.idtext = idtext;
                viewHolder.balanceText = balanceTextView;

                //뷰홀더를 컨버트뷰에 엮는다.
                convertView.setTag(viewHolder);
            } else {
                //재사용 할때
                viewHolder = (ViewHolder) convertView.getTag();
            }

            //데이터 가져오기
            Account account = mData.get(position);

            //화면에 뿌리기
            viewHolder.idtext.setText(account.getId());
            viewHolder.balanceText.setText(""+account.getBalance());

            return convertView;
        }

        //-1이면 선택된게 없다.
        private int mSelectedPostion = -1;

        public void setSelect(int position) {
            mSelectedPostion = position;
        }

        //findViewById로 가져온 View 들을 복원하여 getview에서 재사용시 매번 findviewbyid 를 하지 않아도 되도록 한다.
        private static class ViewHolder {
            TextView idtext;
            TextView balanceText;
        }
    }
}

