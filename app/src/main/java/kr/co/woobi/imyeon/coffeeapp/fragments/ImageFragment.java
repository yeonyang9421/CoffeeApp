package kr.co.woobi.imyeon.coffeeapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import kr.co.woobi.imyeon.coffeeapp.R;

public class ImageFragment extends Fragment {

    private onImageTouchListener mListener;
    private ImageView mImageView;

    public ImageFragment() {
    }

    public interface onImageTouchListener {
        void onImageTouch(ImageView view, String message);
    }

    public void setOnImageTouchListener(onImageTouchListener listener) {
        mListener = listener;
        getView().setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onImageTouch(mImageView, "임의의 데이터");
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        mImageView = (ImageView) view.findViewById(R.id.image_view);
        return view;
    }
}
