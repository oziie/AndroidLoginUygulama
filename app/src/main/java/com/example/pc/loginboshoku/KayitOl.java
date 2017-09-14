package com.example.pc.loginboshoku;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class KayitOl extends AppCompatActivity
{

    EditText kayit_ad, kayit_email, kayit_sifre;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);

        kayit_ad = (EditText) findViewById(R.id.kayit_ad);
        kayit_email = (EditText) findViewById(R.id.kayit_email);
        kayit_sifre = (EditText) findViewById(R.id.kayit_sifre);

    }



    public void KayitIslem(View v) {
        switch (v.getId())
        {
            case R.id.kayit_tamamla:

                String kullaniciadi = kayit_ad.getText().toString();
                String sifresi = kayit_sifre.getText().toString();
                String emaili = kayit_email.getText().toString();


                try {

                    if (kullaniciadi.isEmpty()||sifresi.isEmpty()||emaili.isEmpty())
                        Toast.makeText(getApplicationContext(), "Alanlar boş geçilemez!!!", Toast.LENGTH_SHORT).show();

                    else
                    {
                        Bilgiler k1 = new Bilgiler(kullaniciadi, sifresi, emaili);

                        Veritabani db = new Veritabani(getApplicationContext());

                        long id = db.KayıtEkle(k1);

                        if (id == -1)
                        {
                            Toast.makeText(KayitOl.this, "HAY AKSİ! Kayıt Hatası Oluştu!!!", Toast.LENGTH_SHORT).show();
                        }

                        else
                        Toast.makeText(getApplicationContext(), "Kayıt işlemi başarılı...", Toast.LENGTH_SHORT).show();

                    }


                } catch (Exception e) {
                    Toast.makeText(KayitOl.this, "Bilinmeyen Hata!\n" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }


                break;


            case R.id.vazgec:

                kayit_ad.getText().clear();
                kayit_sifre.getText().clear();
                kayit_email.getText().clear();

                Intent intentgeri=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intentgeri);



                break;


        }


    }




}

















