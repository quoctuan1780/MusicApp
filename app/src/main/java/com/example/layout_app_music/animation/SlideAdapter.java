package com.example.layout_app_music.animation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.layout_app_music.R;

import java.util.ArrayList;

public class SlideAdapter extends PagerAdapter {
    private ArrayList<SlideAnimation> listQuangcao;
    private LayoutInflater layoutInflater;
    public SlideAdapter(Context context, ArrayList<SlideAnimation> listquangcao){
        this.listQuangcao = listquangcao;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listQuangcao.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //Chuyển đổi xml thành view
        View view = layoutInflater.inflate(R.layout.item_quangcao, container, false);
        //Ánh xạ view
        ImageView iv = (ImageView) view.findViewById(R.id.iv_quangcao);

        //Đổ dữ liệu vào đối tượng
        SlideAnimation mau = listQuangcao.get(position);
        iv.setImageResource(mau.getHinh());

        //Thêm vào container
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
