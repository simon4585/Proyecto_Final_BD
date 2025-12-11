package vista;

import controladores.ProveedorControlador;
import modelo.Proveedor;

import javax.swing.*;
import java.awt.*;

public class CrudProveedores extends JFrame {

    private JTextField txtNit, txtNombre, txtDireccion, txtTelefono, txtContacto;
    private JButton btnGuardar, btnBuscar, btnActualizar, btnEliminar;

    private ProveedorControlador controlador = new ProveedorControlador();

    public CrudProveedores() {
        // --- CONFIGURACIÓN GENERAL ---
        setTitle("Gestión de Proveedores");
        setSize(640, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Fuentes y color
        Font fontLabels = new Font("Century Gothic", Font.BOLD, 18);
        Font fontBotones = new Font("Century Gothic", Font.BOLD, 18);
        Font fontCampos = new Font("Century Gothic", Font.PLAIN, 16);
        Color azul = new Color(80, 150, 255);

        // Panel principal con GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 18, 10, 18);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // fila 0 - NIT
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblNit = new JLabel("NIT:");
        lblNit.setFont(fontLabels);
        panel.add(lblNit, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtNit = new JTextField();
        txtNit.setFont(fontCampos);
        panel.add(txtNit, gbc);

        // fila 1 - Nombre
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(fontLabels);
        panel.add(lblNombre, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtNombre = new JTextField();
        txtNombre.setFont(fontCampos);
        panel.add(txtNombre, gbc);

        // fila 2 - Dirección
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(fontLabels);
        panel.add(lblDireccion, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtDireccion = new JTextField();
        txtDireccion.setFont(fontCampos);
        panel.add(txtDireccion, gbc);

        // fila 3 - Teléfono
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(fontLabels);
        panel.add(lblTelefono, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtTelefono = new JTextField();
        txtTelefono.setFont(fontCampos);
        panel.add(txtTelefono, gbc);

        // fila 4 - Nombre Contacto
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblContacto = new JLabel("Nombre Contacto:");
        lblContacto.setFont(fontLabels);
        panel.add(lblContacto, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtContacto = new JTextField();
        txtContacto.setFont(fontCampos);
        panel.add(txtContacto, gbc);

        // fila 5 - espacio vertical
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.weighty = 1;
        panel.add(Box.createVerticalGlue(), gbc);

        // fila 6 - botones
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel panelBtns = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 12));
        panelBtns.setBackground(Color.WHITE);

        // <-- botones con ancho reducido para que quepan en una sola fila -->
        int btnW = 110;
        int btnH = 50;

        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(fontBotones);
        btnGuardar.setBackground(azul);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setPreferredSize(new Dimension(btnW, btnH));
        panelBtns.add(btnGuardar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(fontBotones);
        btnBuscar.setBackground(azul);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setPreferredSize(new Dimension(btnW, btnH));
        panelBtns.add(btnBuscar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(fontBotones);
        btnActualizar.setBackground(azul);
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setPreferredSize(new Dimension(btnW + 20, btnH)); // actualizar puede ser un poco más ancho
        panelBtns.add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(fontBotones);
        btnEliminar.setBackground(azul);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setPreferredSize(new Dimension(btnW, btnH));
        panelBtns.add(btnEliminar);

        panel.add(panelBtns, gbc);

        // Wrapper con padding
        getContentPane().setLayout(new BorderLayout());
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(Color.WHITE);
        wrapper.setBorder(BorderFactory.createEmptyBorder(12, 18, 12, 18));
        wrapper.add(panel, BorderLayout.CENTER);
        getContentPane().add(wrapper, BorderLayout.CENTER);

        // ========== ACTIONS ==========

        // Buscar al presionar Enter en NIT
        txtNit.addActionListener(e -> buscarPorNit());

        // Botón Buscar
        btnBuscar.addActionListener(e -> buscarPorNit());

        // Guardar: si el NIT ya existe -> pedir usar Actualizar
        btnGuardar.addActionListener(e -> {
            String nit = txtNit.getText().trim();
            String nombre = txtNombre.getText().trim();

            if (nit.isEmpty() || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "NIT y Nombre son obligatorios.");
                return;
            }

            try {
                Proveedor existente = controlador.buscarProveedor(nit);
                if (existente != null) {
                    JOptionPane.showMessageDialog(this, "Ya existe proveedor con ese NIT. Use Actualizar para modificar.");
                    return;
                }

                Proveedor p = new Proveedor();
                p.setNit(nit);
                p.setNombre(txtNombre.getText().trim());
                p.setDireccion(txtDireccion.getText().trim());
                p.setTelefono(txtTelefono.getText().trim());
                p.setNombreContacto(txtContacto.getText().trim());

                boolean ok = controlador.insertarProveedor(p);
                JOptionPane.showMessageDialog(this, ok ? "Proveedor registrado correctamente." : "Error al registrar proveedor.");
                if (ok) limpiar();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage());
            }
        });

        // Actualizar: requiere que exista el NIT
        btnActualizar.addActionListener(e -> {
            String nit = txtNit.getText().trim();
            if (nit.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el NIT para actualizar.");
                return;
            }
            try {
                Proveedor existente = controlador.buscarProveedor(nit);
                if (existente == null) {
                    JOptionPane.showMessageDialog(this, "No existe proveedor con ese NIT. Use Guardar para crear uno nuevo.");
                    return;
                }

                Proveedor p = new Proveedor();
                p.setNit(nit);
                p.setNombre(txtNombre.getText().trim());
                p.setDireccion(txtDireccion.getText().trim());
                p.setTelefono(txtTelefono.getText().trim());
                p.setNombreContacto(txtContacto.getText().trim());

                boolean ok = controlador.actualizarProveedor(p);
                JOptionPane.showMessageDialog(this, ok ? "Proveedor actualizado correctamente." : "Error al actualizar proveedor.");
                if (ok) limpiar();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al actualizar: " + ex.getMessage());
            }
        });

        // Eliminar por NIT
        btnEliminar.addActionListener(e -> {
            String nit = txtNit.getText().trim();
            if (nit.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el NIT para eliminar.");
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar proveedor con NIT " + nit + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) return;

            try {
                boolean ok = controlador.eliminarProveedor(nit);
                JOptionPane.showMessageDialog(this, ok ? "Proveedor eliminado." : "No se pudo eliminar (verifique restricciones).");
                if (ok) limpiar();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + ex.getMessage());
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
        if (txtNit != null) txtNit.setText("");
        if (txtNombre != null) txtNombre.setText("");
        if (txtDireccion != null) txtDireccion.setText("");
        if (txtTelefono != null) txtTelefono.setText("");
        if (txtContacto != null) txtContacto.setText("");
    }
}
