package domain.inscripciones;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    final private List<Materia> materiasAprobadas;

    public Alumno() {
        this.materiasAprobadas = new ArrayList<>();
    }
    public void aprobarMateria(Materia materia) {
        this.materiasAprobadas.add(materia);
    }

    public boolean materiaAprobada(Materia materia) {
        return materiasAprobadas.contains(materia);
    }
}
