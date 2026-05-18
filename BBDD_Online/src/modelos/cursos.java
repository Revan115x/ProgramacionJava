package modelos;

import java.time.LocalDate;

public class cursos {

	private String codigo;
	private String titulo;
	private String categoria;
	private double precio;
	private LocalDate fechainicio;
	private int plazas;
	
	public cursos(String codigo, String titulo, String categoria, double precio, LocalDate fechainicio, int plazas) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.precio = precio;
		this.fechainicio = fechainicio;
		this.plazas = plazas;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public LocalDate getFechainicio() {
		return fechainicio;
	}

	public int getPlazas() {
		return plazas;
	}

	@Override
	public String toString() {
		return "cursos [codigo=" + codigo + ", titulo=" + titulo + ", categoria=" + categoria + ", precio=" + precio
				+ ", fechainicio=" + fechainicio + ", plazas=" + plazas + "]";
	}

	
	
}
