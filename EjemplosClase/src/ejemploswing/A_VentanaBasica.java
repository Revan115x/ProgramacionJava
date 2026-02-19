package ejemploswing;
import javax.swing.*;

public class A_VentanaBasica {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        
        JLabel etiqueta = new JLabel("Nombre:");
        JTextField campoTexto = new JTextField(15);
        JButton boton = new JButton("Aceptar");
        
        JPanel panel = new JPanel();
        panel.add(etiqueta);
        panel.add(campoTexto);
        panel.add(boton);

        ventana.add(panel);
        ventana.setVisible(true);

    }
}
