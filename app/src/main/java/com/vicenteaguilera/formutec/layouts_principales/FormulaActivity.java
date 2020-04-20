package com.vicenteaguilera.formutec.layouts_principales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.vicenteaguilera.formutec.Auxiliar.StaticsImageSubareas;
import com.vicenteaguilera.formutec.R;

public class FormulaActivity extends AppCompatActivity {

    ImageView imageView_1,imageView_2,imageView_3;
    ListView listView_items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula);
        Intent intent = getIntent();
        setTitle(intent.getExtras().get("titulo").toString());
       // listView_items = findViewById(R.id.list_view_items);
        imageView_1 = findViewById(R.id.imageView);
        //imageView_2 = findViewById(R.id.imageView_2);
        //imageView_3 = findViewById(R.id.imageView_3);


        int area= (int) intent.getExtras().get("area");
        int subarea= (int) intent.getExtras().get("subarea");
        area(area,subarea);


    }

    private void area(int area,int position)
    {
        switch (area)
        {
            case 0:
                imageView_1.setImageResource(StaticsImageSubareas.AL.get(position));
                break;
            case 1:
                imageView_1.setImageResource(StaticsImageSubareas.ALLIN.get(position));
                break;
            case 2:
                imageView_1.setImageResource(StaticsImageSubareas.GEO.get(position));
                break;
            case 3:
                imageView_1.setImageResource(StaticsImageSubareas.GEOANALITIC.get(position));
                break;
            case 4:
                imageView_1.setImageResource(StaticsImageSubareas.TRI.get(position));
                break;
            case 5:
                imageView_1.setImageResource(StaticsImageSubareas.CD.get(position));
                break;
            case 6:
                imageView_1.setImageResource(StaticsImageSubareas.CI.get(position));
                break;
            case 7:
                imageView_1.setImageResource(StaticsImageSubareas.CV.get(position));
                break;
            case 8:
                imageView_1.setImageResource(StaticsImageSubareas.ED.get(position));
                break;
            case 9:
                imageView_1.setImageResource(StaticsImageSubareas.PYE.get(position));
                break;
            case 10:
                imageView_1.setImageResource(StaticsImageSubareas.MF.get(position));
                break;
        }
    }


}
