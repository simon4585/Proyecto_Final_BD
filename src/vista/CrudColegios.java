package vista;

import controladores.ColegioControlador;
import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;
import modelo.Colegio;
import utils.SessionManager;



public class CrudColegios extends JFrame {

    private JTextField txtId, txtNombre, txtDireccion, txtTelefono;

    private ColegioControlador controlador = new ColegioControlador(); // controlador
    public CrudColegios() {

        setTitle("Gestión de Colegios");
        setSize(520, 380);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE); // Fondo blanco

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

        // ----------------- TEXTFIELDS (alineados) -----------------
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
        btnGuardar.setBounds(40, 240, 130, 35);
        btnGuardar.setBackground(azul);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(fontBtn);
        add(btnGuardar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(190, 240, 130, 35);
        btnBuscar.setBackground(azul);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(fontBtn);
        add(btnBuscar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(340, 240, 130, 35);
        btnEliminar.setBackground(azul);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(fontBtn);
        add(btnEliminar);

        // =======================
        // ACCIONES
        // =======================

        // GUARDAR (INSERT or UPDATE if ID provided)
        btnGuardar.addActionListener(e -> {
            String idText = txtId.getText().trim();
                String nombre = txtNombre.getText().trim();
                String direccion = txtDireccion.getText().trim();
                String telefono = txtTelefono.getText().trim();
                // justo antes de: boolean ok = controlador.insertarColegio(colegio);
                System.out.println("DBG VIEW -> insertarColegio llamado con:");
                System.out.println("  nombre  : '" + nombre + "' (len=" + nombre.length() + ")");
                System.out.println("  direccion: '" + direccion + "' (len=" + direccion.length() + ")");
                System.out.println("  telefono: '" + telefono + "' (len=" + telefono.length() + ")");


                if (nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(CrudColegios.this, "El nombre del colegio es obligatorio.", "Validación", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Si hay ID, intentamos actualizar; si no, insertar
                if (!idText.isEmpty()) {
                    int id;
                    try {
                        id = Integer.parseInt(idText);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(CrudColegios.this, "ID debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Colegio colegio = new Colegio(id, nombre, direccion, telefono);
                    boolean ok = controlador.actualizarColegio(colegio);
                    if (ok) {
                        JOptionPane.showMessageDialog(CrudColegios.this, "Colegio actualizado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(CrudColegios.this, "No se pudo actualizar el colegio (revise la BD).");
                    }

                } else {
                    // Insertar nuevo colegio (ID serial se genera en BD)
                    Colegio colegio = new Colegio(0, nombre, direccion, telefono); // id temporal 0
                    boolean ok = controlador.insertarColegio(colegio);
                    if (ok) {
                        JOptionPane.showMessageDialog(CrudColegios.this, "Colegio guardado correctamente.");
                        // opcional: limpiar campos o actualizar lista
                        txtId.setText("");
                        txtNombre.setText("");
                        txtDireccion.setText("");
                        txtTelefono.setText("");
                    } else {
                        JOptionPane.showMessageDialog(CrudColegios.this, "Error guardando colegio.");
                    }
                }
        });

        // BUSCAR por ID
        btnBuscar.addActionListener(e -> {
            String idText = txtId.getText().trim();
                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(CrudColegios.this, "Ingrese el ID del colegio a buscar.", "Validación", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int id;
                try {
                    id = Integer.parseInt(idText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CrudColegios.this, "ID debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Colegio c = controlador.buscarColegio(id);
                    if (c != null) {
                        txtNombre.setText(c.getNombre());
                        txtDireccion.setText(c.getDireccion());
                        txtTelefono.setText(c.getTelefono());
                    } else {
                        JOptionPane.showMessageDialog(CrudColegios.this, "No se encontró un colegio con ese ID.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(CrudColegios.this, "Error al buscar colegio: " + ex.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
                }
        });

        // ELIMINAR por ID
        btnEliminar.addActionListener(e -> {
            String idText = txtId.getText().trim();
                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(CrudColegios.this, "Ingrese el ID del colegio a eliminar.", "Validación", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int id;
                try {
                    id = Integer.parseInt(idText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CrudColegios.this, "ID debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(CrudColegios.this, "¿Eliminar colegio con ID " + id + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) return;

                try {
                    boolean ok = controlador.eliminarColegio(id);
                    if (ok) {
                        JOptionPane.showMessageDialog(CrudColegios.this, "Colegio eliminado correctamente.");
                        txtId.setText("");
                        txtNombre.setText("");
                        txtDireccion.setText("");
                        txtTelefono.setText("");
                    } else {
                        JOptionPane.showMessageDialog(CrudColegios.this, "No se pudo eliminar (verificar existencia o restricciones).");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(CrudColegios.this, "Error al eliminar colegio: " + ex.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
                }
        });

        // Deshabilitar botones para vendedores
        if (SessionManager.esVendedor()) {
            btnGuardar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }

        setVisible(true);
    }
}
