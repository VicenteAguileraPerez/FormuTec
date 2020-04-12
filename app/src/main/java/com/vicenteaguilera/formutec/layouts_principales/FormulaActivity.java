package com.vicenteaguilera.formutec.layouts_principales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.vicenteaguilera.formutec.Adapters.AdapterSubareas;
import com.vicenteaguilera.formutec.Auxiliar.StaticsImageSubareas;
import com.vicenteaguilera.formutec.R;

public class FormulaActivity extends AppCompatActivity {

    ListView listView_items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula);
        Intent intent = getIntent();
        setTitle(intent.getExtras().get("titulo").toString());
        listView_items = findViewById(R.id.list_view_items);
        int area= (int) intent.getExtras().get("area");
        int subarea= (int) intent.getExtras().get("subarea");
        listView_items.setAdapter(new AdapterSubareas(this, StaticsImageSubareas.MF_1));

    }


}
