package Musico;

import java.time.LocalDate;

public class Musico {
    String genero;
    LocalDate anioLanzamiento;
    String discografia;

    //Disco disco;


    public Musico(String genero, LocalDate anioLanzamiento, String discografia) {
        this.genero = genero;
        this.anioLanzamiento = anioLanzamiento;
        this.discografia = discografia;
    }
}
