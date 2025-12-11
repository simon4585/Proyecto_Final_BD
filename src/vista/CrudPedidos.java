package vista;

import controladores.PedidoControlador;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.swing.*;
import modelo.Pedido;
import utils.SessionManager;

public class CrudPedidos extends JFrame {

    private JTextField txtId, txtFechaPedido, txtFechaEntrega, txtAbono, txtMedidas, txtEstado, txtDni;

    private PedidoControlador controlador = new PedidoControlador(); // ← controlador

    public CrudPedidos() {

        setTitle("Gestión de Pedidos - Urban Stitch");
        setSize(600, 500);
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
        Color azul = new Color(80, 150, 255);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(azul);
        btnGuardar.setFont(f);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(azul);
        btnGuardar.setFont(f);

        JButton btnActualizar = new JButton("Actualizar Estado");
        btnActualizar.setBackground(azul);
        btnGuardar.setFont(f);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(azul);
        btnGuardar.setFont(f);

        botones.add(btnGuardar);
        botones.add(btnBuscar);
        botones.add(btnActualizar);
        botones.add(btnEliminar);

        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 2;
        add(botones, gbc);

        // Deshabilitar botones para vendedores
        if (SessionManager.esVendedor()) {
            btnGuardar.setEnabled(false);
            btnActualizar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }


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
                    JOptionPane.showMessageDialog(null, "Pedido registrado. ID generado: " + idGen);
                    txtId.setText(String.valueOf(idGen));
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar pedido.");
                }

            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Datos inválidos: " + ex.getMessage());
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
                    JOptionPane.showMessageDialog(null, "Pedido no encontrado.");
                }
            } catch (HeadlessException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID inválido.");
            }
        });

        // ACTUALIZAR ESTADO
        btnActualizar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String estadoNuevo = txtEstado.getText();

                if (controlador.actualizarEstadoPedido(id, estadoNuevo)) {
                    JOptionPane.showMessageDialog(null, "Estado actualizado.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar.");
                }

            } catch (HeadlessException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID inválido.");
            }
        });

        // ELIMINAR
        btnEliminar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());

                if (controlador.eliminarPedido(id)) {
                    JOptionPane.showMessageDialog(null, "Pedido eliminado.");

                    txtFechaPedido.setText("");
                    txtFechaEntrega.setText("");
                    txtAbono.setText("");
                    txtMedidas.setText("");
                    txtEstado.setText("");
                    txtDni.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No existe un pedido con ese ID.");
                }

            } catch (HeadlessException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID inválido.");
            }
        });

        setVisible(true);
    }
}
