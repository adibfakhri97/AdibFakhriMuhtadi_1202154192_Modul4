package com.example.adibf.adibfakhrimuhtadi_1202154192_m4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;

public class CariGambar extends AppCompatActivity {
    private EditText uRL;  //variable baru untuk masing-masing widget
    private ImageView viewGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_gambar);

        uRL = (EditText) findViewById(R.id.cariEdit); //identifikasi EditText

        viewGambar = (ImageView) findViewById(R.id.cariImage); //identifikasi ImageView

    }


    public void Search(View view) {
        String link = uRL.getText().toString(); //Mengambil isi text dari EditText

        Picasso.with(getApplicationContext()).load(link).into(viewGambar); //memasukkan gambar ke dalam ImageView yang sudah disediakan dengan URL dari variable link
    }


}
