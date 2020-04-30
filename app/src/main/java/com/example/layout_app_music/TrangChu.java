package com.example.layout_app_music;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.example.layout_app_music.animation.BangXepHang;
import com.example.layout_app_music.animation.ChucNangAdapter;
import com.example.layout_app_music.animation.GhiAm;
import com.example.layout_app_music.animation.Online;
import com.example.layout_app_music.animation.ThuVien;
import com.example.layout_app_music.custom_view.AnhBoTron;
import com.google.android.material.tabs.TabLayout;


public class TrangChu extends AppCompatActivity {
    private ViewPager vp_chucnang;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);

        vp_chucnang = (ViewPager) findViewById(R.id.vp_hienthichucnang);
        tabLayout = (TabLayout) findViewById(R.id.tab_chuanang);
        addTabs(vp_chucnang);
        tabLayout.setupWithViewPager(vp_chucnang);
        TaoBieuTuongChoTab();
    }

    private void TaoBieuTuongChoTab(){
        TextView ThuVien = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        ThuVien.setText("CÁ NHÂN");
        ThuVien.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_canhan, 0,0);
        tabLayout.getTabAt(0).setCustomView(ThuVien);

        TextView Online = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        Online.setText("ONLINE");
        Online.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_online, 0,0);
        tabLayout.getTabAt(1).setCustomView(Online);

        TextView Bxh = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        Bxh.setText("BXH");
        Bxh.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_bxh, 0,0);
        tabLayout.getTabAt(2).setCustomView(Bxh);

        TextView GhiAm = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        GhiAm.setText("GHI ÂM");
        GhiAm.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_ghiam, 0,0);
        tabLayout.getTabAt(3).setCustomView(GhiAm);
    }

    protected void addTabs(ViewPager viewPager){
        ChucNangAdapter adapter = new ChucNangAdapter(getSupportFragmentManager());
        adapter.add(new ThuVien(), "THU VIEN");
        adapter.add(new Online(), "ONLINE");
        adapter.add(new BangXepHang(), "BXH");
        adapter.add(new GhiAm(), "GHI AM");
        vp_chucnang.setAdapter(adapter);
    }
}
