package modelo;

public class Estudiante extends Persona {
    private String grado;
    private String seccion;
    private double promedioGeneral;

    public Estudiante(String codigo, String nombre, String apellido, String dni,
                       String grado, String seccion) {
        super(codigo, nombre, apellido, dni);
        this.grado = grado;
        this.seccion = seccion;
        this.promedioGeneral = 0.0;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public double getPromedioGeneral() {
        return promedioGeneral;
    }

    public void setPromedioGeneral(double promedioGeneral) {
        this.promedioGeneral = promedioGeneral;
    }

    @Override
    public String toString() {
        return super.toString() + " | Grado: " + grado + " | Seccion: " + seccion;
    }
}
