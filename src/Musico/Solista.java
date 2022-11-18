package Musico;

import java.time.LocalDate;

public class Solista extends Musico{
    String apellido;
    String nombre;
    String nacionalidad;
    Boolean puedeTocar;

    public Solista(String genero, LocalDate anioLanzamiento, String discografia, String apellido, String nombre, String nacionalidad, Boolean puedeTocar) {
        super(genero, anioLanzamiento, discografia);
        this.apellido = apellido;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.puedeTocar = puedeTocar;
    }

}
