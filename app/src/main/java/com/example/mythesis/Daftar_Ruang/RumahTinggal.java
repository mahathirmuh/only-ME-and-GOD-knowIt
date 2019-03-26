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
import com.example.mythesis.rumahtinggal.Dapur;
import com.example.mythesis.rumahtinggal.Garasi;
import com.example.mythesis.rumahtinggal.Kamar_Mandi;
import com.example.mythesis.rumahtinggal.Kamar_Tidur;
import com.example.mythesis.rumahtinggal.Ruang_Kerja;
import com.example.mythesis.rumahtinggal.Ruang_Makan;
import com.example.mythesis.rumahtinggal.Ruang_Tamu;
import com.example.mythesis.rumahtinggal.Teras;

import java.util.ArrayList;
import java.util.List;

public class RumahTinggal extends MenuPertama
{
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allbutton);// call segment name xml

        models = new ArrayList<>();
        //gambar, title, desc
        models.add(new Model(R.drawable.kitchen, "Ruang Dapur", "Di mana seseorang melakukan suatu aktivitas mengolah dan menyediakan bahan makanan atau pangan."));
        models.add(new Model(R.drawable.garage, "Ruang Garasi", "Tempat untuk menyimpan kendaraan yang bertujuan untuk melindungi kendaraan dari cuaca terik matahari ataupun oleh air hujan maupun embun di malam hari terhindar dari embun yang mengandung asam sehingga usia kendaraan dapat lebih panjang karena dapat menghambat proses karat yang terjadi pada bodi mobil ataupun bagian-bagian yang terpapar kepada embun dan air."));
        models.add(new Model(R.drawable.bathroom, "Kamar Mandi", "Ruangan di mana seseorang dapat mandi untuk membersihkan tubuhnya"));
        models.add(new Model(R.drawable.bedroom, "Kamar Tidur", "Sebuah ruangan yang khusus dijadikan sebagai tempat tidur dan tempat yang rahasia. Kamar tidur bisa juga sebagai tempat menyimpan barang dan surat berharga yang dirahasiakan oleh pemilik rumah."));
        models.add(new Model(R.drawable.workroom, "Ruang Kerja", "Merupakan tempat atau ruangan yang digunakan untuk bekerja"));
        models.add(new Model(R.drawable.diningroom, "Ruang Makan", "Sebuah wadah yang menampung kegiatan makan, tempat untuk penghuni untuk makan."));
        models.add(new Model(R.drawable.livingroom, "Ruang Tamu", "Tempat untuk menerima tamu sekaligus untuk berkomunikasi dengan orang luar."));
        models.add(new Model(R.drawable.terrace, "Teras", "Bagian rumah yang menyambut tamu-tamu datang, kadangkala kesan yang ditangkap oleh para tamu bisa terbawa hingga ke rumah. "));

        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);

        viewPager.setPadding(130, 0, 130, 0);
        viewPager.setAdapter(adapter);
        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
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

                            Intent intent = new Intent(getApplicationContext(), Dapur.class);
                            startActivity(intent);
                        }
                    });
                }
                else if (i == 1) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Garasi.class);
                            startActivity(intent);
                        }
                    });
                }
                else if (i == 2) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Kamar_Mandi.class);
                            startActivity(intent);
                        }
                    });
                }
                else if (i == 3) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Kamar_Tidur.class);
                            startActivity(intent);
                        }
                    });
                }

                else if (i == 4) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Ruang_Kerja.class);
                            startActivity(intent);
                        }
                    });
                }
                else if (i == 5) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Ruang_Makan.class);
                            startActivity(intent);
                        }
                    });
                }
                else if (i == 6) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Ruang_Tamu.class);
                            startActivity(intent);
                        }
                    });
                }
                else if (i == 7) {
                    CardView btn = (CardView) findViewById(R.id.btnpilih);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Teras.class);
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
