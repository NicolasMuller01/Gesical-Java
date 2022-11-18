package Musico;

import java.time.LocalDate;
import java.util.ArrayList;

public class Disco {
    Musico musico;
    LocalDate anioEdicion;
    Banda banda;
    ArrayList<Cancion> listaCanciones = new ArrayList<>();

    public Disco(Musico musico, LocalDate anioEdicion, Banda banda, ArrayList<Cancion> listaCanciones) {
        this.musico = musico;
        this.anioEdicion = anioEdicion;
        this.banda = banda;
        this.listaCanciones = listaCanciones;
    }

    public static Cancion nuevaCancion(Cancion cancion){
        return cancion;
    }

    public static Cancion eliminarCancion(Cancion cancion){
        return cancion;
    }
}
