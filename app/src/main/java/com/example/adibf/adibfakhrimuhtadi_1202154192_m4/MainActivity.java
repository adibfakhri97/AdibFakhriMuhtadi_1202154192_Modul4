package com.example.adibf.adibfakhrimuhtadi_1202154192_m4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ListNama(View view) {
        Intent list = new Intent(this, ListView.class);
        startActivity(list);
    }

    public void CariGambar(View view) {
        Intent gambar = new Intent(this, CariGambar.class);
        startActivity(gambar);
    }
}
