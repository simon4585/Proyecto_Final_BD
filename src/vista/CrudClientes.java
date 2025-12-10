package vista;

import javax.swing.*;
import java.awt.*;

public class CrudClientes extends JFrame {

    private JTextField txtDocumento, txtNombre, txtTelefono;

    public CrudClientes() {

        setTitle("Gestión de Clientes - Urban Stitch");
        setSize(500, 380);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font fuente = new Font("Century Gothic", Font.BOLD, 18);
        Font fuenteBoton = new Font("Century Gothic", Font.BOLD, 18);

        // =======================
        // Labels y Campos
        // =======================

        JLabel lblDoc = new JLabel("Documento:");
        lblDoc.setFont(fuente);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblDoc, gbc);

        txtDocumento = new JTextField();
        txtDocumento.setFont(fuente);
        txtDocumento.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        add(txtDocumento, gbc);


        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(fuente);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblNombre, gbc);

        txtNombre = new JTextField();
        txtNombre.setFont(fuente);
        txtNombre.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        add(txtNombre, gbc);


        JLabel lblTel = new JLabel("Teléfono:");
        lblTel.setFont(fuente);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblTel, gbc);

        txtTelefono = new JTextField();
        txtTelefono.setFont(fuente);
        txtTelefono.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        add(txtTelefono, gbc);

        // =======================
        // Botones
        // =======================

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(Color.WHITE);
        panelBotones.setLayout(new GridLayout(1, 3, 15, 0));

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(fuenteBoton);
        btnGuardar.setBackground(new Color(80, 150, 255));
        btnGuardar.setForeground(Color.WHITE);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(fuenteBoton);
        btnBuscar.setBackground(new Color(80, 150, 255));
        btnBuscar.setForeground(Color.WHITE);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(fuenteBoton);
        btnEliminar.setBackground(new Color(80, 150, 255));
        btnEliminar.setForeground(Color.WHITE);

        panelBotones.add(btnGuardar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnEliminar);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 20, 20);
        add(panelBotones, gbc);

        setVisible(true);
    }
}
