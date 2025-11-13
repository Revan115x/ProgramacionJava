package Debbuger;

import java.io.*;
import java.util.Scanner;


/**
 *
 * @author Bego
 */
public class Debug2 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int num1,num2;
        int primero,ultimo;
         Scanner sc=new Scanner(System.in);
      
        do{
            System.out.println("\nAnota un número: ");
            num1=sc.nextInt();
            }while(num1<0);
          do{
            System.out.println("\nAnota un número: ");
            num2=sc.nextInt();
        }while(num2<0 && num1==num2);
          
        if (num1<num2){
            primero=num2;
            ultimo=num1;
        }
        else{
            primero=num1;
            ultimo=num2;
        }
        System.out.println("Los numeros son:");
        System.out.println(primero);
        while(primero!=num1){
            primero++;
            System.out.println(primero);
            }
        
    }

        
}
