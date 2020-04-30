package com.example.layout_app_music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button dangnhap = (Button) findViewById(R.id.bt_call_dangnhap);
        final Button dangki = (Button) findViewById(R.id.bt_call_dangki);
        final Button trangchu = (Button) findViewById(R.id.bt_call_trangchu);

        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dn = new Intent(MainActivity.this, DangNhap.class);
                startActivity(dn);
            }
        });

        dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dk = new Intent(MainActivity.this, DangKi.class);
                startActivity(dk);
            }
        });

        trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tc = new Intent(MainActivity.this, TrangChu.class);
                startActivity(tc);
            }
        });
    }
}
