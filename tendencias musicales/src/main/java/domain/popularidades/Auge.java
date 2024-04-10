package domain.popularidades;

import domain.canciones.Cancion;
import domain.iconos.Icono;

public class Auge extends Popularidad{
    private int reproducciones = 0;
    private int dislikes = 0;
    public static int MAX_REPRODUCCIONES = 50000;
    public static int MAX_LIKES = 20000;
    public static int MAX_DISLIKES = 5000;

    public String obtenerIcono() {
        return Icono.ROCKET.texto();
    }

    public String obtenerLeyenda(Cancion cancion) {
        return String.format("%s - %s - (%s - %d)", cancion.obtenerNombreArtista(), cancion.obtenerTitulo(), cancion.obtenerNombreAlbum(), cancion.obtenerAnioAlbum());
    }


    public void darDislike(Cancion cancion) {
        this.dislikes++;
        this.chequearCambioPopularidad(cancion);
    }

    public void darLike(Cancion cancion) {
        this.chequearCambioPopularidad(cancion);
    }

    public void reproducir(Cancion cancion) {
        this.reproducciones++;
        this.chequearCambioPopularidad(cancion);
    }

    public void chequearCambioPopularidad(Cancion cancion) {
        if (this.superaReproduccionesMaximas() && this.superaLikesMaximos(cancion)) {
            cancion.cambiarPopularidad(new Tendencia());
        }
        if (this.superaDislikesMaximos()) {
            cancion.cambiarPopularidad(new Normal());
        }
    }

    private boolean superaDislikesMaximos() {
        return this.dislikes >= MAX_DISLIKES;
    }

    private boolean superaLikesMaximos(Cancion cancion) {
        return cancion.superaLikes(MAX_LIKES);
    }

    private boolean superaReproduccionesMaximas() {
        return this.reproducciones >= MAX_REPRODUCCIONES;
    }
}
