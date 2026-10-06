package util;

public class Validador {

    public static boolean validarTexto(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean validarDni(String dni) {
        return dni != null && dni.matches("\\d{8}");
    }

    public static boolean validarCodigo(String codigo) {
        return codigo != null && codigo.matches("[A-Za-z0-9\\-]{3,15}");
    }

    public static boolean validarNota(double nota) {
        return nota >= 0 && nota <= 20;
    }
}
