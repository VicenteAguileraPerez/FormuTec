package com.vicenteaguilera_tecnm_uruapan.formutec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vicenteaguilera_tecnm_uruapan.formutec.layouts.layouts_principales.PrincipalActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ImageView imageView_splash_screen,imageView_splash_screen_2,imageView_splash_screen_3;
    ConstraintLayout constraintLayout;
    TextView textView_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();
        imageView_splash_screen =findViewById(R.id.imageView_splash_screen);
        imageView_splash_screen_2 =findViewById(R.id.imageView_splash_screen2);
        imageView_splash_screen_3 =findViewById(R.id.imageView_splash_screen3);
        textView_datos = findViewById(R.id.textView_datos);

        setInfo();
        constraintLayout = findViewById(R.id.activity);
        new Handler().postDelayed(() ->
        {
            try {
                imageView_splash_screen.setImageResource(R.drawable.formutec);
                textView_datos.setVisibility(View.INVISIBLE);
                imageView_splash_screen_2.setVisibility(View.INVISIBLE);
                imageView_splash_screen_3.setVisibility(View.INVISIBLE);
                constraintLayout.setBackground(getDrawable(R.drawable.bg_formutec));
                Intent intent  = new Intent(MainActivity.this, PrincipalActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
            catch (Exception ignored){

            }
        },3500);
    }
    public void setInfo()
    {
        String titulo ="FormuTec";
        String texto =" es una app desarrollada por alumnos y docentes de la carrera de Ingeniería en Sistemas Computacionales y el departamento " +
                "Ciencias Básicas del Instituto Tecnológico Superior de Uruapan.";
        textView_datos.setText(titulo +texto, TextView.BufferType.SPANNABLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            textView_datos.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        }
        Spannable s = (Spannable)textView_datos.getText();
        int start = titulo.length();
        int end = start + texto.length();
        s.setSpan(new ForegroundColorSpan(0xFF16318A), 0, start, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
}
