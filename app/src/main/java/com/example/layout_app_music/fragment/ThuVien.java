package com.example.layout_app_music.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.layout_app_music.DanhDachNhacOffline;
import com.example.layout_app_music.R;
import com.example.layout_app_music.adapter.SlideAdapter;
import com.example.layout_app_music.model.Slide;

import java.util.ArrayList;

public class ThuVien extends Fragment {
    private View view;
    private ArrayList<Slide> listQuangcao;
    private ViewPager vpQuangcao;
    private Toolbar toolbar;

    public ThuVien() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thuvien, container, false);
        QuangCao();
        HienThiQuangCao();
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      HienThiBaiHat();
    }

    private void QuangCao() {
        listQuangcao = new ArrayList<Slide>();
        listQuangcao.add(new Slide(R.drawable.quangcao));
        listQuangcao.add(new Slide(R.drawable.quangcao));
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
                final Intent baihat = new Intent(view.getContext(), DanhDachNhacOffline.class);
                startActivity(baihat);
            }
        });
    }
}
