package modelos;
public class Cliente {

    protected String dni;
    protected String nombre;
    protected String telefono;
    protected String direccion;
    protected int visitas;

    public Cliente(String dni, String nombre, String telefono,
                   String direccion, int visitas) {

        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.visitas = visitas;
    }

    // método para calcular pago
    public double calcularPago(double importe) {
        return importe;
    }

    // getters y setters
}
