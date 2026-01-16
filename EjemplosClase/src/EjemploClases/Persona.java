/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploClases;


public class Persona {
    private String nif;
    private int edad,numHijos;
    private char sexo;
    private boolean casado;
    private static int numeroPersonas,numBodas; //tienen acceso todos los objetos pero solo se usa una vez
    
    
    public Persona() {
        numeroPersonas++;
    }
    public Persona(char s){
        nif="";
        edad=0;
        numHijos=0;
        casado=false;
        sexo=s;
        numeroPersonas++;
    }
    
    public Persona(String nif, int edad, int numHijos, char sexo, boolean casado) {
        this.nif = nif;
        this.edad = edad;
        this.numHijos = numHijos;
        this.sexo = sexo;
        this.casado = casado;
        numeroPersonas++;
    }
    
    //Aqui se usa this, porque al poner entre patentesis el mismo nombre que las variables
    //necesitas especificar cual es el que quieres como parametro y dato

    public Persona(char s, String n, int e, int nh, boolean c){
      nif=n;
      edad=e;
      numHijos=nh;
      sexo=s;
      casado=c;
      numeroPersonas++;
    }
    
    public void cumplirAnyos(){
        edad++;
    }
    
    public boolean casarse(){
        if (casado)
            return false;
        else{
            casado=true;
            numBodas++;
            return true;
        }
    }
            
    public void tenerHijos(int nh){
        numHijos=numHijos+nh;
    }

    @Override
    public String toString() {
        return "Persona{" + "nif=" + nif + ", edad=" + edad + ", numHijos=" + numHijos + ", sexo=" + sexo + ", casado=" + casado + '}';
    }

    public String getNif() {
        return nif;
    }

    public int getEdad() {
        return edad;
    }

    public char getSexo() {
        return sexo;
    }
    public static int getNumeroPersonas() {
        return numeroPersonas;
    }
    public static void setNumeroPersonas(int numeroPersonas) {
        Persona.numeroPersonas = numeroPersonas;
    }
    //UN METODO QUE SOLO USA VARIABLES ESTATICAS SOLO USA METODOS ESTATICOS
    public static int getNumBodas() {
        return numBodas;
    }
    public static void setNumBodas(int numBodas) {
        Persona.numBodas = numBodas;
    }
    
}