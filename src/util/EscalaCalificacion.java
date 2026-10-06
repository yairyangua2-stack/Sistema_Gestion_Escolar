package util;

public class EscalaCalificacion {

    public static String convertirALiteral(double notaVigesimal) {
        if (notaVigesimal >= 18) {
            return "AD";
        } else if (notaVigesimal >= 14) {
            return "A";
        } else if (notaVigesimal >= 11) {
            return "B";
        } else {
            return "C";
        }
    }

    public static String descripcion(String literal) {
        switch (literal) {
            case "AD":
                return "Logro destacado";
            case "A":
                return "Logro esperado";
            case "B":
                return "En proceso";
            default:
                return "En inicio";
        }
    }
}
