package com.vicenteaguilera.formutec.layouts_principales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.vicenteaguilera.formutec.Adapters.AdapterListView;
import com.vicenteaguilera.formutec.Auxiliar.StaticsImageSubareas;
import com.vicenteaguilera.formutec.R;

import java.util.Objects;

public class FormulaActivity extends AppCompatActivity {

    ListView listView_items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula);
        Intent intent = getIntent();
        setTitle(Objects.requireNonNull(Objects.requireNonNull(intent.getExtras()).get("titulo")).toString());
       listView_items = findViewById(R.id.listView_imagenes);



        int area= (int) intent.getExtras().get("area");
        int subarea= (int) intent.getExtras().get("subarea");
        area(area,subarea);


    }

    private void area(int area,int position)
    {
        switch (area)
        {
            case 0:
                listView_items.setAdapter(new AdapterListView(StaticsImageSubareas.AL.get(position),this));
                break;
            case 1:
                listView_items.setAdapter(new AdapterListView(StaticsImageSubareas.ALLIN.get(position),this));
                break;
            case 2:
                listView_items.setAdapter(new AdapterListView(StaticsImageSubareas.GEO.get(position),this));
                break;
            case 3:
                listView_items.setAdapter(new AdapterListView(StaticsImageSubareas.GEOANALITIC.get(position),this));
                break;
            case 4:
               // imageView_1.setImageResource(StaticsImageSubareas.TRI.get(position));
                break;
            case 5:
                //imageView_1.setImageResource(StaticsImageSubareas.CD.get(position));
                break;
            case 6:
               // imageView_1.setImageResource(StaticsImageSubareas.CI.get(position));
                break;
            case 7:
                listView_items.setAdapter(new AdapterListView(StaticsImageSubareas.CV.get(position),this));
                break;
            case 8:
              //  imageView_1.setImageResource(StaticsImageSubareas.ED.get(position));
                break;
            case 9:
               // imageView_1.setImageResource(StaticsImageSubareas.PYE.get(position));
                break;
            case 10:
                listView_items.setAdapter(new AdapterListView(StaticsImageSubareas.MF.get(position),this));
                break;
        }
    }


}
