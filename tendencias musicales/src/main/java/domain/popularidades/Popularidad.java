package domain.popularidades;

import domain.canciones.Cancion;
import domain.iconos.Icono;

public abstract class Popularidad {

    public void darDislike(Cancion cancion) {};
    public void darLike(Cancion cancion) {};
    public abstract String obtenerLeyenda(Cancion cancion);
    public abstract String obtenerIcono();
    public abstract void reproducir(Cancion cancion);

    public abstract void chequearCambioPopularidad(Cancion cancion);
    public String detalleCompleto(Cancion cancion) {
        return String.format("%s - %s", cancion.obtenerIcono(), cancion.obtenerLeyenda());
    }
}
