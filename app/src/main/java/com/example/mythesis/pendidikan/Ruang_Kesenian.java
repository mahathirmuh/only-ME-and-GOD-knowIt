package com.example.mythesis.pendidikan;

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
import com.example.mythesis.rumahtinggal.Dapur;

public class Ruang_Kesenian extends Activity {
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
        title.setText("Ruang Kesenian");
        tempat = (TextView) findViewById(R.id.tempat);
        tempat.setText("Ruang Kesenian");
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
            if ((+event.values[0]) < 5)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(Ruang_Kesenian.this);
                builder.setTitle("Perhatian");
                builder.setMessage(" letakkan ponsel di tempat yang cukup cahaya !");
                builder.setCancelable(true);
                final AlertDialog dlg = builder.create();
                dlg.show();
                Handler mHandler = new Ruang_Kesenian.handler();
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
            else if ((+event.values[0]) >= 5 && (+event.values[0]) <= 50)
            {
                area.setText(" RUANG KESENIAN ");
                status.setText("SANGAT BURUK ");
                rekomendasi.setText("Pencahayaan sangat buruk, anda harus mengganti lampu antara 15 watt sampai 30 watt ");
                aktivitas.setText("Aktivitas Belum Sesuai Standar Pencahayaan");
            }
            else if ((+event.values[0]) > 50 && (+event.values[0]) <= 100)
            {
                area.setText("RUANG KESENIAN ");
                status.setText("BURUK ");
                rekomendasi.setText("Pencahayaan masih buruk, anda harus mengganti lampu antara 15 watt sampai 30 watt ");
                aktivitas.setText("Aktivitas Belum Sesuai Standar Pencahayaan");
            }
            else if ((+event.values[0]) >100 && (+event.values[0]) <= 150)
            {
                area.setText(" RUANG KESENIAN ");
                status.setText(" KURANG ");
                rekomendasi.setText("Pencahayaan masih kurang, ganti dengan lampu antara 15 watt sampai 30 watt ");
                aktivitas.setText("Aktivitas Belum Sesuai Standar Pencahayaan");
            }
            else if ((+event.values[0]) > 150 && (+event.values[0]) <= 200)
            {
                area.setText("RUANG KESENIAN ");
                status.setText("HAMPIR MEMENUHI SYARAT ");
                rekomendasi.setText("Pencahayaan masih kurang, ganti dengan lampu antara 15 watt sampai 30 watt");
                aktivitas.setText("Aktivitas Belum Sesuai Standar Pencahayaan");
            }
            else if ((+event.values[0]) > 200 && (+event.values[0]) <= 250)
            {
                area.setText("RUANG KESENIAN ");
                status.setText("STANDAR ");
                rekomendasi.setText("Pencahayaan pada ruangan ini sudah ideal ");
                aktivitas.setText("- Menari \n- Bernyanyi\n- Menggambar\n- Bermain Alat Musik");
            }
            else
            {
                area.setText("RUANG KESENIAN ");
                status.setText("PENERANGAN BERLEBIHAN ");
                rekomendasi.setText("TERLALU TERANG ganti dengan lampu antara 15 watt sampai 30 watt");
                aktivitas.setText("Aktivitas Belum Sesuai Standar Pencahayaan");
            }
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
