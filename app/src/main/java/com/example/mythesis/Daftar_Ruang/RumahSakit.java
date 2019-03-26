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
import com.example.mythesis.rumahsakit.Ruang_Laboratorium;
import com.example.mythesis.rumahsakit.Ruang_Operasi;
import com.example.mythesis.rumahsakit.Ruang_Rawat_Inap;
import com.example.mythesis.rumahsakit.Ruang_Rehabilitasi;

import java.util.ArrayList;
import java.util.List;

public class RumahSakit extends MenuPertama {
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
        models.add(new Model(R.drawable.rawatinap, "Ruang Rawat Inap", "Perawatan pasien dengan menginap (di rumah sakit)"));
        models.add(new Model(R.drawable.operasi, "Ruang Operasi/Ruang Bersalin", "Suatu unit di rumah sakit yang berfungsi sebagai tempat untuk melakukan tindakan pembedahan secara elektif maupun akut, yang membutuhkan kondisi steril dan kondisi khusus lainnya."));
        models.add(new Model(R.drawable.labrs, "Laboratorium", "Penetapan Diagnosis, pemberian pengobatan dan pemantauan hasil pengobatan."));
        models.add(new Model(R.drawable.rehab, "Ruang Rehabilitasi", "Proses untuk membantu para penderita yang mempunyai penyakit serius atau cacat yang memerlukan pengobatan medis untuk mencapai kemampuan fisik psikologis, dan sosial yang maksimal."));

        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
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

                            Intent intent = new Intent(getApplicationContext(), Ruang_Rawat_Inap.class);
                            startActivity(intent);
                        }
                    });
                }
                else if (i == 1) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Ruang_Operasi.class);
                            startActivity(intent);
                        }
                    });
                }
                else if (i == 2) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Ruang_Laboratorium.class);
                            startActivity(intent);
                        }
                    });
                }
                else if (i == 3) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Ruang_Rehabilitasi.class);
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