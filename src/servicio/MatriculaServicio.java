package servicio;

import java.util.ArrayList;
import modelo.Matricula;
import modelo.Estudiante;
import modelo.Curso;

public class MatriculaServicio {
    private ArrayList<Matricula> matriculas;

    public MatriculaServicio() {
        this.matriculas = new ArrayList<>();
    }

    public void matricular(Estudiante estudiante, Curso curso){
        matriculas.add(new Matricula(estudiante, curso));
    }

    public boolean retirar(Matricula matricula){
        return matriculas.remove(matricula);
    }
    
    public boolean eliminarPorCodigo(String codigo){
    for (int i = 0; i < matriculas.size(); i++){
        if (matriculas.get(i).getEstudiante().getCodigo().equalsIgnoreCase(codigo)){
            matriculas.remove(i);
            return true;
        }
    }

    return false;
}

    public Matricula buscarPorCodigo(String codigo){
        for (Matricula m : matriculas){
            if (m.getEstudiante().getCodigo().equalsIgnoreCase(codigo)) {
                return m;
            }
        }
        return null;
    }

    public Matricula buscarPorNombre(String nombre){
        for (Matricula m : matriculas){
            String nombreCompleto = m.getEstudiante().getNombreCompleto();
            if (nombreCompleto.toLowerCase().contains(nombre.toLowerCase())) {
                return m;
            }
        }
        return null;
    }

    public String listar(){
        String texto = "";
        for (Matricula m : matriculas){
            texto += m.toString()+ "\n";
        }
        return texto;
    }

    public void ordenarPorNombre(){
        for (int i = 0; i < matriculas.size() - 1; i++){
            for (int j = 0; j < matriculas.size() - 1 - i; j++){
                String nombre1 =matriculas.get(j).getEstudiante().getNombre();
                String nombre2 = matriculas.get(j + 1).getEstudiante().getNombre();

                if (nombre1.compareToIgnoreCase(nombre2) > 0){
                    Matricula auxiliar = matriculas.get(j);
                    matriculas.set(j,matriculas.get(j + 1));
                    matriculas.set( j + 1,auxiliar);
                }
            }
        }
    }

    public void ordenarPorGrado(){
        for (int i = 0; i < matriculas.size() - 1; i++){
            for (int j = 0;  j < matriculas.size() - 1 - i; j++) {

                String grado1 = matriculas.get(j).getEstudiante().getGrado();
                String grado2 = matriculas.get(j + 1).getEstudiante().getGrado();

                if (grado1.compareToIgnoreCase(grado2) > 0){
                    Matricula auxiliar = matriculas.get(j);
                    matriculas.set(j,matriculas.get(j + 1));

                    matriculas.set(j + 1,auxiliar);
                }
            }
        }
    }

    public int cantidad(){
        return matriculas.size();
    }

    public ArrayList<Matricula> getMatriculas(){
        return matriculas;
    }
}