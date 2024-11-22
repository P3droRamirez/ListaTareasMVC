package com.example.pruebaenclaselistas;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class GestionTarea {

    private static List<Tarea> listaTareas = new ArrayList<>();

    public GestionTarea() {
    }

    public static List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public static void setListaTareas(List<Tarea> listaTareas) {
        GestionTarea.listaTareas = listaTareas;
    }

    public static void actualizarTareas(int pos,Tarea tarea){
        listaTareas.set(pos,tarea);
        GestionTarea.setListaTareas(listaTareas);
        Log.i("Tarea",tarea.toString());
    }

    public static void eliminarTarea(int pos){
        listaTareas.remove(pos);
        GestionTarea.setListaTareas(listaTareas);
    }
    public static void aniadirTarea(Tarea tarea){
        listaTareas.add(tarea);
        GestionTarea.setListaTareas(listaTareas);
    }

    public static void ordenarPorCategoria(List<Tarea> listaTarea){
        listaTarea.sort((tarea1, tarea2) -> tarea1.getCategoria().compareToIgnoreCase(tarea2.getCategoria()));
    }
    public static void ordenarPorFecha(List<Tarea> listaTarea){
        listaTarea.sort((tarea1, tarea2) -> tarea1.getFecha().compareToIgnoreCase(tarea2.getFecha()));
    }
    public static void cargarTareasEnArray(){
        listaTareas= new ArrayList<>();
        Tarea t;

        t = new Tarea("Jugar futbol", R.drawable.icon_deportes, "Deporte", "Vamos a jugar a futbol con los compañeros de clase", "19:00", "12-06-2024");
        listaTareas.add(t);

        t = new Tarea("Ir al cine", R.drawable.icon_amigos, "Amigos", "Vamos al cine con la gente de clase", "13:00", "22-07-2024");
        listaTareas.add(t);

        t = new Tarea("Estudiar programacion", R.drawable.icon_estudios, "Estudios", "Vamos a estudiar un poco para no sacar un 0", "19:00", "12-06-2024");
        listaTareas.add(t);

        t = new Tarea("Comer en un restaurante", R.drawable.icon_family, "Familia", "Vamos a comer toda la familia junta", "14:00", "02-09-2024");
        listaTareas.add(t);

        t = new Tarea("Jugar con el movil", R.drawable.icon_ocio, "Ocio", "Vamos a jugar al móvil hasta perder el sentido del tacto", "19:00", "19-07-2024");
        listaTareas.add(t);

        t = new Tarea("Adelantar trabajo atrasado", R.drawable.icon_trabajo, "Trabajo", "Adelantamos el trabajo para no dejar nada pendiente de hacer", "11:00", "15-02-2024");
        listaTareas.add(t);

    }
}
