package com.example.pruebaenclaselistas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivityEditarTarea extends AppCompatActivity {

    TextView txtNombreTarea, txtFechaTarea,txtHoraTarea, txtDescripcionTarea;
    RadioGroup rg1, rg2;
    RadioButton rbOcio,rbAmigos, rbTrabajo, rbDeporte, rbFamilia , rbEstudios;
    Button btnVolver, btnActualizar;
    Tarea tarea;

    int posicion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_editar_tarea);

        inicializarComponentes();

    }

    private void cargarTareasAEditar() {
        Intent i = getIntent();
        posicion = i.getIntExtra("posicion",0);

        tarea = GestionTarea.getListaTareas().get(posicion);


        if(tarea!= null) {

            txtNombreTarea.setText(tarea.getNombre());
            txtFechaTarea.setText(tarea.getFecha());
            txtHoraTarea.setText(tarea.getHora());
            txtDescripcionTarea.setText(tarea.getDescripcion());

            if (tarea.getCategoria() != null) {
                switch (tarea.getCategoria()) {
                    case "Ocio":
                        rbOcio.setChecked(true);
                        break;
                    case "Deporte":
                        rbDeporte.setChecked(true);
                        break;
                    case "Trabajo":
                        rbTrabajo.setChecked(true);
                        break;
                    case "Estudios":
                        rbEstudios.setChecked(true);
                        break;
                    case "Familia":
                        rbFamilia.setChecked(true);
                        break;
                    case "Amigos":
                        rbAmigos.setChecked(true);
                        break;
                }
            }

        }
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
        btnActualizar = findViewById(R.id.btnActualizar);
        btnVolver = findViewById(R.id.btnVolver);

        rg1.setOnCheckedChangeListener((group, checkedId) -> deselecionarElementosrb(1));
        rg2.setOnCheckedChangeListener((group, checkedId) -> deselecionarElementosrb(2));
        cargarTareasAEditar();


        btnActualizar.setOnClickListener(v -> {
            actualizar();

        });
        btnVolver.setOnClickListener(v -> finish());

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

    private void actualizar() {
        tarea.setNombre(txtNombreTarea.getText().toString());
        tarea.setFecha(txtFechaTarea.getText().toString());
        tarea.setHora(txtHoraTarea.getText().toString());
        tarea.setDescripcion(txtDescripcionTarea.getText().toString());
        tarea.setCategoria(selecionarCategoria());
        tarea.setImagen(seleccionarImagen());
        GestionTarea.actualizarTareas(posicion,tarea);
        finish();

    }

    private int seleccionarImagen() {
        int img = 0;
        if(rbAmigos.isChecked()){
            img=R.drawable.icon_amigos;
        } else if (rbDeporte.isChecked()) {
            img=R.drawable.icon_deportes;
        } else if (rbOcio.isChecked()) {
            img=R.drawable.icon_ocio;
        } else if (rbFamilia.isChecked()) {
            img=R.drawable.icon_family;
        } else if (rbTrabajo.isChecked()) {
            img=R.drawable.icon_trabajo;
        } else if (rbEstudios.isChecked()) {
            img=R.drawable.icon_estudios;
        }
        return img;
    }

    private String selecionarCategoria() {
        String categoria ="";
        if(rbAmigos.isChecked()){
            categoria="Amigos";
        } else if (rbDeporte.isChecked()) {
            categoria="Deporte";
        } else if (rbOcio.isChecked()) {
            categoria="Ocio";
        } else if (rbFamilia.isChecked()) {
            categoria="Familia";
        } else if (rbTrabajo.isChecked()) {
            categoria="Trabajo";
        } else if (rbEstudios.isChecked()) {
            categoria="Estudios";
        }
        return categoria;
    }
}