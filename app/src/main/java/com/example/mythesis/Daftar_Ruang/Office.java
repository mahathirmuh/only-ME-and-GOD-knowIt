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
import com.example.mythesis.office.Gudang_Arsip;
import com.example.mythesis.office.Gudang_Arsip_Aktif;
import com.example.mythesis.office.Ruang_Direktur;
import com.example.mythesis.office.Ruang_Gambar;
import com.example.mythesis.office.Ruang_Komputer;
import com.example.mythesis.office.Ruang_Rapat;
import com.example.mythesis.rumahtinggal.Ruang_Kerja;

import java.util.ArrayList;
import java.util.List;

public class Office extends MenuPertama {
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
            models.add(new Model(R.drawable.direktur1, "Ruang Direktur", "Ruang Pemimpin lembaga perusahaan pemerintah, swasta, atau lembaga pendidikan Politeknik."));
            models.add(new Model(R.drawable.ruangkerja, "Ruang Kerja", "Merupakan tempat atau ruangan yang digunakan untuk bekerja"));
            models.add(new Model(R.drawable.computer, "Ruang Komputer", "Tempat perangkat utama komputer diletakkan.Pada umumnya yang ada diruang komputer adalah monitor,CPU,dan printer."));
            models.add(new Model(R.drawable.meeting, "Ruang Rapat", " Ruang pertemuan untuk membicarakan bisnis dan pekerjaan baik oleh karyawan internal kantor ataupun dengan klien."));
            models.add(new Model(R.drawable.artpicture, "Ruang Gambar", "Kegiatan kegiatan membentuk imaji, dengan menggunakan banyak pilihan teknik dan alat."));
            models.add(new Model(R.drawable.warehouseinactive, "Gudang Arsip", "Catatan rekaman kegiatan atau sumber informasi dengan berbagai macam bentuk yang dibuat oleh lembaga, organisasi maupun perseorangan dalam rangka pelaksanaan kegiatan."));
            models.add(new Model(R.drawable.warehouseactive, "Gudang Arsip Aktif", "Arsip dinamis yang secara langsung dan terus menerus diperlukan dan dipergunakan, dalam penyelenggaraan administrasi."));

            adapter = new Adapter(models, this);

            viewPager = findViewById(R.id.viewPager);
            viewPager.setAdapter(adapter);
            viewPager.setPadding(130, 0, 130, 0);

            Integer[] colors_temp = {
                    getResources().getColor(R.color.color1),
                    getResources().getColor(R.color.color2),
                    getResources().getColor(R.color.color3),
                    getResources().getColor(R.color.color4),
                    getResources().getColor(R.color.color1),
                    getResources().getColor(R.color.color2),
                    getResources().getColor(R.color.color3)
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

                                Intent intent = new Intent(getApplicationContext(), Ruang_Direktur.class);
                                startActivity(intent);
                            }
                        });
                    }
                    else if (i == 1) {
                        CardView btn = (CardView) findViewById(R.id.btnpilih);
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent intent = new Intent(getApplicationContext(), Ruang_Kerja.class);
                                startActivity(intent);
                            }
                        });
                    }
                    else if (i == 2) {
                        CardView btn = (CardView) findViewById(R.id.btnpilih);
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent intent = new Intent(getApplicationContext(), Ruang_Komputer.class);
                                startActivity(intent);
                            }
                        });
                    }
                    else if (i == 3) {
                        CardView btn = (CardView) findViewById(R.id.btnpilih);
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent intent = new Intent(getApplicationContext(), Ruang_Rapat.class);
                                startActivity(intent);
                            }
                        });
                    }

                    else if (i == 4) {
                        CardView btn = (CardView) findViewById(R.id.btnpilih);
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent intent = new Intent(getApplicationContext(), Ruang_Gambar.class);
                                startActivity(intent);
                            }
                        });
                    }
                    else if (i == 5) {
                        CardView btn = (CardView) findViewById(R.id.btnpilih);
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent intent = new Intent(getApplicationContext(), Gudang_Arsip.class);
                                startActivity(intent);
                            }
                        });
                    }
                    else if (i == 6) {
                        CardView btn = (CardView) findViewById(R.id.btnpilih);
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent intent = new Intent(getApplicationContext(), Gudang_Arsip_Aktif.class);
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
