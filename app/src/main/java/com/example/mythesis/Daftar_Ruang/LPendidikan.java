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
import com.example.mythesis.pendidikan.Kantin;
import com.example.mythesis.pendidikan.Ruang_Kelas;
import com.example.mythesis.pendidikan.Ruang_Kesenian;
import com.example.mythesis.pendidikan.Ruang_Laboratorium;
import com.example.mythesis.pendidikan.Ruang_Perpustakaan;

import java.util.ArrayList;
import java.util.List;

public class LPendidikan extends MenuPertama {
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allbutton);// call segment name xml

        models = new ArrayList<>();
        //gambar, title, desc
        models.add(new Model(R.drawable.classroom1, "Ruang Kelas", "Tempat untuk kegiatan tatap muka dalam proses kegiatan belajar mengajar (KBM)."));
        models.add(new Model(R.drawable.library1, "Ruang Perpustakaan", "Ruangan atau gedung yang digunakan untuk menyimpan buku dan terbitan lainnya yang biasanya disimpan menurut tata susunan tertentu yang digunakan pembaca bukan untuk dijual"));
        models.add(new Model(R.drawable.labclass, "Ruang Laboratorium", "Tempat pembelajaran IPA/sains dan memberikan keterampilan-keterampilan."));
        models.add(new Model(R.drawable.artclass, "Ruang Kesenian", "Tempat untuk siswa mengapresiasikan dan meng-explore bakat yang di miliki."));
        models.add(new Model(R.drawable.canteenclass, "Kantin", "Digunakan pengunjungnya untuk makan, baik makanan yang dibawa sendiri maupun yang dibeli di sana"));

        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color1)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if (i < (adapter.getCount() - 1) && i < (colors.length - 1)) {
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    v,
                                    colors[i],
                                    colors[i + 1]
                            )
                    );
                } else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
                if (i == 0) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Ruang_Kelas.class);
                            startActivity(intent);
                        }
                    });
                } else if (i == 1) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Ruang_Perpustakaan.class);
                            startActivity(intent);
                        }
                    });
                } else if (i == 2) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Ruang_Laboratorium.class);
                            startActivity(intent);
                        }
                    });
                } else if (i == 3) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Ruang_Kesenian.class);
                            startActivity(intent);
                        }
                    });
                } else if (i == 4) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Kantin.class);
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