package com.example.mythesis.pendidikan;

import android.app.Activity;
import android.app.AlertDialog;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mythesis.R;
import com.example.mythesis.rumahtinggal.Dapur;

public class Kantin extends Activity {
    private TextView tempat, title, lux, area, status, rekomendasi, aktivitas;
    ImageView bgapp, clover;
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
        title.setText("Kantin");
        tempat = (TextView) findViewById(R.id.tempat);
        tempat.setText("Kantin");
        lux = (TextView) findViewById(R.id.textView);
        area = (TextView) findViewById(R.id.textView2);
        status = (TextView) findViewById(R.id.textView3);
        rekomendasi = (TextView) findViewById(R.id.textView4);
        aktivitas = (TextView) findViewById(R.id.textView5);

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
            if ((+event.values[0]) <= 5)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(Kantin.this);
                builder.setTitle("Perhatian");
                builder.setMessage(" letakkan ponsel di tempat yang cukup cahaya konoyaro !");
                builder.setCancelable(true);
                final AlertDialog dlg = builder.create();
                dlg.show();
                Handler mHandler = new Kantin.handler();
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
//            else if ((+event.values[0]) > 7 && (+event.values[0]) < 20)
//            {
//                area.setText("ss ");
//                status.setText(" ss");
//                clarification.setText("ss ");
//            }
            else if ((+event.values[0]) > 5 && (+event.values[0]) <= 40)
            {
                area.setText(" KANTIN ");
                status.setText("SANGAT BURUK ");
                rekomendasi.setText(" Pencahayaan sangat buruk, anda harus mengganti lampu antara 7 watt sampai 20 watt ");
            }
            else if ((+event.values[0]) > 40 && (+event.values[0]) <= 80)
            {
                area.setText(" KANTIN ");
                status.setText(" BURUK ");
                rekomendasi.setText(" pencahayaan masih buruk, anda harus mengganti lampu antara 7 watt sampai 20 watt ");
            }
            else if ((+event.values[0]) > 80 && (+event.values[0]) <= 120)
            {
                area.setText(" KANTIN ");
                status.setText(" SEDANG ");
                rekomendasi.setText(" pencahayaan masih kurang, ganti dengan lampu antara 7 watt sampai 20 watt ");
            }
            else if ((+event.values[0]) > 120 && (+event.values[0]) <= 160)
            {
                area.setText(" KANTIN ");
                status.setText(" HAMPIR MEMENUHI SYARAT ");
                rekomendasi.setText(" pencahayaan masih kurang, ganti dengan lampu antara 7 watt sampai 20 watt");
            }
            else if ((+event.values[0]) > 160 && (+event.values[0]) <= 200)
            {
                area.setText(" KANTIN ");
                status.setText(" STANDAR ");
                rekomendasi.setText(" pencahayaan pada ruangan ini sudah ideal ");
            }
            else
            {
                area.setText(" KANTIN ");
                status.setText(" PENERANGAN BERLEBIHAN ");
                rekomendasi.setText(" TERLALU TERANG ganti dengan lampu antara 7 watt sampai 20 watt");
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
