package InterfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class interfaz {

    private JFrame ventana;
    private JTextField txtEntradas, txtDescuento;
    private JLabel lblResultado;
    private JComboBox<String> comboCiudades;
    private JRadioButton zonaPista, zonaGrada, zonaPalco;
    private JCheckBox checkPulsera;
    private ButtonGroup grupoZonas;

    public interfaz() {

        ventana = new JFrame("Gestión de Entradas");
        ventana.setSize(420, 450);
        ventana.setLayout(null);

        // Ciudad
        JLabel lblCiudad = new JLabel("Selecciona ciudad:");
        lblCiudad.setBounds(20, 20, 150, 30);
        ventana.add(lblCiudad);

        String[] ciudades = {"Madrid", "Bilbao", "Santander"};
        comboCiudades = new JComboBox<>(ciudades);
        comboCiudades.setBounds(180, 20, 180, 30);
        ventana.add(comboCiudades);

        // Número de entradas
        JLabel lblCantidad = new JLabel("Cantidad entradas:");
        lblCantidad.setBounds(20, 70, 150, 30);
        ventana.add(lblCantidad);

        txtEntradas = new JTextField();
        txtEntradas.setBounds(180, 70, 180, 30);
        ventana.add(txtEntradas);

        // Zona
        JLabel lblZona = new JLabel("Zona del evento:");
        lblZona.setBounds(20, 120, 150, 30);
        ventana.add(lblZona);

        zonaPista = new JRadioButton("Pista");
        zonaGrada = new JRadioButton("Grada");
        zonaPalco = new JRadioButton("Palco");

        zonaPista.setBounds(180, 120, 80, 30);
        zonaGrada.setBounds(260, 120, 80, 30);
        zonaPalco.setBounds(340, 120, 80, 30);

        grupoZonas = new ButtonGroup();
        grupoZonas.add(zonaPista);
        grupoZonas.add(zonaGrada);
        grupoZonas.add(zonaPalco);

        zonaPista.setSelected(true);

        ventana.add(zonaPista);
        ventana.add(zonaGrada);
        ventana.add(zonaPalco);

        // Código descuento
        JLabel lblCodigo = new JLabel("Código promocional:");
        lblCodigo.setBounds(20, 180, 150, 30);
        ventana.add(lblCodigo);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(180, 180, 180, 30);
        ventana.add(txtDescuento);

        // Pulsera
        checkPulsera = new JCheckBox("Añadir pulsera VIP (+5€)");
        checkPulsera.setBounds(20, 230, 250, 30);
        ventana.add(checkPulsera);

        // Botón calcular
        JButton btnCalcular = new JButton("Calcular total");
        btnCalcular.setBounds(20, 290, 340, 40);
        ventana.add(btnCalcular);

        // Resultado
        lblResultado = new JLabel("Importe final: 0 €");
        lblResultado.setBounds(20, 350, 300, 30);
        ventana.add(lblResultado);

        // Evento botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularImporte();
            }
        });

        ventana.setVisible(true);
    }

    private void calcularImporte() {

        try {

            String textoEntradas = txtEntradas.getText().trim();

            if (textoEntradas.isEmpty()) {
                JOptionPane.showMessageDialog(
                        ventana,
                        "Debes introducir una cantidad de entradas.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            int cantidad = Integer.parseInt(textoEntradas);

            if (cantidad < 1 || cantidad > 10) {
                JOptionPane.showMessageDialog(
                        ventana,
                        "Solo puedes comprar entre 1 y 10 entradas.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            String codigoPromo = txtDescuento.getText().trim();

            if (!codigoPromo.isEmpty()) {

                boolean formatoCorrecto =
                        codigoPromo.matches("^[A-Za-z]{3,4}[0-9]{1,3}$");

                if (!formatoCorrecto) {

                    JOptionPane.showMessageDialog(
                            ventana,
                            "Formato de código incorrecto.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
            }

            double precio = 0;

            String ciudadSeleccionada =
                    (String) comboCiudades.getSelectedItem();

            switch (ciudadSeleccionada) {

                case "Madrid":
                    precio = 30;
                    break;

                case "Bilbao":
                    precio = 28;
                    break;

                case "Santander":
                    precio = 32;
                    break;
            }

            // Incremento por zona
            if (zonaGrada.isSelected()) {
                precio *= 1.20;
            }

            if (zonaPalco.isSelected()) {
                precio *= 1.35;
            }

            double total = precio * cantidad;

            // Pulsera
            if (checkPulsera.isSelected()) {
                total += cantidad * 5;
            }

            lblResultado.setText(
                    String.format("Importe final: %.2f €", total)
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    ventana,
                    "Introduce un número válido.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new interfaz();
    }
}