package Musico;

public class Cancion {
    String nombreCancion;
    Integer duracion;

    public Cancion(String nombreCancion, Integer duracion) {
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
  
}
