package Cine.linkedList.copy;

import java.util.LinkedList;
import java.util.Random;

public class cine {

	private LinkedList<Usuario> cola;
	private int entradasGeneral,vendidas;
	
	public cine() {
		super();
		this.cola = new LinkedList<Usuario>();
		this.entradasGeneral = entradasGeneral;
	}
	
	public void llegarCola( String nombre, int entradas) {
		cola.add(new Usuario(nombre, entradas));
		
	}
	
	public void comprarEntradas() {
		
		Usuario u = cola.removeFirst();
		int ent = Usuario.getEntradasGeneral();
		if (ent >=entradasGeneral) {
			System.out.println("NO HAY SUFICIENTES ENTRADAS");
		}else {
			System.out.println("Entradas compradas");
		}
		if (ent==entradasGeneral) {
			System.out.println("Ya no quedan entradas");
			cola.clear();
		}
	}
	
	public void dejarcola() {
		Random usuario = new Random();
		if (cola.isEmpty())
			System.out.println("No hay nadie en cola");
		else {
			int colagetout = usuario.nextInt(cola.size());
			System.out.println(cola.get(colagetout).getNombre() + " abandonó la cola");
			cola.remove(colagetout);
		}
	}
	
	public void mostrarcola() {
		if (cola.isEmpty())
			System.out.println("NO HAY NADIE EN COLA");
		else {
			for (int i = 0; i < cola.size(); i++) {
				if(cola.size()>1)
					System.out.println("***************************");
				System.out.println(cola.get(i).datosNombre());
			}
		}
	}
	
}
