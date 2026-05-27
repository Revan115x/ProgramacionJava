package objetodb;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class GestionLibros {
	public static void main(String[] args) {
		String titulo, autor,id;
		int opcion;
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("libros.odb");
		EntityManager em = emf.createEntityManager();

		do {

			System.out.println("1. Alta libro\n2. Mostrar libros\n5. Salir");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				sc.nextLine();
				System.out.println("Introduce id:");
				id = sc.nextLine();
				System.out.println("Introduce titulo:");
				titulo = sc.nextLine();
				System.out.println("Introduce autor:");
				autor = sc.nextLine();

				em.getTransaction().begin();

				Libro l1 = new Libro(id,titulo, autor);
				em.persist(l1);
				em.getTransaction().commit();
				break;
			case 2:

				TypedQuery<Libro> consulta = em.createQuery("SELECT l FROM Libro l", Libro.class);
				List<Libro> libros = consulta.getResultList();
				for (Libro l : libros) {
					System.out.println(l);
				}
			}
		} while (opcion != 5);

		em.close();
		emf.close();
	}
}