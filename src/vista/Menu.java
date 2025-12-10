package vista;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    public Menu() {

        setTitle("Menú Principal - Urban Stitch");
        setExtendedState(JFrame.MAXIMIZED_BOTH);   // MAXIMIZADA
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        setLayout(new GridBagLayout()); // Centrar el panel redondeado


        JPanel contenedor = new JPanel();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        contenedor.setBackground(Color.WHITE);

        //titulo
        JLabel lblTitulo = new JLabel("MENÚ PRINCIPAL");
        lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 30));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitulo.setForeground(new Color(20, 20, 20));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));

        contenedor.add(lblTitulo);

        //panel
        RoundedPanel panel = new RoundedPanel(40, Color.WHITE, new Color(80, 150, 255), 4);
        panel.setPreferredSize(new Dimension(600, 500));
        panel.setLayout(new GridBagLayout()); // para organizar los botones en cuadrícula
        panel.setBackground(Color.WHITE);

        contenedor.add(panel);


        add(contenedor);


        //botones
        String[] nombres = {
                "Clientes", "Productos",
                "Pedidos", "Reportes",
                "Colegios", "Proveedores",
                "Materias Primas"
        };

        JButton[] botones = new JButton[nombres.length];

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 20, 15, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        int fila = 0;
        int columna = 0;

        for (int i = 0; i < nombres.length; i++) {
            botones[i] = new JButton(nombres[i]);
            botones[i].setPreferredSize(new Dimension(200, 40));
            botones[i].setFont(new Font("Century Gothic", Font.BOLD, 22));
            botones[i].setBackground(new Color(80, 150, 255));
            botones[i].setForeground(Color.WHITE);

            gbc.gridx = columna;
            gbc.gridy = fila;

            panel.add(botones[i], gbc);

            columna++;
            if (columna > 1) {
                columna = 0;
                fila++;
            }
        }

        botones[0].addActionListener(e -> new CrudClientes());
        botones[1].addActionListener(e -> new CrudProductos());
        botones[2].addActionListener(e -> new CrudPedidos());
        botones[3].addActionListener(e -> new Reportes());
        botones[4].addActionListener(e -> new CrudColegios());
        botones[5].addActionListener(e -> new CrudProveedores());
        botones[6].addActionListener(e -> new CrudMateriasPrimas());

        setVisible(true);
    }
}
