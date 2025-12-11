package vista;

import controladores.PedidoControlador;
import modelo.Pedido;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CrudPedidos extends JFrame {

    private JTextField txtId, txtFechaPedido, txtFechaEntrega, txtAbono, txtMedidas, txtEstado, txtDni;

    private PedidoControlador controlador = new PedidoControlador(); // ← controlador

    public CrudPedidos() {

        setTitle("Gestión de Pedidos - Urban Stitch");
        setSize(730, 530);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font f = new Font("Century Gothic", Font.BOLD, 16);

        // ==============================
        // CAMPOS
        // ==============================

        JLabel lblId = new JLabel("ID Pedido:");
        lblId.setFont(f);
        gbc.gridx = 0; gbc.gridy = 0;
        add(lblId, gbc);

        txtId = new JTextField();
        txtId.setFont(f);
        gbc.gridx = 1;
        add(txtId, gbc);

        JLabel lblFechaPedido = new JLabel("Fecha Pedido (AAAA-MM-DD):");
        lblFechaPedido.setFont(f);
        gbc.gridx = 0; gbc.gridy = 1;
        add(lblFechaPedido, gbc);

        txtFechaPedido = new JTextField();
        txtFechaPedido.setFont(f);
        gbc.gridx = 1;
        add(txtFechaPedido, gbc);

        JLabel lblFechaEntrega = new JLabel("Fecha Entrega Estimada:");
        lblFechaEntrega.setFont(f);
        gbc.gridx = 0; gbc.gridy = 2;
        add(lblFechaEntrega, gbc);

        txtFechaEntrega = new JTextField();
        txtFechaEntrega.setFont(f);
        gbc.gridx = 1;
        add(txtFechaEntrega, gbc);

        JLabel lblAbono = new JLabel("Abono:");
        lblAbono.setFont(f);
        gbc.gridx = 0; gbc.gridy = 3;
        add(lblAbono, gbc);

        txtAbono = new JTextField();
        txtAbono.setFont(f);
        gbc.gridx = 1;
        add(txtAbono, gbc);

        JLabel lblMedidas = new JLabel("Medidas:");
        lblMedidas.setFont(f);
        gbc.gridx = 0; gbc.gridy = 4;
        add(lblMedidas, gbc);

        txtMedidas = new JTextField();
        txtMedidas.setFont(f);
        gbc.gridx = 1;
        add(txtMedidas, gbc);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setFont(f);
        gbc.gridx = 0; gbc.gridy = 5;
        add(lblEstado, gbc);

        txtEstado = new JTextField();
        txtEstado.setFont(f);
        gbc.gridx = 1;
        add(txtEstado, gbc);

        JLabel lblDni = new JLabel("DNI Cliente:");
        lblDni.setFont(f);
        gbc.gridx = 0; gbc.gridy = 6;
        add(lblDni, gbc);

        txtDni = new JTextField();
        txtDni.setFont(f);
        gbc.gridx = 1;
        add(txtDni, gbc);


        // ==============================
        // BOTONES
        // ==============================

        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1, 4, 10, 10));
        botones.setBackground(Color.WHITE);
        Color azul = new Color(80, 150, 255);

        Dimension btnSize = new Dimension(170, 44);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(azul);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(f);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setPreferredSize(btnSize);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(azul);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(f);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setPreferredSize(btnSize);

        JButton btnActualizar = new JButton("Actualizar Estado");
        btnActualizar.setBackground(azul);
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFont(f);
        btnActualizar.setFocusPainted(false);
        btnActualizar.setPreferredSize(btnSize);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(azul);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(f);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setPreferredSize(btnSize);

        botones.add(btnGuardar);
        botones.add(btnBuscar);
        botones.add(btnActualizar);
        botones.add(btnEliminar);

        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 2;
        add(botones, gbc);


        // ==============================
        // ACCIONES
        // ==============================

        // GUARDAR
        btnGuardar.addActionListener(e -> {
            try {

                Pedido p = new Pedido();
                p.setFechaPedido(LocalDate.parse(txtFechaPedido.getText()));
                p.setFechaEntregaEstimada(txtFechaEntrega.getText().isEmpty()
                        ? null
                        : LocalDate.parse(txtFechaEntrega.getText()));
                p.setAbono(new BigDecimal(txtAbono.getText()));
                p.setMedidas(txtMedidas.getText());
                p.setEstado(txtEstado.getText());
                p.setDniCliente(txtDni.getText());

                int idGen = controlador.insertarPedido(p);

                if (idGen > 0) {
                    JOptionPane.showMessageDialog(this, "Pedido registrado. ID generado: " + idGen);
                    txtId.setText(String.valueOf(idGen));
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar pedido.");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos: " + ex.getMessage());
            }
        });

        // BUSCAR
        btnBuscar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                Pedido p = controlador.buscarPedido(id);

                if (p != null) {
                    txtFechaPedido.setText(String.valueOf(p.getFechaPedido()));
                    txtFechaEntrega.setText(String.valueOf(p.getFechaEntregaEstimada()));
                    txtAbono.setText(String.valueOf(p.getAbono()));
                    txtMedidas.setText(p.getMedidas());
                    txtEstado.setText(p.getEstado());
                    txtDni.setText(p.getDniCliente());
                } else {
                    JOptionPane.showMessageDialog(this, "Pedido no encontrado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        });

        // ACTUALIZAR ESTADO
        btnActualizar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String estadoNuevo = txtEstado.getText();

                if (controlador.actualizarEstadoPedido(id, estadoNuevo)) {
                    JOptionPane.showMessageDialog(this, "Estado actualizado.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar.");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        });

        // ELIMINAR
        btnEliminar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());

                if (controlador.eliminarPedido(id)) {
                    JOptionPane.showMessageDialog(this, "Pedido eliminado.");

                    txtId.setText("");
                    txtFechaPedido.setText("");
                    txtFechaEntrega.setText("");
                    txtAbono.setText("");
                    txtMedidas.setText("");
                    txtEstado.setText("");
                    txtDni.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "No existe un pedido con ese ID.");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        });

        setVisible(true);
    }
}
