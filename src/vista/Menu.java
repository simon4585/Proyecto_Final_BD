package vista;

import javax.swing.*;

public class Menu extends JFrame {

    public Menu() {
        setTitle("Menú Principal");
        setSize(450, 450);
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

        JButton btnColegios = new JButton("Colegios");
        btnColegios.setBounds(140, 240, 160, 30);
        add(btnColegios);

        JButton btnProveedores = new JButton("Proveedores");
        btnProveedores.setBounds(140, 290, 160, 30);
        add(btnProveedores);

        JButton btnMaterias = new JButton("Materias Primas");
        btnMaterias.setBounds(140, 340, 160, 30);
        add(btnMaterias);



        btnClientes.addActionListener(e -> new CrudClientes());
        btnProductos.addActionListener(e -> new CrudProductos());
        btnPedidos.addActionListener(e -> new CrudPedidos());
        btnReportes.addActionListener(e -> new Reportes());
        btnColegios.addActionListener(e -> new CrudColegios());
        btnProveedores.addActionListener(e -> new CrudProveedores());
        btnMaterias.addActionListener(e -> new CrudMateriasPrimas());



        setVisible(true);


    }
}