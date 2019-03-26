package com.example.mythesis.Daftar_Ruang;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.mythesis.Adapter;
import com.example.mythesis.MenuPertama;
import com.example.mythesis.Model;
import com.example.mythesis.R;
import com.example.mythesis.ibadah.Gereja;
import com.example.mythesis.ibadah.Masjid;
import com.example.mythesis.ibadah.Vihara;

import java.util.ArrayList;
import java.util.List;

public class RuangIbadah extends MenuPertama {
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allbutton);

        models = new ArrayList<>();
        //gambar, title, desc
        models.add(new Model(R.drawable.masjid, "Masjid", "(Rumah tempat ibadah umat Islam atau Muslim. Masjid artinya tempat sujud, dan sebutan lain bagi masjid di Indonesia adalah musholla, langgar atau surau."));
        models.add(new Model(R.drawable.gereja, "Gereja", "(Bahasa Inggris: Church; bahasa Portugis: Igreja) adalah suatu kata bahasa Indonesia yang berarti suatu perkumpulan atau lembaga dari penganut iman Kristiani."));
        models.add(new Model(R.drawable.vihara, "Wihara", "Rumah ibadah agama Buddha, bisa juga dinamakan kuil. Klenteng adalah rumah ibadah penganut taoisme, maupun konfuciusisme."));

        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
//                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if (i < (adapter.getCount()-1) && i < (colors.length - 1)) {
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    v,
                                    colors[i],
                                    colors[i + 1]
                            )
                    );
                }else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
                if (i == 0) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Masjid.class);
                            startActivity(intent);
                        }
                    });
                }
                else if (i == 1) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Gereja.class);
                            startActivity(intent);
                        }
                    });
                }
                else if (i == 2) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Vihara.class);
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }
}
