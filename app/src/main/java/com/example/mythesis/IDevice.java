package com.example.mythesis;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IDevice extends Activity {
    private TextView LsensorR;
    private TextView nSensor;
    private TextView vSensor;
    private TextView verSensor;
    private TextView resSensor;
    private TextView pSensor;
    private TextView maxSens;
    private TextView minDSensor;
    private TextView maxDsensor;
    Boolean AcNon = false;
    ImageView bgapp, clover;
    LinearLayout texthome, textsplash, menus;
    Animation frombot;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device);//tampilan xml saat ini

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

    }
}