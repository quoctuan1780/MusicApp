package com.example.layout_app_music.animation;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.layout_app_music.DangKi;
import com.example.layout_app_music.R;
import com.example.layout_app_music.custom_view.AnhBoTron;

import java.util.ArrayList;

public class ThuVien extends Fragment {
    private View view;
    private ArrayList<SlideAnimation> listQuangcao;
    private ViewPager vpQuangcao;
    ImageView imageView;
    public ThuVien() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thuvien, container, false);
        QuangCao();
        HienThiQuangCao();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        HienThiBaiHat();
        TaoAnhNhacDangPhat();
    }

    private void TaoAnhNhacDangPhat(){
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tdd);
        Bitmap circularBitmap = AnhBoTron.getRoundedCornerBitmap(bitmap, 100);

        imageView = (ImageView) view.findViewById(R.id.iv_baihatphat);
        imageView.setImageBitmap(circularBitmap);
    }

    private void QuangCao() {
        listQuangcao = new ArrayList<SlideAnimation>();
        listQuangcao.add(new SlideAnimation(R.drawable.quangcao));
        listQuangcao.add(new SlideAnimation(R.drawable.quangcao));
    }

    private void HienThiQuangCao() {
        vpQuangcao = (ViewPager) view.findViewById(R.id.vp_quangcao);
        SlideAdapter adapter = new SlideAdapter(view.getContext(), listQuangcao);
        vpQuangcao.setAdapter(adapter);
    }

    private void HienThiBaiHat() {
        view.findViewById(R.id.ll_baihat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent baihat = new Intent(view.getContext(), DangKi.class);
                startActivity(baihat);
            }
        });
    }
}
