package com.example.pruebaenclaselistas;

import java.io.Serializable;

public class Tarea implements Serializable {

    private static int contador = 1;
    private int id;
    private String nombre;



    private String fecha;
    private String hora;
    private String descripcion;
    private String categoria;
    private int imagen;

    public Tarea(String nombre, int imagen, String categoria, String comentario, String hora, String fecha) {
        this.id = contador++;
        this.nombre = nombre;
        this.imagen = imagen;
        this.categoria = categoria;
        this.descripcion = comentario;
        this.hora = hora;
        this.fecha = fecha;
    }

    public Tarea() {
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
