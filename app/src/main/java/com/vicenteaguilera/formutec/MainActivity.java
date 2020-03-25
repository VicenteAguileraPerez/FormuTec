package com.vicenteaguilera.formutec;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ImageView imageView_splash_screen;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView_splash_screen =findViewById(R.id.imageView_splash_screen);
        new Handler().postDelayed(() ->
        {
            try {
                imageView_splash_screen.setImageResource(R.drawable.info);
            }
            catch (Exception ex){
                ///Toast.makeText(getContext(), "Error al cargar vista principal.", Toast.LENGTH_SHORT).show();
            }
        },2000);
    }
}
