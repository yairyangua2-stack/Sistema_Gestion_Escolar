package servicio;

import modelo.Docente;

import java.util.LinkedList;

public class DocenteServicio {
    private ListaSimple<Docente> docentes= new ListaSimple<>();
    
    public void registrarInicio(Docente docente){
        docentes.addFirst(docente);
    }
    
    public void registrarFinal(Docente docente){
        docentes.addLast(docente);
    }

    public boolean registrarIndice(int indice,Docente docente){
        return docentes.add(indice,docente);
    }
    public boolean eliminar(String codigo){
        Docente encontrado = buscarPorCodigo(codigo);
        if (encontrado == null) {
            return false;
        }
        return docentes.eliminar(encontrado);
    }

    public Docente buscarPorCodigo(String codigo){
         for (int i = 0; i < docentes.tamanio(); i++){
            Docente d = docentes.get(i);
            
            if (d.getCodigo().equalsIgnoreCase(codigo)){
                return d;
            }
        }
        return null;
    }
    
    public Docente buscarPorNombre(String nombre){
    for (int i = 0; i < docentes.tamanio(); i++){
        Docente d = docentes.get(i);

        if (d.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase())){
            return d;
        }
    }
    return null;
}
    
    public Docente buscarPorDni(String dni){
    for (int i = 0; i < docentes.tamanio(); i++){
        Docente d = docentes.get(i);
        if (d.getDni().equalsIgnoreCase(dni)){
            return d;
        }
    }
    return null;
}

    public String listar() {
        return docentes.recorrer();
    }
    
    public void ordenarPorNombre() {
        docentes.ordenar((d1, d2) ->d1.getNombre().compareToIgnoreCase(d2.getNombre()));
    }

    public int cantidad(){
        return docentes.tamanio();
    }

    public ListaSimple<Docente> getDocentes(){
        return docentes;
    }
}


    

