package servicio;

import modelo.Curso;
import java.util.LinkedList;

public class CursoServicio {
    private LinkedList<Curso> cursos;

    public CursoServicio() {
        this.cursos = new LinkedList<>();
    }

    public void registrar(Curso curso) {
        cursos.add(curso);
    }

    public boolean eliminar(String codigoCurso) {
        Curso encontrado = buscarPorCodigo(codigoCurso);
        if (encontrado == null) {
            return false;
        }
        cursos.remove(encontrado);
        return true;
    }

    public Curso buscarPorCodigo(String codigoCurso) {
        for (Curso c : cursos) {
            if (c.getCodigoCurso().equalsIgnoreCase(codigoCurso)) {
                return c;
            }
        }
        return null;
    }

    public String listar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cursos.size(); i++) {
            sb.append(cursos.get(i).toString());
            if (i < cursos.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public int cantidad() {
        return cursos.size();
    }

    public LinkedList<Curso> getCursos() {
        return cursos;
    }
}
