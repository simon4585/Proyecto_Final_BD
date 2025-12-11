package vista;

import controladores.ProveedorControlador;
import modelo.Proveedor;

import javax.swing.*;
import java.awt.*;

public class CrudProveedores extends JFrame {

    private JTextField txtNit, txtNombre, txtDireccion, txtTelefono, txtContacto;
    private JButton btnGuardar, btnBuscar;

    private ProveedorControlador controlador = new ProveedorControlador();

    public CrudProveedores() {

        // --- CONFIGURACIÓN GENERAL ---
        setTitle("Gestión de Proveedores");
        setSize(580, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        // Fuentes
        Font fontLabels = new Font("Century Gothic", Font.BOLD, 18);
        Font fontBotones = new Font("Century Gothic", Font.BOLD, 20);
        Font fontCampos = new Font("Century Gothic", Font.PLAIN, 16);

        // Tamaño uniforme para entrys
        int txtX = 200;
        int txtWidth = 320;
        int txtHeight = 28;

        // --- LABELS Y CAMPOS ---
        JLabel lblNit = new JLabel("NIT:");
        lblNit.setFont(fontLabels);
        lblNit.setBounds(30, 30, 160, 25);
        add(lblNit);

        txtNit = new JTextField();
        txtNit.setFont(fontCampos);
        txtNit.setBounds(txtX, 30, txtWidth, txtHeight);
        add(txtNit);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(fontLabels);
        lblNombre.setBounds(30, 70, 160, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setFont(fontCampos);
        txtNombre.setBounds(txtX, 70, txtWidth, txtHeight);
        add(txtNombre);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(fontLabels);
        lblDireccion.setBounds(30, 110, 160, 25);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setFont(fontCampos);
        txtDireccion.setBounds(txtX, 110, txtWidth, txtHeight);
        add(txtDireccion);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(fontLabels);
        lblTelefono.setBounds(30, 150, 160, 25);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setFont(fontCampos);
        txtTelefono.setBounds(txtX, 150, txtWidth, txtHeight);
        add(txtTelefono);

        JLabel lblContacto = new JLabel("Nombre Contacto:");
        lblContacto.setFont(fontLabels);
        lblContacto.setBounds(30, 190, 180, 25);
        add(lblContacto);

        txtContacto = new JTextField();
        txtContacto.setFont(fontCampos);
        txtContacto.setBounds(txtX, 190, txtWidth, txtHeight);
        add(txtContacto);

        // --- BOTONES ---
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(110, 260, 150, 40);
        btnGuardar.setBackground(new Color(80, 150, 255));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(fontBotones);
        btnGuardar.setFocusPainted(false);
        add(btnGuardar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(300, 260, 150, 40);
        btnBuscar.setBackground(new Color(80, 150, 255));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(fontBotones);
        btnBuscar.setFocusPainted(false);
        add(btnBuscar);

        // ========== ACTIONS ==========

        // Buscar al presionar Enter en NIT
        txtNit.addActionListener(e -> buscarPorNit());

        // Botón buscar
        btnBuscar.addActionListener(e -> buscarPorNit());

        // Guardar: si el NIT ya existe -> actualizar, si no -> insertar
        btnGuardar.addActionListener(e -> {
            String nit = txtNit.getText().trim();
            String nombre = txtNombre.getText().trim();
            String direccion = txtDireccion.getText().trim();
            String telefono = txtTelefono.getText().trim();
            String contacto = txtContacto.getText().trim();

            if (nit.isEmpty() || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "NIT y Nombre son obligatorios.");
                return;
            }

            try {
                Proveedor p = new Proveedor();
                p.setNit(nit);
                p.setNombre(nombre);
                p.setDireccion(direccion);
                p.setTelefono(telefono);
                p.setNombreContacto(contacto); // **usando el setter correcto**

                // verificar existencia
                Proveedor existente = controlador.buscarProveedor(nit);
                boolean ok;
                if (existente == null) {
                    ok = controlador.insertarProveedor(p);
                    if (ok) {
                        JOptionPane.showMessageDialog(this, "Proveedor registrado correctamente.");
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al registrar proveedor.");
                    }
                } else {
                    ok = controlador.actualizarProveedor(p);
                    if (ok) {
                        JOptionPane.showMessageDialog(this, "Proveedor actualizado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al actualizar proveedor.");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        setVisible(true);
    }

    private void buscarPorNit() {
        String nit = txtNit.getText().trim();
        if (nit.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un NIT para buscar.");
            return;
        }

        try {
            Proveedor p = controlador.buscarProveedor(nit);
            if (p != null) {
                txtNombre.setText(p.getNombre() != null ? p.getNombre() : "");
                txtDireccion.setText(p.getDireccion() != null ? p.getDireccion() : "");
                txtTelefono.setText(p.getTelefono() != null ? p.getTelefono() : "");
                // ahora usamos el getter correcto
                txtContacto.setText(p.getNombreContacto() != null ? p.getNombreContacto() : "");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró un proveedor con ese NIT.");
                limpiar();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar proveedor: " + ex.getMessage());
        }
    }

    private void limpiar() {
        txtNit.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtContacto.setText("");
    }

}
