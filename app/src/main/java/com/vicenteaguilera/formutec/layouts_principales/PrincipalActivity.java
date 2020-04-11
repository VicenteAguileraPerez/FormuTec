package com.vicenteaguilera.formutec.layouts_principales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.vicenteaguilera.formutec.Adapters.AdaptadorArea;
import com.vicenteaguilera.formutec.Auxiliar.FillRecyclerView;
import com.vicenteaguilera.formutec.R;
import com.vicenteaguilera.formutec.layouts_secundarias.AcercaActivity;
import com.vicenteaguilera.formutec.layouts_secundarias.QuejasSugerenciasActivity;

public class PrincipalActivity extends AppCompatActivity {

    Intent intent;
    RecyclerView recyclerView_areas;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    FillRecyclerView fillRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        recyclerView_areas = findViewById(R.id.my_recycler_view);
        initRecyclerView();
    }
    private  void initRecyclerView()
    {
        fillRecyclerView = new FillRecyclerView();
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView_areas.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView_areas.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new AdaptadorArea(fillRecyclerView.getAreaList());
        recyclerView_areas.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.about:
                intent = new Intent(PrincipalActivity.this, AcercaActivity.class);
                startActivity(intent);
                break;
            case R.id.complaints_and_suggestions:
                intent = new Intent(PrincipalActivity.this, QuejasSugerenciasActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
