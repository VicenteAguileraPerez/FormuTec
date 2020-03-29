package com.vicenteaguilera.formutec.layouts_principales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.vicenteaguilera.formutec.R;
import com.vicenteaguilera.formutec.layouts_secundarias.AcercaActivity;

public class PrincipalActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_principal);
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
                intent = new Intent(PrincipalActivity.this, AcercaActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
