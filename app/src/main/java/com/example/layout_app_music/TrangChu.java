package com.example.layout_app_music;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import com.example.layout_app_music.fragment.BangXepHang;
import com.example.layout_app_music.adapter.ChucNangAdapter;
import com.example.layout_app_music.fragment.GhiAm;
import com.example.layout_app_music.fragment.Online;
import com.example.layout_app_music.fragment.ThuVien;
import com.example.layout_app_music.custom_view.AnhBoTron;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.widget.Toolbar;


public class TrangChu extends AppCompatActivity  {
    ImageView imageView;
    private ViewPager vp_chucnang;
    private TabLayout tabLayout;
    private DrawerLayout mDrawerLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);

        vp_chucnang = (ViewPager) findViewById(R.id.vp_hienthichucnang);
        tabLayout = (TabLayout) findViewById(R.id.tab_chuanang);
        addTabs(vp_chucnang);
        tabLayout.setupWithViewPager(vp_chucnang);
        TaoBieuTuongChoTab();
//        TaoAnhNhacDangPhat();
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void init(){
        Toolbar toolbar = findViewById(R.id.tb_action);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.setting_icon);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.nav_login:
                    {
                        Intent dangnhap = new Intent(TrangChu.this, DangNhap.class);
                        startActivity(dangnhap);
                        break;
                    }
                    case R.id.nav_about:
                        about();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return true;
    }

    @SuppressLint("WrongConstant")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(Gravity.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    private void TaoAnhNhacDangPhat(){
//        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tdd);
//        Bitmap circularBitmap = AnhBoTron.getRoundedCornerBitmap(bitmap, 100);
//
//        imageView = (ImageView) findViewById(R.id.iv_baihatphat);
//        imageView.setImageBitmap(circularBitmap);
//    }

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

    private void about() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.about))
                .setMessage(getString(R.string.about_text))
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
