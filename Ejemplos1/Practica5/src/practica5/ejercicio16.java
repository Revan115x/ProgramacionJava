package practica5;

import java.util.Locale;
import java.util.Scanner;

/*
 * Una empresa que se dedica a la venta de desinfectantes necesita un programa
para gestionar las facturas. En cada factura figura: el código del artículo, la cantidad
vendida en litros y el precio por litro.
El programa pedirá los datos de 5 facturas introducidas y calculará y mostrará:
Facturación total
cantidad en litros vendidos del artículo 1
número de facturas que se emitieron de más de 600 €.
 */
public class ejercicio16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int codigo,cantidad,litros1=0,numFac=0,litrosPrimero,codigo1=0,litrosPrimerArticulo=0;
		double precioLitro,total=0,precioFactura;
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		for(int i=1;i<=5;i++) {
			System.out.println("Anota codigo:");
			codigo=sc.nextInt();
			System.out.println("Anota cantidad de litros:");
			cantidad=sc.nextInt();
			System.out.println("Anota precio litro:");
			precioLitro=sc.nextDouble();
			/*if (i==1)
				codigo1=codigo;
			if (codigo1==codigo)
				litrosPrimerArticulo+=cantidad;*/
				
			if (codigo==1)
				litros1+=cantidad;
			precioFactura=cantidad*precioLitro;
			if (precioFactura>600)
				numFac++;
			total=total+precioFactura;
		}
		
		System.out.println("Hay "+numFac+" facturas de más de 600 euros");
		System.out.println("Facturación total:"+total);
		System.out.println("Total litros codigo 1:"+litros1);
		System.out.println("El total de litros con el código del primer artículo son:"+litrosPrimerArticulo);
	}

}
