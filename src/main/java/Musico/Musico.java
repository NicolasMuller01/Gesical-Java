package Musico;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Musico {
    String genero;
    LocalDate anioLanzamiento;
    String discografia;
    ArrayList<Disco> disco = new ArrayList<>();
    public Musico(String genero, LocalDate anioLanzamiento, String discografia) {
        this.genero = genero;
        this.anioLanzamiento = anioLanzamiento;
        this.discografia = discografia;
    }

    public String getGenero() {
        return genero;
    }
    public abstract String getNombre();

    public ArrayList<Disco> getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco.add(disco);
    }
    
}
