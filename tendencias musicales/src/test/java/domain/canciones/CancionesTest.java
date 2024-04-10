package domain.canciones;

import domain.iconos.Icono;
import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CancionesTest {

    public static Cancion theScientist;

    @BeforeAll
    static void init() {
        theScientist = new Cancion("The Scientist", new Album("A Rush of Blood to the Head", 2002), new Artista("Coldplay"));
    }

    @Test
    @Order(1)
    @DisplayName("The Scientist recién se lanza (tiene popularidad normal).")
    void instante1_recienLanzada() {
        assertEquals(String.format("%s - Coldplay - A Rush of Blood to the Head - The Scientist", Icono.MUSICAL_NOTE.texto()), theScientist.detalleCompleto());
    }

    @Test
    @Order(2)
    @DisplayName("The Scientist está en auge por superar el mínimo de reproducciones esperadas.")
    void instante2_estaEnAuge() {
        for (int i = 0; i < 1000; i++) {
            theScientist.reproducir();
        }
        assertEquals(String.format("%s - Coldplay - The Scientist - (A Rush of Blood to the Head - 2002)", Icono.ROCKET.texto()), theScientist.detalleCompleto());
    }

    @Test
    @Order(3)
    @DisplayName("The Scientist baja del auge por tener muchos dislikes")
    void instante3_bajaDelAuge() {
        for (int i = 0; i < 5000; i++) {
            theScientist.darDislike();
        }
        assertEquals(String.format("%s - Coldplay - A Rush of Blood to the Head - The Scientist", Icono.MUSICAL_NOTE.texto()), theScientist.detalleCompleto());
    }

    @Test
    @Order(4)
    @DisplayName("The Scientist es tendencia por record de reproducciones y cantidad de personas que le gusta el tema.")
    void instante4_esTendencia() {
        for (int i = 0; i < 51000; i++) {
            theScientist.reproducir();
        }
        for (int i = 0; i < 20000; i++) {
            theScientist.darLike();
        }
        assertEquals(String.format("%s - The Scientist - Coldplay - (A Rush of Blood to the Head - 2002)", Icono.FIRE.texto()), theScientist.detalleCompleto());
    }

    @Test
    @Order(5)
    @DisplayName("The Scientist vuelve a ser normal por no ser escuchada en las ultimas horas")
    void instante5_vuelveANormal() throws InterruptedException {
        TimeUnit.SECONDS.sleep(25);
        assertEquals(String.format("%s - Coldplay - A Rush of Blood to the Head - The Scientist", Icono.MUSICAL_NOTE.texto()), theScientist.detalleCompleto());
    }
}
