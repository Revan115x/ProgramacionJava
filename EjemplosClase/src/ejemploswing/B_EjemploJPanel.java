package ejemploswing;

import java.awt.Color;

import javax.swing.*;  

public class B_EjemploJPanel {  
    B_EjemploJPanel() {  
        // Crear el marco principal
        JFrame frame = new JFrame("Ejemplo de JPanel");    

        // Crear el panel
        JPanel panel = new JPanel();  
        panel.setBounds(40, 80, 200, 200);    
        panel.setBackground(Color.LIGHT_GRAY);  

        // Crear y añadir botones al panel
        JButton boton1 = new JButton("Botón 1");     
        boton1.setBackground(Color.YELLOW);   

        JButton boton2 = new JButton("Botón 2");   
        boton2.setBackground(Color.GREEN);   

        panel.add(boton1);  
        panel.add(boton2);  

        // Añadir el panel al marco
        frame.add(panel);  

        // Configurar el marco
        frame.setSize(400, 400);    
        frame.setLayout(null);    
        frame.setVisible(true);    
    }  

    public static void main(String args[]) {  
        new B_EjemploJPanel();  
    }  
}