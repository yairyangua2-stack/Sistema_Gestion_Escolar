package util;

public class MatrizUtil {

    public static double[] promedioPorFila(double[][] matriz) {
        double[] promedios = new double[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            double suma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
            promedios[i] = matriz[i].length == 0 ? 0 : suma / matriz[i].length;
        }
        return promedios;
    }

    public static double[][] transponer(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        double[][] transpuesta = new double[columnas][filas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;
    }

    public static String imprimir(double[][] matriz) {
        StringBuilder sb = new StringBuilder();
        for (double[] fila : matriz) {
            for (double valor : fila) {
                sb.append(valor).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
