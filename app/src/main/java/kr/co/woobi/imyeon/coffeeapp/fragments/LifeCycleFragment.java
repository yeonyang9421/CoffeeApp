package kr.co.woobi.imyeon.coffeeapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.woobi.imyeon.coffeeapp.R;

public class LifeCycleFragment extends Fragment {

    //빈 생성자가 필요, 파라미터를 가질 수 없다 (이유: 액티비티의 생명주기를 따르기 위해서이다)
    public LifeCycleFragment() {
        // Required empty public constructor
    }

    //액티비티에 붙을 때
    @Override
    public void onAttach(Context context) {
        //context : 액티비티
        super.onAttach(context);
    }

    //프그래먼ㅌ가 생성될 때
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //savedInstanceState로 복원처리 가능
        super.onCreate(savedInstanceState);
    }

    //액티비티의 onCreate()에 해당 : 레이아웃 완성!
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false);
    }

    //액티비티가 실제로 생성된 직후, 호출!
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //뷰 소명시킴
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    //프래그먼트 소멸
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //액티비티에서 떨어 짐
    @Override
    public void onDetach() {
        super.onDetach();
    }
}
