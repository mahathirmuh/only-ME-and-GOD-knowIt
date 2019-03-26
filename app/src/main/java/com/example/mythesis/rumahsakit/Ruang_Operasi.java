package com.example.mythesis.rumahsakit;

import android.app.Activity;
import android.app.AlertDialog;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.mythesis.R;
import com.example.mythesis.rumahtinggal.Dapur;

public class Ruang_Operasi extends Activity {
    private TextView lux;
    private TextView area;
    private TextView status;
    private TextView rekomendasi;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil);
        lux = (TextView) findViewById(R.id.textView);
        area = (TextView) findViewById(R.id.textView2);
        status = (TextView) findViewById(R.id.textView3);
        rekomendasi = (TextView) findViewById(R.id.textView4);
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
            if ((+event.values[0]) < 20)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(Ruang_Operasi.this);
                builder.setTitle("Perhatian");
                builder.setMessage(" letakkan ponsel di tempat yang cukup cahaya konoyaro !");
                builder.setCancelable(true);
                final AlertDialog dlg = builder.create();
                dlg.show();
                Handler mHandler = new Ruang_Operasi.handler();
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
            else if ((+event.values[0]) >= 20 && (+event.values[0]) <= 50)
            {
                area.setText(" RUANG OPERASI ");
                status.setText("SANGAT BURUK ");
                rekomendasi.setText(" Pencahayaan sangat buruk, anda harus mengganti lampu antara 7 watt sampai 20 watt ");
            }
            else if ((+event.values[0]) > 50 && (+event.values[0]) <= 100)
            {
                area.setText(" RUANG OPERASI ");
                status.setText(" BURUK ");
                rekomendasi.setText(" pencahayaan masih buruk, anda harus mengganti lampu antara 7 watt sampai 20 watt ");
            }
            else if ((+event.values[0]) >100 && (+event.values[0]) <= 150)
            {
                area.setText(" RUANG OPERASI ");
                status.setText(" KURANG ");
                rekomendasi.setText(" pencahayaan masih kurang, ganti dengan lampu antara 7 watt sampai 20 watt ");
            }
            else if ((+event.values[0]) > 150 && (+event.values[0]) <= 200)
            {
                area.setText(" RUANG OPERASI ");
                status.setText(" HAMPIR MEMENUHI SYARAT ");
                rekomendasi.setText(" pencahayaan masih kurang, ganti dengan lampu antara 7 watt sampai 20 watt");
            }
            else if ((+event.values[0]) > 200 && (+event.values[0]) <= 250)
            {
                area.setText(" RUANG OPERASI ");
                status.setText(" STANDAR ");
                rekomendasi.setText(" pencahayaan pada ruangan ini sudah ideal ");
            }
            else
            {
                area.setText(" RUANG OPERASI ");
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
