package domain.inscripciones;

import java.util.ArrayList;
import java.util.List;

public class Inscripcion {
    final private Alumno alumno;
    final private List<Materia> materias;

    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.materias = materias;
        this.alumno = alumno;
    }

    public boolean aprobada() {
       return materias.stream().allMatch(m -> m.puedeCursar(alumno));
    }
}
