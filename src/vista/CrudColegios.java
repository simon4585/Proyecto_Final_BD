package vista;

import controladores.ColegioControlador;
import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;
import modelo.Colegio;
import utils.SessionManager;

public class CrudColegios extends JFrame {

    private JTextField txtId, txtNombre, txtDireccion, txtTelefono;
    private ColegioControlador controlador = new ColegioControlador();

    public CrudColegios() {

        setTitle("Gestión de Colegios");
        setSize(540, 380);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        Font fontLabel = new Font("Century Gothic", Font.BOLD, 18);
        Font fontBtn = new Font("Century Gothic", Font.BOLD, 18);

        // ----------------- LABELS -----------------
        JLabel lblId = new JLabel("ID Colegio:");
        lblId.setFont(fontLabel);
        lblId.setBounds(30, 30, 150, 25);
        add(lblId);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(fontLabel);
        lblNombre.setBounds(30, 75, 150, 25);
        add(lblNombre);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(fontLabel);
        lblDireccion.setBounds(30, 120, 150, 25);
        add(lblDireccion);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(fontLabel);
        lblTelefono.setBounds(30, 165, 150, 25);
        add(lblTelefono);

        // ----------------- TEXTFIELDS -----------------
        txtId = new JTextField();
        txtId.setBounds(180, 30, 250, 28);
        add(txtId);

        txtNombre = new JTextField();
        txtNombre.setBounds(180, 75, 250, 28);
        add(txtNombre);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(180, 120, 250, 28);
        add(txtDireccion);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(180, 165, 250, 28);
        add(txtTelefono);

        // ----------------- BOTONES -----------------
        Color azul = new Color(80, 150, 255);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(20, 240, 110, 35);
        btnGuardar.setBackground(azul);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(fontBtn);
        add(btnGuardar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(140, 240, 110, 35);
        btnBuscar.setBackground(azul);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(fontBtn);
        add(btnBuscar);

        // ----------- NUEVO BOTÓN ACTUALIZAR -----------
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(260, 240, 125, 35);
        btnActualizar.setBackground(azul);
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFont(fontBtn);
        add(btnActualizar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(400, 240, 110, 35);
        btnEliminar.setBackground(azul);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(fontBtn);
        add(btnEliminar);

        // Deshabilitar botones de modificación para vendedores
        if (SessionManager.esVendedor()) {
            btnGuardar.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnActualizar.setEnabled(false);
        }

        // =======================
        // GUARDAR
        // =======================
        btnGuardar.addActionListener(e -> {
            String idText = txtId.getText().trim();
            String nombre = txtNombre.getText().trim();
            String direccion = txtDireccion.getText().trim();
            String telefono = txtTelefono.getText().trim();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre es obligatorio.");
                return;
            }

            // Si el usuario ingresó ID → se intenta actualizar
            if (!idText.isEmpty()) {
                try {
                    int id = Integer.parseInt(idText);
                    Colegio colegio = new Colegio(id, nombre, direccion, telefono);

                    if (controlador.actualizarColegio(colegio)) {
                        JOptionPane.showMessageDialog(this, "Colegio actualizado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo actualizar el colegio.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "El ID debe ser un número.");
                }
            } else {
                // Insertar nuevo
                Colegio colegio = new Colegio(0, nombre, direccion, telefono);

                if (controlador.insertarColegio(colegio)) {
                    JOptionPane.showMessageDialog(this, "Colegio guardado correctamente.");
                    txtId.setText("");
                    txtNombre.setText("");
                    txtDireccion.setText("");
                    txtTelefono.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar colegio.");
                }
            }
        });

        // =======================
        // BUSCAR
        // =======================
        btnBuscar.addActionListener(e -> {
            String idText = txtId.getText().trim();

            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el ID a buscar.");
                return;
            }

            try {
                int id = Integer.parseInt(idText);
                Colegio c = controlador.buscarColegio(id);

                if (c != null) {
                    txtNombre.setText(c.getNombre());
                    txtDireccion.setText(c.getDireccion());
                    txtTelefono.setText(c.getTelefono());
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró un colegio con ese ID.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error BD: " + ex.getMessage());
            }
        });

        // =======================
        // ACTUALIZAR
        // =======================
        btnActualizar.addActionListener(e -> {
            String idText = txtId.getText().trim();
            String nombre = txtNombre.getText().trim();
            String direccion = txtDireccion.getText().trim();
            String telefono = txtTelefono.getText().trim();

            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un ID para actualizar.");
                return;
            }

            try {
                int id = Integer.parseInt(idText);
                Colegio c = new Colegio(id, nombre, direccion, telefono);

                boolean ok = controlador.actualizarColegio(c);

                if (ok) {
                    JOptionPane.showMessageDialog(this, "Colegio actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar el colegio.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        });

        // =======================
        // ELIMINAR
        // =======================
        btnEliminar.addActionListener(e -> {
            String idText = txtId.getText().trim();

            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el ID a eliminar.");
                return;
            }

            try {
                int id = Integer.parseInt(idText);

                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "¿Seguro que deseas eliminar el colegio?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm != JOptionPane.YES_OPTION) return;

                if (controlador.eliminarColegio(id)) {
                    JOptionPane.showMessageDialog(this, "Colegio eliminado.");
                    txtId.setText("");
                    txtNombre.setText("");
                    txtDireccion.setText("");
                    txtTelefono.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "No existe un colegio con ese ID.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error BD: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}
