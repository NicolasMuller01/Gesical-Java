package Musico;

import java.time.LocalDate;
import java.util.ArrayList;

public class Disco {
    String titulo;
    LocalDate anioEdicion;
    ArrayList<Cancion> listaCanciones = new ArrayList<>();

    public Disco(String titulo, LocalDate anioEdicion, ArrayList<Cancion> listaCanciones) {
        this.titulo = titulo;
        this.anioEdicion = anioEdicion;
        this.listaCanciones = listaCanciones;
    }
    public static Cancion nuevaCancion(Cancion cancion){
        return cancion;
    }

    public static Cancion eliminarCancion(Cancion cancion){
        return cancion;
    }

    public ArrayList<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(LocalDate anioEdicion) {
        this.anioEdicion = anioEdicion;
    }

    @Override
    public String toString() {
        return "Disco /n" + "Titulo: " + titulo + ",\n" + "Año de edicion: " + anioEdicion;
    }
    
    
}
