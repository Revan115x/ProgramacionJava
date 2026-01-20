package MediaAlumnos;
public class Main {

    public static void main(String[] args) {

        MediaAlum a1 = new MediaAlum(1, 6, 7, 5);
        MediaAlum a2 = new MediaAlum(2, 4, 3, 5);
        MediaAlum a3 = new MediaAlum(3, 8, 9, 10);

        System.out.println("Media clase: " + MediaAlum.getMediaClase());
        System.out.println("Aprobados: " + MediaAlum.getAlumnosAprobados());
    }
}
