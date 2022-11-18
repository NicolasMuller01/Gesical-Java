package Musico;

import java.time.LocalDate;
import java.util.ArrayList;

public class Banda extends Musico {
    String titulo;
    ArrayList<Solista> listaSolista = new ArrayList<>();

    public Banda(String genero, LocalDate anioLanzamiento, String discografia, String titulo, ArrayList<Solista> listaSolista) {
        super(genero, anioLanzamiento, discografia);
        this.titulo = titulo;
        this.listaSolista = listaSolista;
    }
    
    @Override
    public String getNombre() {
        return titulo;
    }
    
}
