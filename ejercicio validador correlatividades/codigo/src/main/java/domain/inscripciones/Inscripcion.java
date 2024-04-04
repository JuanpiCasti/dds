package domain.inscripciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    final private Alumno alumno;
    final private List<Materia> materias;

    public Inscripcion(Alumno alumno) {
        this.materias = new ArrayList<>();
        this.alumno = alumno;
    }

    public void agregarMaterias(Materia ...materias) {
        Collections.addAll(this.materias, materias);
    }
    public boolean aprobada() {
       return materias.stream().allMatch(m -> m.puedeCursar(alumno));
    }
}
