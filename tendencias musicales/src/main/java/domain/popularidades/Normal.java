package domain.popularidades;

import domain.canciones.Cancion;
import domain.iconos.Icono;

public class Normal extends Popularidad{
    private int reproducciones = 0;
    public static int MAX_REPRODUCCIONES = 1000;
    private final Icono icono = Icono.MUSICAL_NOTE;

    public String obtenerIcono() {
        return this.icono.texto();
    }
    public String obtenerLeyenda(Cancion cancion) {
        return String.format("%s - %s - %s", cancion.obtenerNombreArtista(), cancion.obtenerNombreAlbum(), cancion.obtenerTitulo());
    }

    public void reproducir(Cancion cancion) {
        this.reproducciones++;
        this.chequearCambioPopularidad(cancion);
    }

    public void chequearCambioPopularidad(Cancion cancion) {
        if (this.reproducciones >= MAX_REPRODUCCIONES) {
            cancion.cambiarPopularidad(new Auge());
        }
    }
}
