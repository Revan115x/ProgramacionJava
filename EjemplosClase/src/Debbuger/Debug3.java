package Debbuger;

import java.util.Scanner;

/**
 *
 * @author Bego
 */

public class Debug3 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    static Scanner sc;
    
    public static void main(String[] args)  {
        // TODO code application logic here
        int num,cont;
        cont = 1;
        char seguir;
        sc=new Scanner(System.in);
      
        
        do{
           
            num=leer();
            while(cont<=10){
               
               mostrar(cont,num);
            }
            
            System.out.println("Quieres otra tabla?");
            sc.nextLine(); //Limpio buffer
            seguir=sc.nextLine().charAt(0);
          
            
        }while(seguir=='s' || seguir=='S');
    } 

    public static void mostrar(int c,int n){
        int m=c*n;
        System.out.println(n+" x "+c+" = "+m);
    }
    public static int leer(){
        int num;
         do{
            System.out.println("\nAnota un número");
            num=sc.nextInt();
        }while(num<1 && num>10);
        return num;
    }
    
}
