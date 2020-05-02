package com.example.layout_app_music.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.layout_app_music.R;

public class GhiAm extends Fragment {
    View view;
    public GhiAm() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_ghi_am, container, false);
        return view;
    }
}
