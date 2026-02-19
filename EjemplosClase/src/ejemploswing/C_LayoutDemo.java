package ejemploswing;

import javax.swing.*;
import java.awt.*;

public class C_LayoutDemo extends JFrame {

    public C_LayoutDemo() {
        setTitle("Demostración de Layouts");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 3)); // 3 columnas: FlowLayout, BorderLayout, GridLayout

        // Panel con FlowLayout
        JPanel flowPanel = new JPanel(new FlowLayout());
        flowPanel.setBorder(BorderFactory.createTitledBorder("FlowLayout"));
        flowPanel.add(new JButton("1"));
        flowPanel.add(new JButton("2"));
        flowPanel.add(new JButton("3"));

        // Panel con BorderLayout
        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.setBorder(BorderFactory.createTitledBorder("BorderLayout"));
        borderPanel.add(new JButton("Norte"), BorderLayout.NORTH);
        borderPanel.add(new JButton("Sur"), BorderLayout.SOUTH);
        borderPanel.add(new JButton("Este"), BorderLayout.EAST);
        borderPanel.add(new JButton("Oeste"), BorderLayout.WEST);
        borderPanel.add(new JButton("Centro"), BorderLayout.CENTER);

        // Panel con GridLayout
        JPanel gridPanel = new JPanel(new GridLayout(2, 2));
        gridPanel.setBorder(BorderFactory.createTitledBorder("GridLayout (2x2)"));
        gridPanel.add(new JButton("A"));
        gridPanel.add(new JButton("B"));
        gridPanel.add(new JButton("C"));
        gridPanel.add(new JButton("D"));

        // Añadir los 3 paneles al JFrame
        add(flowPanel);
        add(borderPanel);
        add(gridPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new C_LayoutDemo().setVisible(true));
    }
}