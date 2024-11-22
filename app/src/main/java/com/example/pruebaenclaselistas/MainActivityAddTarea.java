package com.example.pruebaenclaselistas;


import android.os.Bundle;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivityAddTarea extends AppCompatActivity {

    TextView txtNombreTarea, txtFechaTarea,txtHoraTarea, txtDescripcionTarea;
    RadioGroup rg1, rg2;
    RadioButton rbOcio,rbAmigos, rbTrabajo, rbDeporte, rbFamilia , rbEstudios;
    Button btnVolver, btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_add_tarea);

        inicializarComponentes();
        btnVolver.setOnClickListener(v -> finish());
        btnGuardar.setOnClickListener(v -> guardarTarea());
    }
    private void inicializarComponentes() {
        txtNombreTarea = findViewById(R.id.txtNombreTarea);
        txtFechaTarea = findViewById(R.id.txtFechaTar);
        txtHoraTarea = findViewById(R.id.txtHoratar);
        txtDescripcionTarea = findViewById(R.id.txtDescripcionTarea);
        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        rbAmigos = findViewById(R.id.rbAmigos);
        rbOcio = findViewById(R.id.rbOcio);
        rbTrabajo = findViewById(R.id.rbTrabajo);
        rbDeporte = findViewById(R.id.rbDeporte);
        rbFamilia = findViewById(R.id.rbFamilia);
        rbEstudios = findViewById(R.id.rbEstudios);
        btnGuardar = findViewById(R.id.btnActualizar);
        btnVolver = findViewById(R.id.btnVolver);

        rg1.setOnCheckedChangeListener((group, checkedId) -> deselecionarElementosrb(1));
        rg2.setOnCheckedChangeListener((group, checkedId) -> deselecionarElementosrb(2));


    }

    private void deselecionarElementosrb(int n) {
        if(n==1){
            rbEstudios.setChecked(false);
            rbFamilia.setChecked(false);
            rbAmigos.setChecked(false);

        }else{
            rbDeporte.setChecked(false);
            rbTrabajo.setChecked(false);
            rbOcio.setChecked(false);
        }
    }

    private void guardarTarea() {
        String nombre = txtNombreTarea.getText().toString();
        String fecha = txtFechaTarea.getText().toString();
        String hora = txtHoraTarea.getText().toString();
        String descripcion = txtDescripcionTarea.getText().toString();
        String categoria = obtenerCategoria();
        int imagen = obtenerImagenPorCategoria(categoria);

        Tarea nuevaTarea = new Tarea(nombre,imagen,categoria,descripcion,hora,fecha);
        GestionTarea.aniadirTarea(nuevaTarea);

        finish();
    }

    private String obtenerCategoria() {
        String categoria = "";
        if(rbAmigos.isChecked()){
            categoria = getString(R.string.rbAmigos);
        }else if (rbEstudios.isChecked()) {
            categoria = getString(R.string.rbEstudios);

        }else if(rbFamilia.isChecked()){
            categoria = getString(R.string.rbFamilia);

        } else if (rbDeporte.isChecked()) {
            categoria = getString(R.string.rbDeporte);

        }else if(rbTrabajo.isChecked()){
            categoria = getString(R.string.rbFamilia);

        }else if(rbAmigos.isChecked()){
            categoria = getString(R.string.rbAmigos);

        }
        return categoria;
    }
    private int obtenerImagenPorCategoria(String categoria) {
        switch (categoria) {
            case "Ocio":
                return R.drawable.icon_ocio;
            case "Amigos":
                return R.drawable.icon_amigos;
            case "Trabajo":
                return R.drawable.icon_trabajo;
            case "Deporte":
                return R.drawable.icon_deportes;
            case "Familia":
                return R.drawable.icon_family;
            case "Estudios":
                return R.drawable.icon_estudios;
            default:
                return R.drawable.icon_ocio;
        }
    }
}