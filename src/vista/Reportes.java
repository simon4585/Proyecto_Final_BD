package vista;

import javax.swing.*;
import java.awt.*;

public class Reportes extends JFrame {

    public Reportes() {

        // --- CONFIGURACIÓN GENERAL ---
        setTitle("Reportes");
        setSize(520, 420);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE); // Fondo blanco

        // Fuente para labels y botones
        Font fontLabels = new Font("Century Gothic", Font.BOLD, 18);
        Font fontBotones = new Font("Century Gothic", Font.BOLD, 20);

        // --- TÍTULO ---
        JLabel lbl = new JLabel("Módulo de Reportes");
        lbl.setFont(fontLabels);
        lbl.setBounds(150, 20, 250, 30);
        add(lbl);

        // --- LISTA DE REPORTES ---
        String[] reportes = {
                "Pedidos pendientes por entregar",
                "Pedidos por cliente",
                "Productos disponibles",
                "Listado de colegios",
                "Uniformes por colegio",
                "Total de productos vendidos por colegio",
                "Total de ventas"
        };

        JList<String> lista = new JList<>(reportes);
        lista.setFont(new Font("Century Gothic", Font.PLAIN, 16));

        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBounds(60, 70, 380, 220);
        add(scroll);

        // --- BOTÓN ---
        JButton btnGenerar = new JButton("Generar Reporte");
        btnGenerar.setBounds(160, 310, 200, 40);
        btnGenerar.setBackground(new Color(80, 150, 255));
        btnGenerar.setForeground(Color.WHITE);
        btnGenerar.setFocusPainted(false);
        btnGenerar.setFont(fontBotones);
        add(btnGenerar);

        setVisible(true);
    }
}
