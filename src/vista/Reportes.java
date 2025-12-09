package vista;

import javax.swing.*;

public class Reportes extends JFrame {

    public Reportes() {
        setTitle("Reportes");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lbl = new JLabel("Módulo de Reportes");
        lbl.setBounds(180, 20, 200, 25);
        add(lbl);

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
        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBounds(50, 60, 380, 200);
        add(scroll);

        JButton btnGenerar = new JButton("Generar Reporte");
        btnGenerar.setBounds(170, 290, 150, 30);
        add(btnGenerar);

        setVisible(true);
    }
}