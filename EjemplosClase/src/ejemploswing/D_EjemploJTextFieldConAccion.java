package ejemploswing;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;  

public class D_EjemploJTextFieldConAccion implements ActionListener {  
	JLabel etiqueta1, etiqueta2, etiqueta3; 
	JTextField tf1, tf2, tf3;  
    JButton botonSuma, botonResta;  
    JFrame frame;

    
    D_EjemploJTextFieldConAccion() {  
        frame = new JFrame("Ejemplo JTextField con ActionListener");  
          
        etiqueta1 = new JLabel("Numero1:");  
            
        tf1 = new JTextField(10);  
       
        etiqueta2 = new JLabel("Numero2:");    

        tf2 = new JTextField(10);  
       
        etiqueta3 = new JLabel("Resultado");
        
        tf3 = new JTextField(10);  
      
        tf3.setEditable(false);  // Campo no editable  

        botonSuma = new JButton("+");  
        
        botonResta = new JButton("-");  
         

        botonSuma.addActionListener(this);  
        botonResta.addActionListener(this);  

        frame.add(etiqueta1);  
       
        frame.add(tf1);  
        frame.add(etiqueta2); 
        frame.add(tf2); 
        frame.add(etiqueta3);
        frame.add(tf3);  
        frame.add(botonSuma);  
        frame.add(botonResta);  

        frame.setSize(200, 300);  
        //frame.setLayout(new GridLayout(4,2));  
        frame.setLayout(new FlowLayout());  
        frame.setVisible(true);  
    }  

    public void actionPerformed(ActionEvent e) {  
    	int num1=0, num2=0;
        String s1 = tf1.getText();  
        String s2 = tf2.getText();
        try {
        num1 = Integer.parseInt(s1);  
        num2 = Integer.parseInt(s2);  
        }catch(NumberFormatException ex) {
        	  JOptionPane.showMessageDialog(frame, "Error");
        }
        int resultado = 0;  

        if (e.getSource() == botonSuma) {  
            resultado = num1 + num2;  
        } else if (e.getSource() == botonResta) {  
            resultado = num1 - num2;  
        }  

        tf3.setText(String.valueOf(resultado));  
    }  

    public static void main(String[] args) {  
        new D_EjemploJTextFieldConAccion();  
    }  
}
