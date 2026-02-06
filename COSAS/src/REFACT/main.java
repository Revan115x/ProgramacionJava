package REFACT;

import REFACT.Class.Producto;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Producto[] Producto = new Producto[3];
		Producto[0] = new Producto("Laptop", 1000);
		Producto[1] = new Producto("Smartphone", 500);
		Producto[2] = new Producto("Tablet", 300);
		

	}

	public class GestorFacturas {
		public static final double IVA = 0.21;

		public void imprimirFactura(String cliente, String[] items, double[] precios, int tipoCliente) {
			double total = 0;
			System.out.println("FACTURA PARA: " + cliente.toUpperCase());

			for (int i = 0; i < items.length; i++) {
				double precioFinal = precios[i];

				precioFinal = calcularPrecioConDescuento(precios, tipoCliente, i, precioFinal);

				System.out.println("- " + items[i] + ": " + precioFinal);
				total += precioFinal;
			}

			double impuesto = total * GestorFacturas.IVA;
			System.out.println("Impuesto (21%): " + impuesto);
			System.out.println("TOTAL: " + (total + impuesto));
		}

		private double calcularPrecioConDescuento(double[] precios, int tipoCliente, int i, double precioFinal) {
			if (tipoCliente == 1) { // Cliente VIP
				precioFinal = precios[i] * 0.90;
			} else if (tipoCliente == 2) { // Cliente Empresa
				precioFinal = precios[i] * 0.95;
			}
			return precioFinal;
		}
	}

}
