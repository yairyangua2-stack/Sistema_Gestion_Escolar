package modelo;

public class Docente extends Persona {
    private String especialidad;

    public Docente(String codigo, String nombre, String apellido, String dni,
                    String especialidad) {
        super(codigo, nombre, apellido, dni);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString() + " | Especialidad: " + especialidad;
    }
}
