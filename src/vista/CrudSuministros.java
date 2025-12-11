package vista;

import controladores.SuministroControlador;
import java.awt.*;
import javax.swing.*;
import modelo.Suministro;
import utils.SessionManager;

public class CrudSuministros extends JFrame {

    private JTextField txtId, txtNitProveedor, txtCodigoMateria, txtCantidad;
    private JTextArea txtObservaciones;
    private JButton btnGuardar, btnBuscar, btnEliminar;

    private SuministroControlador controlador = new SuministroControlador();

    public CrudSuministros() {
        setTitle("Registro de Suministros");
        setSize(620, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        Font fontLabel = new Font("Century Gothic", Font.BOLD, 16);
        Font fontField = new Font("Century Gothic", Font.PLAIN, 15);
        Font fontBtn = new Font("Century Gothic", Font.BOLD, 16);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 12, 8, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        // ID Suministro
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;
        JLabel lblId = new JLabel("ID Suministro:");
        lblId.setFont(fontLabel);
        panel.add(lblId, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtId = new JTextField();
        txtId.setFont(fontField);
        panel.add(txtId, gbc);

        // NIT Proveedor
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblNit = new JLabel("NIT Proveedor:");
        lblNit.setFont(fontLabel);
        panel.add(lblNit, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtNitProveedor = new JTextField();
        txtNitProveedor.setFont(fontField);
        panel.add(txtNitProveedor, gbc);

        // Código Materia Prima
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblCodigo = new JLabel("Código Materia Prima:");
        lblCodigo.setFont(fontLabel);
        panel.add(lblCodigo, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtCodigoMateria = new JTextField();
        txtCodigoMateria.setFont(fontField);
        panel.add(txtCodigoMateria, gbc);

        // Reset constraints para botones
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0;

        // Botones centrados
        JPanel panelBtns = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 6));
        panelBtns.setBackground(Color.WHITE);

        Color azul = new Color(80, 150, 255);
        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(fontBtn);
        btnGuardar.setBackground(azul);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setPreferredSize(new Dimension(140, 40));

        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(fontBtn);
        btnBuscar.setBackground(azul);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setPreferredSize(new Dimension(140, 40));

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(fontBtn);
        btnEliminar.setBackground(azul);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setPreferredSize(new Dimension(140, 40));

        panelBtns.add(btnGuardar);
        panelBtns.add(btnBuscar);
        panelBtns.add(btnEliminar);

        panel.add(panelBtns, gbc);

        // wrapper con padding
        getContentPane().setLayout(new BorderLayout());
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(Color.WHITE);
        wrapper.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        wrapper.add(panel, BorderLayout.CENTER);
        getContentPane().add(wrapper, BorderLayout.CENTER);

        // acciones

        // GUARDAR
        btnGuardar.addActionListener(e -> {
            try {
                String nit = txtNitProveedor.getText().trim();
                String codigoTxt = txtCodigoMateria.getText().trim();

                if (nit.isEmpty() || codigoTxt.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "NIT y Código de materia prima son obligatorios.");
                    return;
                }

                int codigo = Integer.parseInt(codigoTxt);

                Suministro s = new Suministro();
                s.setNit(nit);
                s.setCodigo(codigo);


                String idTxt = txtId.getText().trim();
                if (!idTxt.isEmpty()) {
                    try {
                        s.setIdSuministro(Integer.parseInt(idTxt));
                    } catch (NumberFormatException ex) {
                        // ignoramos, no es obligatorio
                    }
                }


                boolean ok = controlador.insertarSuministro(s);
                if (ok) {
                    JOptionPane.showMessageDialog(this, "Suministro registrado correctamente.");

                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo registrar el suministro.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Código inválido.");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // BUSCAR por ID
        btnBuscar.addActionListener(e -> {
            String idText = txtId.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el ID del suministro a buscar.");
                return;
            }
            try {
                int id = Integer.parseInt(idText);
                Suministro s = controlador.buscarSuministro(id);
                if (s != null) {
                    txtNitProveedor.setText(s.getNit() != null ? s.getNit() : "");
                    txtCodigoMateria.setText(s.getCodigo() != null ? String.valueOf(s.getCodigo()) : "");

                } else {
                    JOptionPane.showMessageDialog(this, "No existe un suministro con ese ID.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al buscar: " + ex.getMessage());
            }
        });

        // ELIMINAR por ID (usa eliminarSuministro)
        btnEliminar.addActionListener(e -> {
            String idText = txtId.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el ID del suministro a eliminar.");
                return;
            }
            try {
                int id = Integer.parseInt(idText);
                int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar suministro con ID " + id + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) return;

                boolean ok = controlador.eliminarSuministro(id);
                if (ok) {
                    JOptionPane.showMessageDialog(this, "Suministro eliminado.");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar (verifica existencia o restricciones).");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + ex.getMessage());
            }
        });

        // Deshabilitar botones de modificación para vendedores
        if (SessionManager.esVendedor()) {
            btnEliminar.setEnabled(false);
        }

        setVisible(true);
    }

    private void limpiar() {
        if (txtId != null) txtId.setText("");
        if (txtNitProveedor != null) txtNitProveedor.setText("");
        if (txtCodigoMateria != null) txtCodigoMateria.setText("");
        if (txtCantidad != null) txtCantidad.setText("");
        if (txtObservaciones != null) txtObservaciones.setText("");
    }


}
