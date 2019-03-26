package com.example.mythesis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mythesis.Daftar_Ruang.LPendidikan;
import com.example.mythesis.Daftar_Ruang.Office;
import com.example.mythesis.Daftar_Ruang.RuangIbadah;
import com.example.mythesis.Daftar_Ruang.RumahTinggal;

public class MenuPertama extends Activity {
    CardView rs, home, kantor, ibadah, pendidikan;
    ImageView bgapp, clover;
    LinearLayout texthome, menus, textsplash;
    Animation frombot;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menupertama);

        frombot = AnimationUtils.loadAnimation(this, R.anim.frombot);

        bgapp = (ImageView) findViewById(R.id.bgapp);
        texthome = (LinearLayout) findViewById(R.id.texthome);
        clover = (ImageView) findViewById(R.id.clover);
        textsplash = (LinearLayout) findViewById(R.id.textsplash);
        menus = (LinearLayout) findViewById(R.id.menus);

        bgapp.animate().translationY(-1600).setDuration(800).setStartDelay(300);
        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(600);
        clover.animate().alpha(0).setDuration(800).setStartDelay(600);

        texthome.startAnimation(frombot);
        menus.startAnimation(frombot);

        rs = (CardView) findViewById(R.id.rumahsakit);//variabel tombol view layout dari xml
        rs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), com.example.mythesis.Daftar_Ruang.RumahSakit.class); //Nama Class Yang Di Panggil
                startActivity(i);
            }
        });

        home = (CardView) findViewById(R.id.rumahtinggal);//variabel tombol view layout dari xml
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RumahTinggal.class); //Nama Class Yang Di Panggil
                startActivity(i);
            }
        });

        kantor = (CardView) findViewById(R.id.kantor);//variabel tombol view layout dari xml
        kantor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Office.class); //Nama Class Yang Di Panggil
                startActivity(i);
            }
        });

        pendidikan = (CardView) findViewById(R.id.pendidikan);//variabel tombol view layout dari xml
        pendidikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LPendidikan.class); //Nama Class Yang Di Panggil
                startActivity(i);
            }
        });

        ibadah = (CardView) findViewById(R.id.rumahibadah);//variabel tombol view layout dari xml
        ibadah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RuangIbadah.class); //Nama Class Yang Di Panggil
                startActivity(i);
            }
        });
    }
}
