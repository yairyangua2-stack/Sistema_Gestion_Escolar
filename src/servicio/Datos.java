package servicio;

public class Datos {
    public static EstudianteServicio estudiantes = new EstudianteServicio(100);

    public static DocenteServicio docentes = new DocenteServicio();

    public static MatriculaServicio matriculas = new MatriculaServicio();

    public static NotaServicio notas = new NotaServicio(100, 12);

    private static int codigoEstudiante = 10001;
    private static int codigoDocente = 20001;

    public static String generarCodigoEstudiante(){
        String codigo = String.valueOf(codigoEstudiante);
        codigoEstudiante++;
        return codigo;
    }

    public static String generarCodigoDocente() {
        String codigo = String.valueOf(codigoDocente);
        codigoDocente++;
        return codigo;
    }
}
