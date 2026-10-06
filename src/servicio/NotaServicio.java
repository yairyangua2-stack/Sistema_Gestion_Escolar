package servicio;

import util.EscalaCalificacion;

public class NotaServicio {
    private String[] codigos;
    private String[] nombres;
    private double[][] matrizNotas;
    private int cantidad;

    public NotaServicio(int capacidadEstudiantes, int numeroEvaluaciones){
        codigos = new String[capacidadEstudiantes];
        nombres = new String[capacidadEstudiantes];
        matrizNotas = new double[capacidadEstudiantes][numeroEvaluaciones];
        cantidad = 0;
    }

    public boolean registrarNotas(String codigo, String nombre, double[] notas){
        int fila = buscarIndice(codigo);

        if (fila == -1){
            if (cantidad >= codigos.length){
                return false;
            }
            fila = cantidad;
            codigos[fila] = codigo;
            nombres[fila] = nombre;
            cantidad++;
        }
        for (int i = 0; i < notas.length; i++){
            matrizNotas[fila][i] = notas[i];
        }
        return true;
    }

    public int buscarIndice(String codigo){
        for (int i = 0; i < cantidad; i++){
            if (codigos[i].equalsIgnoreCase(codigo)){
                return i;
            }
        }
        return -1;
    }

    public boolean tieneNotas(String codigo){
        return buscarIndice(codigo) != -1;
    }

    public double[] obtenerNotas(String codigo){
        int fila = buscarIndice(codigo);
        if (fila == -1){
            return null;
        }
        double[] notas = new double[matrizNotas[fila].length];

        for (int i = 0; i < notas.length; i++){
            notas[i] = matrizNotas[fila][i];
        }
        return notas;
    }

    public double promedioComunicacion(int fila){
        return (matrizNotas[fila][0] + matrizNotas[fila][1] + matrizNotas[fila][2]) / 3;
    }

    public double promedioMatematicas(int fila){
        return (matrizNotas[fila][3] + matrizNotas[fila][4] + matrizNotas[fila][5]) / 3;
    }

    public double promedioCYT(int fila){
        return (matrizNotas[fila][6] + matrizNotas[fila][7] + matrizNotas[fila][8]) / 3;
    }

    public double promedioIngles(int fila){
        return (matrizNotas[fila][9] + matrizNotas[fila][10] + matrizNotas[fila][11]) / 3;
    }

    public double promedioGeneral(int fila){
        double comunicacion = promedioComunicacion(fila);
        double matematicas = promedioMatematicas(fila);
        double cyt = promedioCYT(fila);
        double ingles = promedioIngles(fila);

        return (comunicacion + matematicas + cyt + ingles) / 4;
    }

    public String listar(){
        if (cantidad == 0){
            return "No hay notas registradas.";
        }
        String texto = "";

        for (int i = 0; i < cantidad; i++){
            double comunicacion = promedioComunicacion(i);
            double matematicas = promedioMatematicas(i);
            double cyt = promedioCYT(i);
            double ingles = promedioIngles(i);
            double general = promedioGeneral(i);

            texto += "Código: " + codigos[i] + "\n";
            texto += "Estudiante: " + nombres[i] + "\n";
            texto += "Comunicación: " + String.format("%.2f", comunicacion) + " - " + EscalaCalificacion.convertirALiteral(comunicacion) + "\n";
            texto += "Matemática: " + String.format("%.2f", matematicas) + " - " + EscalaCalificacion.convertirALiteral(matematicas) + "\n";
            texto += "Ciencia y Tecnología: " + String.format("%.2f", cyt) + " - " + EscalaCalificacion.convertirALiteral(cyt) + "\n";
            texto += "Inglés: " + String.format("%.2f", ingles) + " - " + EscalaCalificacion.convertirALiteral(ingles) + "\n";
            texto += "Promedio General: " + String.format("%.2f", general) + " - " + EscalaCalificacion.convertirALiteral(general) + "\n";
            texto += "----------------------------------------\n";
        }
        return texto;
    }

    public void ordenarMayorAMenor(){
        for (int i = 0; i < cantidad - 1; i++){
            for (int j = 0; j < cantidad - 1 - i; j++){
                if (promedioGeneral(j) < promedioGeneral(j + 1)){
                    intercambiar(j, j + 1);
                }
            }
        }
    }

    public void ordenarMenorAMayor(){
        for (int i = 0; i < cantidad - 1; i++){
            for (int j = 0; j < cantidad - 1 - i; j++){
                if (promedioGeneral(j) > promedioGeneral(j + 1)){
                    intercambiar(j, j + 1);
                }
            }
        }
    }

    private void intercambiar(int fila1, int fila2){
        String auxiliarCodigo = codigos[fila1];
        codigos[fila1] = codigos[fila2];
        codigos[fila2] = auxiliarCodigo;

        String auxiliarNombre = nombres[fila1];
        nombres[fila1] = nombres[fila2];
        nombres[fila2] = auxiliarNombre;

        for (int j = 0; j < matrizNotas[0].length; j++){
            double auxiliarNota = matrizNotas[fila1][j];
            matrizNotas[fila1][j] = matrizNotas[fila2][j];
            matrizNotas[fila2][j] = auxiliarNota;
        }
    }

    public void eliminarNotas(String codigo){
        int fila = buscarIndice(codigo);
        if (fila == -1){
            return;
        }

        for (int i = fila; i < cantidad - 1; i++){
            codigos[i] = codigos[i + 1];
            nombres[i] = nombres[i + 1];
            
            for (int j = 0; j < matrizNotas[0].length; j++){
                matrizNotas[i][j] = matrizNotas[i + 1][j];
            }
        }
        codigos[cantidad - 1] = null;
        nombres[cantidad - 1] = null;

        for (int j = 0; j < matrizNotas[0].length; j++){
            matrizNotas[cantidad - 1][j] = 0;
        }
        cantidad--;
    }

    public int getCantidad(){
        return cantidad;
    }

    public double[][] getMatrizNotas(){
        return matrizNotas;
    }
}