package com.vicenteaguilera.formutec.layouts_principales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.vicenteaguilera.formutec.R;

public class FormulaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula);
        Intent intent = getIntent();
        setTitle(intent.getExtras().get("titulo").toString());
    }
}
