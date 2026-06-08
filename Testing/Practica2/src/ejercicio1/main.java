package ejercicio1;


public class main
{
	/*Código java que dadas tres notas de un alumno nos calcula su media. Si alguna nota
no es correcta la media será igual a -1.*/
   
    public static boolean esValidaNota(int nota){
        if (nota<0 || nota>10)
            return false;
        return true;
    }

    public static double calcularMedia(int nota1,int nota2, int nota3){
        double media=-1;
        if (esValidaNota(nota1) || esValidaNota(nota2) && esValidaNota(nota3))
            media=nota1+nota2+nota3/3;
        return media;
    }


}
