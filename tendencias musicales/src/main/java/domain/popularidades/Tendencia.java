package domain.popularidades;

import domain.canciones.Cancion;
import domain.iconos.Icono;

import java.time.LocalDateTime;

public class Tendencia extends Popularidad{
    private Icono icono = Icono.FIRE;
    private static int MAX_HORAS = 24;

    public Tendencia() {
        super();
    }
    public void reproducir(Cancion cancion) {
    }

    public void chequearCambioPopularidad(Cancion cancion) {
        if (cancion.reproducidaHaceMasDeHoras(MAX_HORAS)) {
            cancion.cambiarPopularidad(new Normal());
        }
    }

    public String obtenerIcono() {
        return this.icono.texto();
    }

    public String obtenerLeyenda(Cancion cancion) {
        return String.format("%s - %s - (%s - %d)", cancion.obtenerTitulo(), cancion.obtenerNombreArtista(), cancion.obtenerNombreAlbum(), cancion.obtenerAnioAlbum());
    }

    public String detalleCompleto(Cancion cancion) {
        this.chequearCambioPopularidad(cancion);
        return super.detalleCompleto(cancion);
    }
}
