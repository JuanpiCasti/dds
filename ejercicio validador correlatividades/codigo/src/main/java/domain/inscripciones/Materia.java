package domain.inscripciones;

import java.util.List;

public class Materia {
    private final List<Materia> correlativas;

    public Materia(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }
    public boolean puedeCursar(Alumno alumno) {
        return correlativas.stream().allMatch(alumno::materiaAprobada);
    }
}
