/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HERENCIAanimales;

public class Herbivoro extends Animal {
    private String tipoHierba;
    
public Herbivoro(String n,int e,String tH)    {
    super(n,e);
    tipoHierba=tH;
}

    public String getTipoH() {
        return tipoHierba;
    }

    public void setTipoH(String tipoH) {
        this.tipoHierba = tipoH;
    }
    @Override
 public String toString(){
       // String cadena=super.toString();
       // return cadena + "\nKg. Carne: "+ KgCarne;
        return "Herb�voro:" + super.toString() + "\nTipo hierba: "+ tipoHierba ;
    }
}
