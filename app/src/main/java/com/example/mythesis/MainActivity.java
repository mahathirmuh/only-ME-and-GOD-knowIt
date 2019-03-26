package com.example.mythesis;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class
MainActivity extends AppCompatActivity
{
    CardView Mulai,InfoDevice,About;
    ImageView bgapp, clover;
    LinearLayout textsplash, texthome, menus;
    Animation frombot;

    boolean doubleBackToExitPressedOnceee = false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//tampilan xml saat ini

        frombot = AnimationUtils.loadAnimation(this, R.anim.frombot);

        bgapp = (ImageView) findViewById(R.id.bgapp);
        clover = (ImageView) findViewById(R.id.clover);
        textsplash = (LinearLayout) findViewById(R.id.textsplash);
        texthome = (LinearLayout) findViewById(R.id.texthome);
        menus = (LinearLayout) findViewById(R.id.menus);

        bgapp.animate().translationY(-1600).setDuration(800).setStartDelay(300);
        clover.animate().alpha(0).setDuration(800).setStartDelay(600);
        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(600);

        texthome.startAnimation(frombot);
        menus.startAnimation(frombot);


        Mulai = (CardView) findViewById(R.id.mulai);//variabel tombol view layout dari xml
        Mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuPertama.class); //Nama Class Yang Di Panggil
                startActivity(i);
            }
        });

        InfoDevice = (CardView) findViewById(R.id.idevice);//variabel tombol view layout dari xml
        InfoDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),IDevice.class); //Nama Class Yang Di Panggil
                startActivity(i);
            }
        });

        About = (CardView) findViewById(R.id.about);//variabel tombol view layout dari xml
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),About.class); //Nama Class Yang Di Panggil
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        if (doubleBackToExitPressedOnceee)
        {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnceee = true;
        Toast.makeText(this, "Press 'Back' again to exit tayo", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                doubleBackToExitPressedOnceee = false;
            }
        },2000);//interval waktu (mili seconds)
    }
}