package servicio;

import modelo.Estudiante;


public class ArregloEstudiantes {

    private Estudiante[] estudiantes;
    private int cantidad;

    public ArregloEstudiantes(int capacidad){
        estudiantes = new Estudiante[capacidad];
        cantidad = 0;
    }

    public boolean insertar(Estudiante estudiante){
        if (cantidad >= estudiantes.length) {
            return false;
        }

        estudiantes[cantidad] = estudiante;
        cantidad++;

        return true;
    }

    public Estudiante buscarPorCodigo(String codigo){
        for (int i = 0; i < cantidad; i++){
            if (estudiantes[i].getCodigo().equalsIgnoreCase(codigo)) {
                return estudiantes[i];
            }
        }
        return null;
    }

    public Estudiante buscarPorNombre(String nombre){
    for (int i = 0; i < cantidad; i++){
        String nombreCompleto = estudiantes[i].getNombreCompleto();
        if (nombreCompleto.toLowerCase().contains(nombre.toLowerCase())){
            return estudiantes[i];
        }
    }
    return null;
}

    public boolean actualizar(String codigo, Estudiante nuevo){
    for (int i = 0; i < cantidad; i++){
        if (estudiantes[i].getCodigo().equalsIgnoreCase(codigo)){
            estudiantes[i].setNombre(nuevo.getNombre());
            estudiantes[i].setApellido(nuevo.getApellido());
            estudiantes[i].setDni(nuevo.getDni());
            estudiantes[i].setGrado(nuevo.getGrado());
            estudiantes[i].setSeccion(nuevo.getSeccion());
            return true;
        }
    }
    return false;
}
    

    public boolean eliminar(String codigo){
        for (int i = 0; i < cantidad; i++){
            if (estudiantes[i].getCodigo().equalsIgnoreCase(codigo)){
                for (int j = i; j < cantidad - 1; j++) {
                    estudiantes[j] = estudiantes[j + 1];
                }
                estudiantes[cantidad - 1] = null;
                cantidad--;

                return true;
            }
        }
        return false;
    }

    public String recorrer(){
        String texto = "";
        for (int i = 0; i < cantidad; i++){
            texto += estudiantes[i].toString() + "\n";
        }

        return texto;
    }

    public void ordenarPorNombre(){
        for (int i = 0; i < cantidad - 1; i++){
            for (int j = 0; j < cantidad - 1 - i; j++){
                if (estudiantes[j].getNombre().compareToIgnoreCase(estudiantes[j + 1].getNombre()) > 0){
                    Estudiante auxiliar = estudiantes[j];
                    estudiantes[j] = estudiantes[j + 1];
                    estudiantes[j + 1] = auxiliar;
                }
            }
        }
    }

    public void ordenarPorGrado(){
        for (int i = 0; i < cantidad - 1; i++){
            for (int j = 0; j < cantidad - 1 - i; j++){
                if (estudiantes[j].getGrado().compareToIgnoreCase(estudiantes[j + 1].getGrado()) > 0){
                    Estudiante auxiliar = estudiantes[j];
                    estudiantes[j] = estudiantes[j + 1];
                    estudiantes[j + 1] = auxiliar;
                }
            }
        }
    }

    public int getCantidad(){
        return cantidad;
    }

    public Estudiante get(int posicion){
        if (posicion >= 0 && posicion < cantidad){
            return estudiantes[posicion];
        }

        return null;
    }

    public ArregloEstudiantes copiar(){
        ArregloEstudiantes copia = new ArregloEstudiantes(estudiantes.length);

        for (int i = 0; i < cantidad; i++) {
            copia.insertar(estudiantes[i]);
        }
        return copia;
    }

    public boolean comparar(ArregloEstudiantes otro){
        if (otro == null ||
                cantidad != otro.getCantidad()) {
            return false;
        }
        for (int i = 0; i < cantidad; i++) {
            if (!estudiantes[i].getCodigo().equalsIgnoreCase(otro.get(i).getCodigo())){
                return false;
            }
        }
        return true;
    }
    
    public Estudiante buscarPorDni(String dni){
    for (int i = 0; i < cantidad; i++){
        if (estudiantes[i].getDni().equalsIgnoreCase(dni)){
            return estudiantes[i];
        }
    }
    return null;
}

    public static ArregloEstudiantes fusionar(ArregloEstudiantes a, ArregloEstudiantes b){
        ArregloEstudiantes nuevo = new ArregloEstudiantes(a.getCantidad() + b.getCantidad());
        
        for (int i = 0; i < a.getCantidad(); i++) {
            nuevo.insertar(a.get(i));
        }

        for (int i = 0; i < b.getCantidad(); i++) {
            nuevo.insertar(b.get(i));
        }

        return nuevo;
    }
}