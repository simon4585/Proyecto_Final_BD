package vista;

import controladores.ClienteControlador;
import modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrudClientes extends JFrame {

    private JTextField txtDocumento, txtNombre, txtTelefono;
    private ClienteControlador controlador = new ClienteControlador(); // ← CONTROLADOR

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

        // =======================
        // ACCIONES
        // =======================

        // GUARDAR
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String dni = txtDocumento.getText();
                String nombre = txtNombre.getText();
                String tel = txtTelefono.getText();

                if (dni.isEmpty() || nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Documento y Nombre son obligatorios.");
                    return;
                }

                Cliente c = new Cliente(dni, nombre, tel);

                if (controlador.insertarCliente(c)) {
                    JOptionPane.showMessageDialog(null, "Cliente registrado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar cliente.");
                }
            }
        });

        // BUSCAR
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String dni = txtDocumento.getText();

                if (dni.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa un documento para buscar.");
                    return;
                }

                Cliente c = controlador.buscarCliente(dni);

                if (c != null) {
                    txtNombre.setText(c.getNombre());
                    txtTelefono.setText(c.getTelefono());
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                }
            }
        });

        // ELIMINAR
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String dni = txtDocumento.getText();

                if (dni.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa un documento para eliminar.");
                    return;
                }

                try {
                    if (controlador.eliminarCliente(dni)) {
                        JOptionPane.showMessageDialog(null, "Cliente eliminado.");
                        txtNombre.setText("");
                        txtTelefono.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe un cliente con ese documento.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }
}
