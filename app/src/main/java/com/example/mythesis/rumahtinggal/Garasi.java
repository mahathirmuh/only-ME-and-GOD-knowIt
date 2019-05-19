package com.example.mythesis.rumahtinggal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mythesis.R;
import com.example.mythesis.ViewPDF;

public class Garasi extends Activity
{
    private TextView tempat, title, lux, area, status, rekomendasi, aktivitas;
    ImageView bgapp, clover, Klik;
    LinearLayout textsplash, texthome, menus;
    Animation frombot;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil);

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

        title = (TextView) findViewById(R.id.titleee);
        title.setText("Garasi");
        tempat = (TextView) findViewById(R.id.tempat);
        tempat.setText("Garasi");
        lux = (TextView) findViewById(R.id.textView);
        area = (TextView) findViewById(R.id.textView2);
        status = (TextView) findViewById(R.id.textView3);
        rekomendasi = (TextView) findViewById(R.id.textView4);
        aktivitas = (TextView) findViewById(R.id.textView5);

        Klik = (ImageView) findViewById(R.id.viewpdf);
        Klik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ViewPDF.class);
                startActivity(i);
            }
        });

        SensorManager mySensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor LightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (LightSensor != null)
        {
            mySensorManager.registerListener(LightSensorListener,LightSensor,SensorManager.SENSOR_STATUS_ACCURACY_HIGH);
        }
    }
    private android.os.Handler result;
    private final SensorEventListener LightSensorListener = new SensorEventListener()
    {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy)
        {
            // TODO Auto-generated method stub
        }

        @Override
        public void onSensorChanged(SensorEvent event)
        {
            if (event.sensor.getType() == Sensor.TYPE_LIGHT)
            {
                lux.setText("" + event.values[0]);
            }
            if ((+event.values[0]) < 3)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(Garasi.this);
                builder.setTitle("Perhatian");
                builder.setMessage(" letakkan ponsel di tempat yang cukup cahaya konoyaro !");
                builder.setCancelable(true);
                final AlertDialog dlg = builder.create();
                dlg.show();
                Handler mHandler = new Garasi.handler();
                Runnable mRunnable = new Runnable()
                {
                    public void run()
                    {
                        if (dlg != null && dlg.isShowing())
                            dlg.dismiss();
                    }
                };
                lux.postDelayed(mRunnable, 1000);
            }
            else if ((+event.values[0]) > 7 && (+event.values[0]) < 20)
            {
                area.setText("UNKNOWN ");
                status.setText(" TERLALU RENDAH");
                rekomendasi.setText(" - ");
            }
            else if ((+event.values[0]) > 20 && (+event.values[0]) < 50)
            {
                area.setText(" GARASI ");
                status.setText(" sangat buruk ");
                rekomendasi.setText(" pencahayaan sangat buruk, anda harus mengganti lampu antara 7 watt sampai 20 watt ");
            }
            else if ((+event.values[0]) > 60 && (+event.values[0]) < 99)
            {
                area.setText(" GARASI ");
                status.setText(" buruk ");
                rekomendasi.setText(" pencahayaan masih buruk, anda harus mengganti lampu antara 7 watt sampai 20 watt ");
            }
            else if ((+event.values[0]) > 100 && (+event.values[0]) < 118)
            {
                area.setText(" GARASI ");
                status.setText(" masih buruk ");
                rekomendasi.setText(" pencahayaan masih buruk, ganti dengan lampu antara 7 watt sampai 20 watt ");
            }
            else if ((+event.values[0]) > 119 && (+event.values[0]) < 185)
            {
                area.setText(" GARASI ");
                status.setText(" range rendah ");
                rekomendasi.setText(" pencahayaan pada ruangan ini sudah ideal");
            }
            else if ((+event.values[0]) > 186 && (+event.values[0]) < 199)
            {
                area.setText(" GARASI ");
                status.setText("standar ");
                rekomendasi.setText(" pencahayaan pada ruangan ini sudah ideal ");
                aktivitas.setText("- Perbaikan Kendaraan");
            }
            else if ((+event.values[0]) > 200 && (+event.values[0]) < 251)
            {
                area.setText(" GARASI ");
                status.setText(" range maksimal ");
                rekomendasi.setText(" pencahayaan pada ruangan ini sudah ideal");
            }
            else if ((+event.values[0]) > 252 && (+event.values[0]) < 300)
            {
                area.setText(" GARASI ");
                status.setText(" berlebihan ");
                rekomendasi.setText(" cahaya telalu terang , ganti lampu anda dengan lampu 7 watt sampai 20 watt ");
            }
            else System.out.println();
        }
    };

    private class handler extends Handler
    {
//        @Override
//        public void close()
//        {
//
//        }
//        @Override
//        public void flush()
//        {
//
//        }
//        @Override
//        public void publish(LogRecord record)
//        {
//
//        }
    }
}
