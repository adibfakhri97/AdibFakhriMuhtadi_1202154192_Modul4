package com.example.adibf.adibfakhrimuhtadi_1202154192_m4;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static android.content.DialogInterface.*;

public class ListView extends AppCompatActivity {

    ArrayAdapter<String> adapter; //variable untuk array adapter

//    private ProgressDialog infoProgres; //variable untuk ProgressDialog

    android.widget.ListView namaList; //variable untuk ListView
    private String[] nama = {"Osas", "qwewqevew", "Dian", "Rian", "Reno", "Gina", "Delkevic", "adib", "Fakhri", "Dilla", "hallo", "hai"};  //isi Array



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        namaList = (android.widget.ListView) findViewById(R.id.listlist); //identifikasi ListView
        namaList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>())); //membuat variable namaList dapat memasukkan data Array dengan berbentuk list item


    }


    public void Mulai(View view) {
        new TaskNama().execute(); //untuk mengeksekusi AsyncTask

    }


    class TaskNama extends AsyncTask<Void, String, String>{

        private int hitung= 1; //variable count untuk menghitung progress

        ProgressDialog infoProgres = new ProgressDialog(ListView.this); //membuat ProgressDialog


        @Override
        protected void onPreExecute() { //method yang menampilkan status ketika AsyncTask dijalankan, contohnya progressDialog
            adapter = (ArrayAdapter<String>) namaList.getAdapter(); //untuk mengambil adapter namaList dan memasukkannya ke variable adapter

            infoProgres.setMax(100); //set Nilai maksimal progress
            infoProgres.setProgress(0); //set Nilai Progress
            infoProgres.setTitle("Loading Data"); //set judul progressDialog
            infoProgres.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() { //perintah ketika Button diklik
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); //menghilangkan ProgressDialog
                    TaskNama.super.cancel(true); //Menghentikan Proses Asynctask
                }
            });

            infoProgres.show(); //menampilkan ProgressDialog


        }


        @Override
        protected String doInBackground(Void... params) {
            for (String Nama : nama){
                publishProgress(Nama); //memasukkan data array dengan tempo 1 detik
                try {
                    Thread.sleep(1000);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Data berhasil diload"; //Toast jika semua data sudah dimasukkan
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]); //menambahkan data array satu persatu

            Integer percent = (int) ((hitung/(float)nama.length)*100); //rumus untuk menghitung percentase progress berdasarkan banyaknya array

            infoProgres.setProgress(percent); //set progress berdasarkan hitungan
            infoProgres.setMessage(String.valueOf(percent+"%")); //memasukkan info percentase
            hitung++;

        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show(); //menampilkan Toast

           infoProgres.hide(); //menghilangkan ProgressDialog

        }

    }
}
