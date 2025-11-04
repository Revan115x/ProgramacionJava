package PracticasWhile;

import java.util.Locale;
import java.util.Scanner;

public class practica16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Una empresa que se dedica a la venta de desinfectantes necesita un programa
		 * para gestionar las facturas. En cada factura figura: el código del artículo,
		 * la cantidad vendida en litros y el precio por litro. El programa pedirá los
		 * datos de 5 facturas introducidas y calculará y mostrará: Facturación total
		 * cantidad en litros vendidos del artículo 1 número de facturas que se
		 * emitieron de más de 600 €.
		 */

		double totalFactura = 0, litros, CantLitros = 0, contlitros = 0, FacturacionTotal = 0, mas600 = 0;
		double precioLitro = 5.20;
		int articulo;

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);

		for (int i = 0; i < 5; i += 1) {
			System.out.println("Dime el codigo del articulo");
			articulo = sc.nextInt();
			System.out.println("Cuantos Litros");
			litros = sc.nextDouble();
			System.out.println("Anota precio Litro:");
			precioLitro = sc.nextDouble();

			if (articulo == 1) {
				CantLitros = CantLitros + litros;
			}

			totalFactura = precioLitro * CantLitros;
			if (totalFactura > 600)
				mas600 += 1;
			FacturacionTotal = FacturacionTotal + totalFactura;

			System.out.println(+totalFactura);

		}
		System.out.println("Factura Total "+FacturacionTotal);
		System.out.println("Factura mayor 600€ "+mas600);
		System.out.println("Cantidad de litros " +CantLitros);
		

	}

}
