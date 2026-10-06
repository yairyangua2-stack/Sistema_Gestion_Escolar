package modelo;

public class Curso {
    private String codigoCurso;
    private String nombre;
    private Docente docente;
    private String aula;
    private String horario;

    public Curso(String codigoCurso, String nombre, Docente docente,
                  String aula, String horario) {
        this.codigoCurso = codigoCurso;
        this.nombre = nombre;
        this.docente = docente;
        this.aula = aula;
        this.horario = horario;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return codigoCurso + " - " + nombre;
    }
}
