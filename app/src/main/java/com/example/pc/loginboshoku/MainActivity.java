package com.example.pc.loginboshoku;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    EditText et_ad,et_sifre;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_ad= (EditText) findViewById(R.id.et_ad);
        et_sifre= (EditText) findViewById(R.id.et_sifre);

        Veritabani db=new Veritabani(getApplicationContext());

        /*
        //Veritabanından verileri listeye çekiyoruz.
        List<Bilgiler> kullanicilar=new ArrayList<Bilgiler>();

        kullanicilar=db.VeriCek();

        //Stringin gelişmiş hali.str=str+eklenecek kayit döngülerde değişkene eklemek için kullanılıyordu.
        //StringBuilder daha performanslı için bunu kullandık.kullaniclar içerisindeki veriyi bu stringe aktardık.

        StringBuilder stringBuilder=new StringBuilder();

        for(Bilgiler bilgiler)

        */


    }


    public void butonaDokunuldu(View v)
    {




        String kullaniciadi = et_ad.getText().toString();
        String sifresi = et_sifre.getText().toString();


        switch (v.getId())
        {
            case R.id.btn_gir:

   if(sifresi.isEmpty()||kullaniciadi.isEmpty())
            {
                Toast.makeText(MainActivity.this, "Alanlar boş geçilemez!!!", Toast.LENGTH_SHORT).show();
            }

                Veritabani db=new Veritabani(this);
//Sadece kullanıcı adını alıyor ve bu kullanıcının şifresini kontrol ediyor.Sonuca göre mesaj verdiriyor.
                //Kullanıcı adı ve şifrenin ikisi de kontrol edilmesine gerek var mı ????
                String kontrol=db.KaydiKontrolEt(kullaniciadi);
//Toast.makeText(MainActivity.this, ko, Toast.LENGTH_SHORT).show();
                if(sifresi.equals(kontrol))
                {
                    Toast.makeText(MainActivity.this, "Giriş yapıldı...", Toast.LENGTH_SHORT).show();
                    Intent girisekrani=new Intent(getApplicationContext(),Hosgeldiniz.class);
                    startActivity(girisekrani);
                }
                

                else
                {
                    Toast.makeText(MainActivity.this, "Hatalı kullanıcı adı veya şifre!!!", Toast.LENGTH_SHORT).show();
                }



            break;


            case R.id.btn_kayit:

                Intent intent=new Intent(getApplicationContext(),KayitOl.class);
                startActivity(intent);


            case R.id.btn_temizle:

                et_ad.getText().clear();
                et_sifre.getText().clear();

                break;


        }




    }



}
