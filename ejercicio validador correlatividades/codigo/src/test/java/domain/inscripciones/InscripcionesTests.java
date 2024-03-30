package domain.inscripciones;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class InscripcionesTest {
    private final Materia algoritmos = new Materia(new ArrayList<>());
    private final Materia syo = new Materia(new ArrayList<>());
    private final Materia discreta = new Materia(new ArrayList<>());
    private final Materia pdep = new Materia(new ArrayList<>(List.of(algoritmos, discreta)));
    private final Materia ads = new Materia(new ArrayList<>(List.of(syo, algoritmos, discreta)));
    private final Materia dds = new Materia(new ArrayList<>(List.of(pdep, ads)));

    @Test
    @DisplayName("Un alumno puede cursar una materia solo si tiene aprobadas todas sus correlativas.")
    void materiaPuedeCursar() {
        final Alumno alumno1 = new Alumno();
        alumno1.aprobarMateria(algoritmos);
        alumno1.aprobarMateria(discreta);
        assertTrue(pdep.puedeCursar(alumno1));
        assertFalse(ads.puedeCursar(alumno1)); // ads requiere que syo tambien este aprobada
    }

    @Test
    @DisplayName("Una inscripción solo estará aprobada si el alumno puede cursar todas las materias de la misma.")
    void inscripcionAprobada() {
        final Alumno alumno1 = new Alumno();
        alumno1.aprobarMateria(algoritmos);
        alumno1.aprobarMateria(discreta);
        alumno1.aprobarMateria(syo);
        final Inscripcion inscripcion1 = new Inscripcion(alumno1, new ArrayList<>(List.of(pdep, ads)));
        assertTrue(inscripcion1.aprobada());

        final Alumno alumno2 = new Alumno();
        alumno2.aprobarMateria(algoritmos);
        alumno2.aprobarMateria(discreta);
        alumno2.aprobarMateria(syo);
        alumno2.aprobarMateria(pdep);
        final Inscripcion inscripcion2 = new Inscripcion(alumno2, new ArrayList<>(List.of(ads, dds)));
        assertFalse(inscripcion2.aprobada()); // dds no cumple con las correlatividades necesarias
    }


}

