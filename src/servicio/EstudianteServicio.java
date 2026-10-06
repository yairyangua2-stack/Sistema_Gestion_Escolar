package servicio;

import modelo.Estudiante;

public class EstudianteServicio {
    private ArregloEstudiantes estudiantes;
    private ArregloEstudiantes respaldo;

    public EstudianteServicio(int capacidad) {
        estudiantes =new ArregloEstudiantes(capacidad);
        respaldo = null;
    }

    public boolean registrar(Estudiante estudiante) {
        return estudiantes.insertar(estudiante);
    }

    public boolean editar(String codigo, Estudiante nuevo) {
        return estudiantes.actualizar(codigo, nuevo);
    }

    public boolean eliminar(String codigo) {
        return estudiantes.eliminar(codigo);
    }
    
    public Estudiante buscarPorDni(String dni){
    return estudiantes.buscarPorDni(dni);
}

    public Estudiante buscar(String codigo) {
        return estudiantes.buscarPorCodigo(codigo);
    }
    
    public Estudiante buscarPorNombre(String nombre) {
        return estudiantes.buscarPorNombre(nombre);
    }

    public String listar() {
        return estudiantes.recorrer();
    }

    public void ordenarPorNombre() {
        estudiantes.ordenarPorNombre();
    }

    public void ordenarPorGrado() {
        estudiantes.ordenarPorGrado();
    }
    
    public void generarRespaldo() {
        respaldo = estudiantes.copiar();
    }

    public boolean compararConRespaldo() {
        if (respaldo == null) {
            return false;
        }
        return estudiantes.comparar(respaldo);
    }

    public ArregloEstudiantes fusionarCon(ArregloEstudiantes otro) {
        return ArregloEstudiantes.fusionar(estudiantes,otro);
    }

    public ArregloEstudiantes getEstudiantes() {
        return estudiantes;
    }
}
