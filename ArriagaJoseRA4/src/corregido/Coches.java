package corregido;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Coches {

	private static final int LIBRE = 0;
	private String matricula, codigo;
    private double ganancias;
    private int estado;
    private LocalTime horaReserva;
    private static final double preciosegundo=0.8;
    private static int Alquilados,reservados;
    
    public Coches(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Coche [matricula=" + matricula + ", codigo=" + codigo + ", ganancias=" + ganancias + ", estado="
                + estado + ", horaReserva=" + horaReserva + "]";
    }

    public String getMatricula() {
        return matricula;
    }

    public int getEstado() {
        return estado;
    }
    
    public String reservar() {
        Random r=new Random();
        if (estado!=Coches.LIBRE)
            return null;
        estado=1;
        codigo=matricula.substring(4,7).toLowerCase()+(r.nextInt(10)+1);
        horaReserva=LocalTime.now();
        reservados++;
        return codigo;
    }
     
	public boolean alquilar(String cod) {
		if(estado!=1)
		return false;
		if(!cod.equals(codigo)) {
			estado=0;
			reservados--;
			codigo=null;
			horaReserva=null;
			return false;
		}
		codigo=null;
		horaReserva=null;
		reservados--;
		Alquilados++;
		estado=2;
		return true;
	}
	
	public double estacionar() {
		double importe;
		if(estado!=2)
			return 0;
		Random r=new Random();
		//int n=r.nextInt(10,201);
		int n=r.nextInt(191)+10;
		importe=n*preciosegundo;
		ganancias+=importe;
		estado=0;
		Alquilados--;
		return importe;
	}

	public static int getAlquilados() {
		return Alquilados;
	}

	public static int getReservados() {
		return reservados;
	}
	
	public void liberar() {
		if(estado!=1)
			return;
		long seg=ChronoUnit.SECONDS.between(horaReserva, LocalTime.now());
		if(seg>20)
			estado=0;
			reservados--;
	}
	
}
