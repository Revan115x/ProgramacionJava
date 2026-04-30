package modelos;

public class salas {
	
	private String peliculas;
	private int aforo;
	private int sala;
	private int plazas_ocupadas;
	
	public salas(String peliculas, int aforo, int sala, int plazas_ocupadas) {
		super();
		this.peliculas = peliculas;
		this.aforo = aforo;
		this.sala = sala;
		this.plazas_ocupadas = plazas_ocupadas;
	}
	
	public int plazas_libres() {
		
		int resultado=aforo-plazas_ocupadas;
		
		return resultado;
		
	}
	

	public String getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(String peliculas) {
		this.peliculas = peliculas;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public int getPlazas_ocupadas() {
		return plazas_ocupadas;
	}

	public void setPlazas_ocupadas(int plazas_ocupadas) {
		this.plazas_ocupadas = plazas_ocupadas;
	}

	@Override
	public String toString() {
		return "salas [peliculas=" + peliculas + ", aforo=" + aforo + ", sala=" + sala + ", plazas_ocupadas="
				+ plazas_ocupadas + "]";
	}
	
	
	

}
