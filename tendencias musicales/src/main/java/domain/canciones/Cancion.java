package domain.canciones;

import domain.popularidades.Normal;
import domain.popularidades.Popularidad;

import java.time.LocalDateTime;

public class Cancion {
    private String titulo;
    private Album album;
    private Artista artista;
    private int likes = 0;
    private int dislikes = 0;
    private int reproducciones = 0;
    private Popularidad popularidad = new Normal();
    private LocalDateTime ultimaReproduccion = LocalDateTime.now();

    public Cancion(String titulo, Album album, Artista artista) {
        this.titulo = titulo;
        this.album = album;
        this.artista = artista;
    }

    public void reproducir() {
        this.popularidad.reproducir(this);
        this.reproducciones++;
        this.ultimaReproduccion = LocalDateTime.now();
    }

    public void darLike() {
        this.likes++;
        this.popularidad.darLike(this);
    }

    public void darDislike() {
        this.dislikes++;
        this.popularidad.darDislike(this);
    }

    public void cambiarPopularidad(Popularidad popularidad) {
        this.popularidad = popularidad;
    }

    public int getLikes() {return this.likes;}

    public String obtenerNombreArtista() {
        return this.artista.getNombre();
    }

    public String obtenerNombreAlbum() {
        return this.album.getNombre();
    }

    public String obtenerTitulo() {
        return this.titulo;
    }

    public int obtenerAnioAlbum() {
        return this.album.getAnio();
    }

    public LocalDateTime getUltimaReproduccion() {
        return this.ultimaReproduccion;
    }

    public boolean reproducidaHaceMasDeHoras(int horas) {
        return this.ultimaReproduccion.isBefore(LocalDateTime.now().minusSeconds(horas));
    }

    public String detalleCompleto() {
        return this.popularidad.detalleCompleto(this);
    }

    public String obtenerIcono() {
        return this.popularidad.obtenerIcono();
    }

    public String obtenerLeyenda() {
        return this.popularidad.obtenerLeyenda(this);
    }

    public boolean superaLikes(int maxLikes) {
        return this.likes >= maxLikes;
    }
}
