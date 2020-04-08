package com.vicenteaguilera.formutec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import com.vicenteaguilera.formutec.layouts_principales.PrincipalActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ImageView imageView_splash_screen;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        imageView_splash_screen =findViewById(R.id.imageView_splash_screen);
        new Handler().postDelayed(() ->
        {
            try {
                imageView_splash_screen.setImageResource(R.drawable.info);
                Intent intent  = new Intent(MainActivity.this, PrincipalActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
            catch (Exception ignored){

            }
        },2000);
    }
}
