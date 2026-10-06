package servicio;

import java.util.Comparator;

public class ListaSimple<T>{
    private Nodo<T> inicio;
    private int tamanio;

    public ListaSimple(){
        inicio = null;
        tamanio = 0;
    }

    public void addFirst(T dato){
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = inicio;
        inicio = nuevo;
        tamanio++;
    }

    public void addLast(T dato){
        Nodo<T> nuevo = new Nodo<>(dato);
        
        if (inicio == null){
            inicio = nuevo;
        } else {
            Nodo<T> actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamanio++;
    }

    public boolean add(int indice, T dato){
        if (indice < 0 || indice > tamanio){
            return false;
        }

        if (indice == 0){
            addFirst(dato);
            return true;
        }

        if (indice == tamanio){
            addLast(dato);
            return true;
        }

        Nodo<T> nuevo = new Nodo<>(dato);
        Nodo<T> actual = inicio;

        for (int i = 0; i < indice - 1;i++) {
            actual = actual.siguiente;
        }
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
        tamanio++;
        return true;
    }

    public boolean eliminar(T dato){
        if (inicio == null) {
            return false;
        }

        if (inicio.dato.equals(dato)) {
            inicio = inicio.siguiente;
            tamanio--;
            return true;
        }
        Nodo<T> actual = inicio;

        while (actual.siguiente != null){
            if (actual.siguiente.dato.equals(dato)) {
                actual.siguiente =  actual.siguiente.siguiente;
                tamanio--;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public T get(int indice){
        if (indice < 0 || indice >= tamanio){
            return null;
        }
        Nodo<T> actual = inicio;

        for (int i = 0; i < indice; i++){
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    public String recorrer(){
        String texto = "";
        Nodo<T> actual = inicio;

        while (actual != null){
            texto += actual.dato.toString() + "\n";
            actual = actual.siguiente;
        }
        return texto;
    }
    public int tamanio(){
        return tamanio;
    }

    public void ordenar(Comparator<T> criterio){
        if (inicio == null) {
            return;
        }

        for (int i = 0; i < tamanio - 1; i++){
            Nodo<T> actual = inicio;
            while (actual.siguiente != null){

                if (criterio.compare(actual.dato,actual.siguiente.dato) > 0){
                    T auxiliar = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = auxiliar;
                }
                actual = actual.siguiente;
            }
        }
    }
}