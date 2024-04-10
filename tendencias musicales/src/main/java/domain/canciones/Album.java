package domain.canciones;

public class Album {
    private String nombre;
    private int anio;

    public Album(String nombre, int anio) {
        this.nombre = nombre;
        this.anio = anio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getAnio() {
        return this.anio;
    }
}
