package com.example.mythesis;

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
import android.widget.ListView;
import android.widget.TextView;

import com.example.mythesis.ibadah.Gereja;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class IDevice extends Activity {
    private TextView luxid, name, luxvendor, luxversion, resolution, powerr, maxrange, mindelay;
    private SensorManager mySensorManager;
    private Sensor LightSensor;
    ImageView bgapp, clover;
    LinearLayout texthome, textsplash, menus;
    Animation frombot;
    @Override
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

        luxid = (TextView) findViewById(R.id.luxid);
        name = (TextView) findViewById(R.id.namesensor);
        luxvendor = (TextView) findViewById(R.id.vendor);
        luxversion = (TextView) findViewById(R.id.lversion);
        maxrange = (TextView) findViewById(R.id.maxrange);
        mindelay = (TextView) findViewById(R.id.mindelay);
        resolution = (TextView) findViewById(R.id.resolution);
        powerr = (TextView) findViewById(R.id.power);


        mySensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        LightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (LightSensor != null) {
            mySensorManager.registerListener(LightSensorListener, LightSensor, SensorManager.SENSOR_STATUS_ACCURACY_HIGH);
        }
    }
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
                luxid.setText(""+event.values[0]);
                name.setText(String.valueOf(LightSensor.getName()));
                luxvendor.setText(LightSensor.getVendor());
                luxversion.setText(String.valueOf(LightSensor.getVersion()));
                maxrange.setText(String.valueOf(LightSensor.getMaximumRange()));
                mindelay.setText(String.valueOf(LightSensor.getMinDelay()));
                resolution.setText(String.valueOf(LightSensor.getResolution()));
                powerr.setText(String.valueOf(LightSensor.getPower()));
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