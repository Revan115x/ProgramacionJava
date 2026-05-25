package InterfazGrafica;

import java.awt.event.*;  
import javax.swing.*;


public class main {
    JFrame frame;
    JTextField entradas, codigo;
    JButton botonSuma, botonResta;
    JLabel l1, nciudad, Nentradas, lblTipo, lblCodigo, lblResultado;
    ButtonGroup grupoTipo;
    JCheckBox pulsera;
    JButton botonCalcular;  
    JRadioButton r1, r2, r3;
    JComboBox<String> comboBoxCiudades;
    main() {
        final JLabel label = new JLabel();

        frame = new JFrame("Venta de Entradas");
        frame.setSize(650, 500);
        frame.setLayout(null);

        nciudad = new JLabel("Ciudad:");
        nciudad.setBounds(30, 30, 100, 30);
        frame.add(nciudad);

        String[] ciu = {"Santander", "Bilbao","Madrid"};
        comboBoxCiudades = new JComboBox<>(ciu);
        comboBoxCiudades.setBounds(180, 30, 150, 30);
        frame.add(comboBoxCiudades);

        Nentradas = new JLabel("Numero Entradas:");
        Nentradas.setBounds(30, 80, 100, 30);
        frame.add(Nentradas);

        entradas = new JTextField();
        entradas.setBounds(180, 80, 150, 30);
        frame.add(entradas);

        lblTipo = new JLabel("Tipo de zona:");
        lblTipo.setBounds(30, 130, 100, 30);
        frame.add(lblTipo);

        r1 = new JRadioButton("A) Pista");
        r2 = new JRadioButton("B) Grada");
        r3 = new JRadioButton("C) Palco");
        
        r1.setBounds(180, 130, 120, 30);
        r2.setBounds(250, 130, 120, 30);
        r3.setBounds(320, 130, 120, 30);

        grupoTipo = new ButtonGroup();
        grupoTipo.add(r1);
        grupoTipo.add(r2);
        grupoTipo.add(r3);
        r1.setSelected(true);

        frame.add(r1);
        frame.add(r2);
        frame.add(r3);
        
        lblCodigo = new JLabel("Código Descuento:");
        lblCodigo.setBounds(30, 190, 130, 30);
        frame.add(lblCodigo);

        codigo = new JTextField();
        codigo.setBounds(180, 190, 150, 30);
        frame.add(codigo);
         
         pulsera = new JCheckBox("¿Desea pulsera conmemorativa? (+5€)");    
         pulsera.setBounds(30, 240, 300, 30);  
         frame.add(pulsera); 
         
         botonCalcular = new JButton("Calcular Precio");
         botonCalcular.setBounds(30, 300, 370, 40);
         frame.add(botonCalcular);
        
         lblResultado = new JLabel("Total a pagar: 0.00 €");
         lblResultado.setBounds(30, 360, 370, 40);
         frame.add(lblResultado);
            
            botonCalcular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    calcularPrecio();
                }
            });
            frame.setVisible(true);  
    }
     private void calcularPrecio() {
            try {
                String entradasTexto = entradas.getText().trim();
                if (entradasTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, introduce el número de entradas.", "Error de datos", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int numEntradas = Integer.parseInt(entradas.getText().trim());
                if (numEntradas < 1 || numEntradas>10) {
                    return;
                }
                String codDescuento = codigo.getText().trim();
                if (!codDescuento.isEmpty()) {
                    if (!codDescuento.matches("^[a-zA-Z]{3,4}[0-9]{1,3}$")) {
                        JOptionPane.showMessageDialog(frame, "Código inválido.\nDebe tener 3 o 4 letras seguidas de 1, 2 o 3 números.", "Error de formato", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                double precioBase = 0;
                 
                String ciudad = (String) comboBoxCiudades.getSelectedItem();
                if (ciudad.equals("Madrid")) {
                    precioBase = 30; 
                }
                else if (ciudad.equals("Santander")) {
                    precioBase = 32 ; 
                }
                else if (ciudad.equals("Bilbao")) {
                    precioBase = 28; 
                }
                   
                 if (r2.isSelected()) precioBase = precioBase*1.2;  
                else if (r3.isSelected()) precioBase = precioBase*1.35;
                double total = precioBase * numEntradas;

             
                if (pulsera.isSelected()) {
                    total += (5.0 * numEntradas);
                }               

                String resultadoTexto= String.format("Total a pagar:"+ total);
                lblResultado.setText(resultadoTexto);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, introduce un número entero en las entradas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }


    public static void main(String[] args) {
        new main();
    }
}