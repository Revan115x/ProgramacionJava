package basicos;

import javax.swing.*;  

public class AEjemploSwingEnMain {  
    public static void main(String[] args) {  
        JFrame frame = new JFrame(); // Creando instancia de JFrame
        JButton boton = new JButton("Haz clic"); // Creando un botón

        // Estableciendo posición y tamaño del botón
        boton.setBounds(130, 100, 100, 40);  

        // Añadiendo el botón al marco
        frame.add(boton);  

        // Configuración del JFrame
        frame.setSize(400, 500);  
        frame.setLayout(null);  
        frame.setVisible(true);  
    }  
}