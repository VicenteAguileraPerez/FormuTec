package com.vicenteaguilera.formutec.layouts_secundarias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

import com.vicenteaguilera.formutec.R;

public class QuejasSugerenciasActivity extends AppCompatActivity {

    EditText editText_nombre,editText_email,editText_mensaje;
    RadioButton radioButton_asunto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quejas_sugerencias);
        setTitle(R.string.quejas_y_sugerencias);
    }
}
