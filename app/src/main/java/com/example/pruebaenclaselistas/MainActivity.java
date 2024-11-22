package com.example.pruebaenclaselistas;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;




public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton btnAdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();


    }

    private void inicializarComponentes() {

        btnAdd = findViewById(R.id.floatingAdd);
        recyclerView = findViewById(R.id.rvTareas);
        setSupportActionBar(findViewById(R.id.menuPrincipal));

        LinearLayoutManager disposicion = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(disposicion);

        GestionTarea.cargarTareasEnArray();
        btnAdd.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), MainActivityAddTarea.class);
            startActivity(i);
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        AdaptadorTareas adaptador = new AdaptadorTareas(GestionTarea.getListaTareas());
        recyclerView.setAdapter(adaptador);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.opcAddTarea){
            Intent i = new Intent(getApplicationContext(), MainActivityAddTarea.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.opcOrdCate) {
            GestionTarea.ordenarPorCategoria(GestionTarea.getListaTareas());
            AdaptadorTareas adaptadorTareas = new AdaptadorTareas(GestionTarea.getListaTareas());
            recyclerView.setAdapter(adaptadorTareas);
        } else if (item.getItemId() == R.id.opcOrdFecha) {
            GestionTarea.ordenarPorFecha(GestionTarea.getListaTareas());
            AdaptadorTareas adaptador = new AdaptadorTareas(GestionTarea.getListaTareas());
            recyclerView.setAdapter(adaptador);

        } else if (item.getItemId() == R.id.opcSalir) {
            crearAlerDialogSalir();
        }
        return false;
    }

    private void crearAlerDialogSalir() {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(R.string.tituloAlert)
                .setMessage(R.string.mnsjAlert)
                .setNegativeButton(R.string.mnsjNegaAlert,null)
                .setPositiveButton(R.string.mnsjPosiAlert, (dialog, which) -> finishAffinity())
                .create()
                .show();
    }
}