package ejercicio2;


public class App 
{ 
    
    public static double calcularDescuento(float precio, int edad){
        double total=0;
	if (edad<=18)
		total=precio*0.5;
	else if (edad>=18 && edad <=65)
		total=precio*0.2;
	else
		total=precio*0.4;
	return total;
    }


}
