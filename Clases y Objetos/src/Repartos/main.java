package Repartos;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Un repartidor está identificado de forma única por un número. Por cada pedido
		realizado gana el 20% del importe de dicho pedido más propinas. Codificar un
		método: realizar_pedido, otro que nos informe del número total de pedidos
		realizados por todos los repartidores y otro que nos muestre las ganancias de un
		repartidor hasta el momento.*/
		
		
		Repartidor r1=new Repartidor();
		Repartidor r2=new Repartidor();
	
		r1.hacerpedido(30, 2);
		r2.hacerpedido(40, 8);
		r2.hacerpedido(40, 8);
		
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		
		System.out.println("Total pedidos de todos los repartidores 0"+Repartidor.getTotalPedidos());
		
	}

}
