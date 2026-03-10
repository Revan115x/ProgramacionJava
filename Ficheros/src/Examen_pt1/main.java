package Examen_pt1;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.nio.file.OpenOption;

import Fichero13.Alumno;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * auto.info: contiene separado por comas la matrícula, fecha de compra, precio
		 * y el dni del propietario. Propietario.info: contiene separado por comas el
		 * dni del propietario, su nombre y apellido. Recorrer auto.info y crear un
		 * objeto automóvil por cada línea con los datos del auto y de su propietario (3
		 * ptos) (si la fecha es incorrecta, o si no existe el propietario se escribe un
		 * error en un archivo log que recogerá todos los errores producidos y no se
		 * crea el objeto). (1,5 pto) Mostrad todos los automóviles ordenados por fecha
		 * de compra de más antigua a más reciente, y a misma fecha, ordenado de menor a
		 * mayor precio.(2 ptos)
		 */

		Scanner sc = new Scanner(System.in);

		/* PATH PARA AUTOS.INFO, PROPIETARIO.INFO */
		Path autos = Paths.get("auto.info.txt");
		Path dueños = Paths.get("Propietario.info.txt");

		/* Declaro el tipo de codificacion */
		Charset charset = Charset.forName("UTF-8");

		/* BUFFER PARA LEER Y ESCRIBIR */
		BufferedReader leer = null;
		BufferedReader leerP = null;
		BufferedWriter escribir = null;

		/* LINKEDLIST PARA COCHES */
		LinkedList<auto> coche = new LinkedList<auto>();

		/* HAST MAP PARA DUEÑOS */
		HashMap<String, String> dueño = new HashMap<>();

		/* PATRON PARA FECHA */
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/LL/yyyy");

		if (Files.isDirectory(autos)) {
			System.out.println("Debe de ser un fichero!");
		} else if (!Files.isRegularFile(autos)) {
			System.out.println("No es un fichero!");
		} else {

			/* TRY CATCH OBLIGATORIO PARA CONTENER LOS ERRORES */
			try {
				/* BUFFER PARA LEER DUEÑOS.INF */
				leerP = Files.newBufferedReader(dueños, charset);
				String line1 = null;

				/* BUCLE PARA LEER LO QUE TIENE CADA LINEA DE DUEÑO.INF */
				while ((line1 = leerP.readLine()) != null) {
					/* ARRAY DE STRING PARA SEPARAR LOS DATOS POR "," COMO USANDO SPLIT */
					String resultados[] = line1.split(",");

					/* LE DIRE QUE CLAVE PRIMARIA SERA EL DNI */
					String dni = resultados[0];

					/* Y LOS DATOS RESTANTES LOS JUNTO EN UN STRING DE DATOS */
					String datos = resultados[1] + resultados[2];

					/* GUARDO LOS DATOS SEPARADOS EN EL HASHMAP */
					dueño.put(dni, datos);

				}

				/* CIERRO ARCHIVO */
				leerP.close();

				/* BUFFER PARA LEER LOS AUTO.INF Y ESCRIBIR EN LOG LOS ERRORES */
				leer = Files.newBufferedReader(autos, charset);
				escribir = Files.newBufferedWriter(Paths.get("log.txt"), charset, CREATE, APPEND);
				String line = null;

				/* BUCLE PARA LEER LAS LINEAS DE AUTOS.INF */
				while ((line = leer.readLine()) != null) {

					/* ARRAY IGUAL QUE EL ANTERIOR PARA SEPARAR POR "," */
					String resultados[] = line.split(",");

					/*
					 * TRY Y CATCH PARA CONTROLAR LAS EXCEPCIONES QUE NOS PUEDAN DAR A LA HORA DE
					 * PARSEAR LOS DATOS
					 */

					try {
						/* INDICO CUAL ES EL VALOR QUE GUARDA DEL ARRAY EN LAS VARIABLES */
						String matricula = resultados[0];
						LocalDate fecha_comp = LocalDate.parse(resultados[1], patron);
						double precio = Double.parseDouble(resultados[2]);
						String dni = resultados[3];

						/* MONTO EL EL OBJETO CON LAS VARIABLES ANTERIORES */
						auto datos = new auto(matricula, fecha_comp, precio, dni);

						/*
						 * FUNCION QUE NOS DA LA POSICION DEL OBJETO SEGUN SU FECHA O PRECIO DE MENOR A
						 * MAYOR
						 */
						int posicion = pos(coche, datos);

						/* LLAMAMOS AL HASHMAP Y PREGUNTAMOS SI MI ID ESTA ES SU COLLECION */
						if (dueño.containsKey(dni))
							/* SI ESTA GUARDAMOS EL OBJETO EN EL ARRAYLIST CON SU POSICION */
							coche.add(posicion, datos);
						else
							/* SI NO ESTA ESCRIBIMOS EN LOG LA LINEA DEL ERROR */
							escribir.write("ERROR NO EXISTE EL DUEÑO" + line);

					} catch (DateTimeParseException e) {
						/* ESCRIBIMOS EN LOG LA LINEA DEL ERROR */
						escribir.write("ERROR FORMATO FECHA:" + line);
					} catch (NumberFormatException e) {
						/* ESCRIBIMOS EN LOG LA LINEA DEL ERROR */
						escribir.write("ERROR FORMATO NUMERO:" + line);
					}

				}

				/* MOSTRAMOS LOS DATOS DE COCHE YA ORDENADOS */
				System.out.println("*****************ARRAYLIST ORDENADO****************");
				System.out.println(coche);

			} catch (IOException e) {
				System.out.println("ERROR!");
			} finally {
				/* CERRAMOS LOS BUFFER PARA QUE FUNCIONE TODO CORRECTAMENTE */
				try {
					if (leer != null)
						leer.close();
					if (escribir != null)
						escribir.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			System.out.println("FIN PROGRAMA");
		}
	}

	public static int pos(LinkedList<auto> coche, auto datos) {

		/* leermos la clase */
		for (int i = 0; i < coche.size(); i++) {
			/*
			 * COMPARAMOS LAS FECHAS DE MI OBJETO CON LAS DEL FECHAS QUE TENGO EN MI
			 * LINKEDLIST
			 */
			if (datos.getFechaCompra().isAfter(coche.get(i).getFechaCompra()))
				return i;
			/* SI LAS FECHAS SON IGUALES PASAMOS A COMPARAR POR PRECIO DE MAYOR A MENOR */
			else if (datos.getFechaCompra().isEqual(coche.get(i).getFechaCompra()))
				if (datos.getPrecio() > coche.get(i).getPrecio())
					return i;

		}
		return coche.size();
	}

}
