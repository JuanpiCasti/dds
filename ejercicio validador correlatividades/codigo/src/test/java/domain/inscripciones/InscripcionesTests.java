package domain.inscripciones;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class InscripcionesTest {
    private static final Materia algoritmos = new Materia();
    private static final Materia syo = new Materia();
    private static final Materia discreta = new Materia();
    private static final Materia pdep = new Materia();

    private static final Materia ads = new Materia();
    private static final Materia dds = new Materia();

    @BeforeAll
    static void init() {
        pdep.establecerCorrelativas(algoritmos, discreta);
        ads.establecerCorrelativas(syo,algoritmos,discreta);
        dds.establecerCorrelativas(pdep,ads);
    }
    @Test
    @DisplayName("Un alumno puede cursar una materia solo si tiene aprobadas todas sus correlativas.")
    void materiaPuedeCursar() {
        final Alumno alumno1 = new Alumno();
        alumno1.aprobarMateria(InscripcionesTest.algoritmos);
        alumno1.aprobarMateria(InscripcionesTest.discreta);
        assertTrue(pdep.puedeCursar(alumno1));
        assertFalse(ads.puedeCursar(alumno1)); // ads requiere que syo tambien este aprobada
    }

    @Test
    @DisplayName("Una inscripción solo estará aprobada si el alumno puede cursar todas las materias de la misma.")
    void inscripcionAprobada() {
        final Alumno alumno1 = new Alumno();
        alumno1.aprobarMateria(InscripcionesTest.algoritmos);
        alumno1.aprobarMateria(InscripcionesTest.discreta);
        alumno1.aprobarMateria(InscripcionesTest.syo);
        final Inscripcion inscripcion1 = new Inscripcion(alumno1 );
        inscripcion1.agregarMaterias(InscripcionesTest.pdep, InscripcionesTest.ads);
        assertTrue(inscripcion1.aprobada());

        final Alumno alumno2 = new Alumno();
        alumno2.aprobarMateria(algoritmos);
        alumno2.aprobarMateria(discreta);
        alumno2.aprobarMateria(syo);
        alumno2.aprobarMateria(pdep);
        final Inscripcion inscripcion2 = new Inscripcion(alumno2);
        inscripcion2.agregarMaterias(InscripcionesTest.ads, InscripcionesTest.dds);
        assertFalse(inscripcion2.aprobada()); // dds no cumple con las correlatividades necesarias
    }


}

