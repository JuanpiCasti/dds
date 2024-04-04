package domain.inscripciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Materia {
    private final List<Materia> correlativas;

    public Materia() {
        this.correlativas = new ArrayList<>();
    }

    public void establecerCorrelativas(Materia ...correlativas) {
        Collections.addAll(this.correlativas, correlativas);
    }
    public boolean puedeCursar(Alumno alumno) {
        return correlativas.stream().allMatch(alumno::materiaAprobada);
    }
}
