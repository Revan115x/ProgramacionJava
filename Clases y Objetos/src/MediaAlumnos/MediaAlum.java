package MediaAlumnos;

/*Al ejercicio número 3 añadirle una variable que guarde el número de alumnos con
nota media aprobada.*/

public class MediaAlum {

	private static int numalum;
	private double notaJava;
	private double bbddd;
	private double marcas;
	private static double media;
	private static int contalum;
	private static double mediageneral;
	
	public MediaAlum(int numalum, double j, double b, double m ) {
		super();
		this.numalum = numalum;
		this.notaJava = j;
		this.bbddd = b;
		this.marcas = m;
		this.media= m+j+b/3;
		this.mediageneral=media/contalum;
	}
	
	public int getNumalum() {
		return numalum;
	}
	public void setNumalum(int numalum) {
		this.numalum = numalum;
		contalum++;
	}
	public double getNotaJava() {
		return notaJava;
	}
	public void setNotaJava(double notaJava) {
		this.notaJava = notaJava;
	}
	public double getBbddd() {
		return bbddd;
	}
	public void setBbddd(double bbddd) {
		this.bbddd = bbddd;
	}
	public double getMarcas() {
		return marcas;
	}
	public void setMarcas(double marcas) {
		this.marcas = marcas;
	}
	public static double getMedia() {
		return media;
	}
	public static void getMedia(double media) {
		MediaAlum.media = media;
	}
	
	public static void getmediaclase() {
		MediaAlum.getMedia();;
	}

	@Override
	public String toString() {
		return "MediaAlum [numalum=" + numalum + ", notaJava=" + notaJava + ", bbddd=" + bbddd + ", marcas=" + marcas
				+ "]";
	}
	
	
	
}
