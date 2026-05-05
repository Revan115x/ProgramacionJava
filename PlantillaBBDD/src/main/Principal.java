package main;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;
import bbdd.*;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sLeer = new Scanner(System.in);
		int opc = 0;

		BD bd = new BD("mysql-properties.xml");

		do {
			/*MENU*/
			try {
				opc = sLeer.nextInt();
			}

			catch (InputMismatchException e) {
				System.out.println("Debes introducir n�mero 1-5");
				opc = 0;
			}

			sLeer.nextLine();
			switch (opc) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				System.out.println("Saliendo del programa...");
				break;
			}
		} while (opc != 5);
	}
}
