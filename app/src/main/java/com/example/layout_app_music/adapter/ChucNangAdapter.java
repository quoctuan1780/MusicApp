package com.example.layout_app_music.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChucNangAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fracmentList = new ArrayList<>();
    private final List<String> tieudeFrm = new ArrayList<>();
    public ChucNangAdapter(@NonNull FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fracmentList.get(position);
    }

    @Override
    public int getCount() {
        return fracmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tieudeFrm.get(position);
    }

    public void add(Fragment frm, String t){
        fracmentList.add(frm);
        tieudeFrm.add(t);
    }
}
