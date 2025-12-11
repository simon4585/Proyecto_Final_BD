package vista;

import java.awt.*;
import javax.swing.*;
import utils.SessionManager;

public class Menu extends JFrame {

    public Menu() {

        setTitle("Menú Principal - Urban Stitch");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        setLayout(new GridBagLayout());

        JPanel contenedor = new JPanel();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        contenedor.setBackground(Color.WHITE);

        JLabel lblTitulo = new JLabel("MENÚ PRINCIPAL");
        lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 30));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitulo.setForeground(new Color(20, 20, 20));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        contenedor.add(lblTitulo);

        // Panel redondeado
        RoundedPanel panel = new RoundedPanel(40, Color.WHITE, new Color(80, 150, 255), 4);
        panel.setPreferredSize(new Dimension(650, 550));
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        contenedor.add(panel);

        add(contenedor);

        // -------- NUEVA LISTA DE BOTONES --------
        String[] nombres = {
                "Clientes", "Productos",
                "Pedidos", "Reportes",
                "Colegios", "Proveedores",
                "Materias Primas", "Uniformes",
                "Suministros", "Usuarios" // NUEVO
        };

        JButton[] botones = new JButton[nombres.length];

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 20, 15, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        int fila = 0, columna = 0;

        for (int i = 0; i < nombres.length; i++) {
            botones[i] = new JButton(nombres[i]);
            botones[i].setPreferredSize(new Dimension(230, 40));
            botones[i].setFont(new Font("Century Gothic", Font.BOLD, 20));
            botones[i].setBackground(new Color(80, 150, 255));
            botones[i].setForeground(Color.WHITE);

            gbc.gridx = columna;
            gbc.gridy = fila;
            panel.add(botones[i], gbc);

            columna++;
            if (columna > 1) { columna = 0; fila++; }
        }

        // -------- EVENTOS --------

        botones[0].addActionListener(e -> new CrudClientes());
        botones[1].addActionListener(e -> new CrudProductos());
        botones[2].addActionListener(e -> new CrudPedidos());
        botones[3].addActionListener(e -> new Reportes());
        botones[4].addActionListener(e -> new CrudColegios());
        botones[5].addActionListener(e -> validarPermisoAdmin(() -> new CrudProveedores()));
        botones[6].addActionListener(e -> validarPermisoAdmin(() -> new CrudMateriasPrimas()));
        botones[7].addActionListener(e -> new CrudUniformes());
        botones[8].addActionListener(e -> validarPermisoAdmin(() -> new CrudSuministros()));
        botones[9].addActionListener(e -> validarPermisoAdmin(() -> new CrudUsuarios())); // NUEVO

        setVisible(true);
    }

    // ================================  
    // MÉTODO PARA VALIDAR PERMISOS
    // ================================
    private void validarPermisoAdmin(Runnable accion) {
        if (!SessionManager.esAdmin()) {
            JOptionPane.showMessageDialog(this,
                    "No tienes permisos para acceder a este módulo.\nSolo Administradores.",
                    "Acceso Denegado",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        accion.run();
    }
}
