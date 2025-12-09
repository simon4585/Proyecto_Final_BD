package vista;

import javax.swing.*;

public class Menu extends JFrame {

    public Menu() {
        setTitle("Menú Principal");
        setSize(450, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton btnClientes = new JButton("Clientes");
        btnClientes.setBounds(140, 40, 160, 30);
        add(btnClientes);

        JButton btnProductos = new JButton("Productos");
        btnProductos.setBounds(140, 90, 160, 30);
        add(btnProductos);

        JButton btnPedidos = new JButton("Pedidos");
        btnPedidos.setBounds(140, 140, 160, 30);
        add(btnPedidos);

        JButton btnReportes = new JButton("Reportes");
        btnReportes.setBounds(140, 190, 160, 30);
        add(btnReportes);

        btnClientes.addActionListener(e -> new CrudClientes());
        btnProductos.addActionListener(e -> new CrudProductos());
        btnPedidos.addActionListener(e -> new CrudPedidos());
        btnReportes.addActionListener(e -> new Reportes());



        setVisible(true);


    }
}