package com.example.layout_app_music.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.layout_app_music.R;
import com.example.layout_app_music.adapter.BaiHatAdapter;
import com.example.layout_app_music.model.SongsList;

import java.util.ArrayList;

public class BaiHatOffline extends Fragment {
    ListView lv;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        return inflater.inflate(R.layout.fragment_danh_sach_bai_hat, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        SongsList song0 = new SongsList("Anh thấy mình nhớ em", "Tống Gia Vĩ", "C:\\Users");
        SongsList song1 = new SongsList("Lại nhớ người yêu", "Quang Lập", "C:\\Users");
        ArrayList<SongsList> lv_song = new ArrayList<>();
        lv_song.add(song0);
        lv_song.add(song1);
        BaiHatAdapter adapter = new BaiHatAdapter(getContext(), lv_song);
        lv = view.findViewById(R.id.lv_danhsachbaihat);
        lv.setAdapter(adapter);
        super.onViewCreated(view, savedInstanceState);
    }
}
