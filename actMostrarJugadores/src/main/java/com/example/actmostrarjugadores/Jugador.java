package com.example.actmostrarjugadores;


public class Jugador {
    private int id;
    private String nombre;
    private String equipo;
    private int anyo;
    private String posicion;

    public Jugador(int id, String nombre, String equipo, int anyo, String posicion) {
        this.id = id;
        this.nombre = nombre;
        this.equipo = equipo;
        this.anyo = anyo;
        this.posicion = posicion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public int getAnyo() {
        return anyo;
    }

    public String getPosicion() {
        return posicion;
    }
}
