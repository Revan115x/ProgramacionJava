package MediaAlumnos;

public class MediaAlum {

    private int numalum;
    private double notaJava;
    private double bbddd;
    private double marcas;
    private double media;

    private static int totalAlumnos = 0;
    private static double sumaMedias = 0;
    private static int alumnosAprobados = 0;

    // CONSTRUCTOR
    public MediaAlum(int numalum, double j, double b, double m) {
        this.numalum = numalum;
        this.notaJava = j;
        this.bbddd = b;
        this.marcas = m;

        // media del alumno
        this.media = (j + b + m) / 3;

        // variables de clase
        totalAlumnos++;
        sumaMedias += this.media;

        if (this.media >= 5) {
            alumnosAprobados++;
        }
    }

    // =====================
    // MÉTODOS ESTÁTICOS
    // =====================

    public static double getMediaClase() {
        if (totalAlumnos == 0) return 0;
        return sumaMedias / totalAlumnos;
    }

    public static int getAlumnosAprobados() {
        return alumnosAprobados;
    }

    public double getMediaAlumno() {
        return media;
    }

    @Override
    public String toString() {
        return "Alumno " + numalum +
               " → media = " + media;
    }
}
