package ejercicio3;

public class App {
	
	 public static boolean validarNumero(int numero){
	        if (numero<10 || numero>9999)
	            return false;
	        return true;
	    }


	   public static int numeroCifras(int numero){
	    int cifras=0;
	    do{
	        cifras++;
	        numero=numero/10;
	    }while(numero!=0);
	    return cifras-1;
	   }

	   public static int invertirNumero(int numero){
	    int numeroInvertido=0,resto;
	    if (!validarNumero(numero))
	    	return -1;
	    int cifras=numeroCifras(numero)-1;
	    while(numero!=0){
	        resto=numero%10;
	        numeroInvertido+=resto*Math.pow(10, cifras);
	        numero=numero/10;
	        cifras--;
	    }   
	    return numeroInvertido;
	   }
}
