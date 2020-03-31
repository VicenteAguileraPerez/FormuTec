package com.vicenteaguilera.formutec.layouts_secundarias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.vicenteaguilera.formutec.R;

public class AcercaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);
        setTitle(R.string.acerca_de);
    }
}
