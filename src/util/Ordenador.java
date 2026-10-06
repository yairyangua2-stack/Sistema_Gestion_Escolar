package util;

import java.util.Comparator;

public class Ordenador {

    public static <T> void burbuja(T[] arreglo, int cantidad, Comparator<T> criterio) {
        for (int i = 0; i < cantidad - 1; i++) {
            for (int j = 0; j < cantidad - 1 - i; j++) {
                if (criterio.compare(arreglo[j], arreglo[j + 1]) > 0) {
                    T temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public static void burbujaParalelo(String[] nombres, double[] promedios, int cantidad) {
        for (int i = 0; i < cantidad - 1; i++) {
            for (int j = 0; j < cantidad - 1 - i; j++) {
                if (promedios[j] < promedios[j + 1]) {
                    double tempP = promedios[j];
                    promedios[j] = promedios[j + 1];
                    promedios[j + 1] = tempP;

                    String tempN = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = tempN;
                }
            }
        }
    }
}
