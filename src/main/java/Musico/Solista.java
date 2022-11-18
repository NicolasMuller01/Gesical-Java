package Musico;

import Instrumento.*;
import java.time.LocalDate;

public class Solista extends Musico{
    String apellido;
    String nombre;
    String nacionalidad;
    Boolean puedeTocar;
    Instrumento instrumento;
    String cantante;
    
    public Solista(String genero, LocalDate anioLanzamiento, String discografia, String apellido, String nombre, String nacionalidad, Boolean puedeTocar, Instrumento instrumento) {
        super(genero, anioLanzamiento, discografia);
        this.apellido = apellido;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.puedeTocar = puedeTocar;
        this.instrumento = instrumento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    @Override
    public String getNombre() {
        return nombre + " " +apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Boolean getPuedeTocar() {
        return puedeTocar;
    }

    public void setPuedeTocar(Boolean puedeTocar) {
        this.puedeTocar = puedeTocar;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    @Override
    public String toString() {
        return "Solista: " + "\n" +
                "Apellido: " + apellido + ",\n" +
                "Nombre: " + nombre + "\n"  +
                "Nacionalidad: " + nacionalidad + ",\n" +
                "Puede tocar un instrumento?: " + puedeTocar + ",\n" +
                "Disco: " + disco +",\n" +
                "Genero: " + genero + ",\n" +
                "Año de lanzamiento: " + anioLanzamiento +",\n" +
                "Discografia: " + discografia +"\n";
    }
}
