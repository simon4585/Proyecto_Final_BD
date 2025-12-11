package vista;

import controladores.UsuarioControlador;
import java.awt.*;
import javax.swing.*;
import modelo.Usuario;
import utils.SessionManager;

public class CrudUsuarios extends JFrame {

    private JTextField txtId, txtUsername, txtPassword;
    private JComboBox<String> comboRol;
    private JButton btnGuardar, btnBuscar, btnActualizar, btnEliminar;
    private UsuarioControlador controlador = new UsuarioControlador();

    public CrudUsuarios() {

        setTitle("Gestión de Usuarios");
        setSize(800, 450);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        Font fontLabel = new Font("Century Gothic", Font.BOLD, 16);
        Font fontBtn = new Font("Century Gothic", Font.BOLD, 16);
        Font fontField = new Font("Century Gothic", Font.PLAIN, 15);

        JPanel content = new JPanel(new GridBagLayout());
        content.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        // ======== ID Usuario ========
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        JLabel lblId = new JLabel("ID Usuario:");
        lblId.setFont(fontLabel);
        content.add(lblId, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        txtId = new JTextField();
        txtId.setFont(fontField);
        content.add(txtId, gbc);

        // ======== Username ========
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        JLabel lblUser = new JLabel("Username:");
        lblUser.setFont(fontLabel);
        content.add(lblUser, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        txtUsername = new JTextField();
        txtUsername.setFont(fontField);
        content.add(txtUsername, gbc);

        // ======== Password ========
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        JLabel lblPass = new JLabel("Password:");
        lblPass.setFont(fontLabel);
        content.add(lblPass, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        txtPassword = new JTextField();
        txtPassword.setFont(fontField);
        content.add(txtPassword, gbc);

        // ======== Rol ========
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        JLabel lblRol = new JLabel("Rol:");
        lblRol.setFont(fontLabel);
        content.add(lblRol, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        String[] roles = {"ADMIN", "VENDEDOR"};
        comboRol = new JComboBox<>(roles);
        comboRol.setFont(fontField);
        content.add(comboRol, gbc);

        // ======== Espacio ========
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.weighty = 1.0;
        content.add(Box.createVerticalGlue(), gbc);


        // ======== Botones ========
        row++;
        gbc.gridy = row;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel panelBtns = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
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

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(fontBtn);
        btnActualizar.setBackground(azul);
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setPreferredSize(new Dimension(140, 40));

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(fontBtn);
        btnEliminar.setBackground(azul);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setPreferredSize(new Dimension(140, 40));

        panelBtns.add(btnGuardar);
        panelBtns.add(btnBuscar);
        panelBtns.add(btnActualizar);
        panelBtns.add(btnEliminar);

        content.add(panelBtns, gbc);

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(Color.WHITE);
        wrapper.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));
        wrapper.add(content, BorderLayout.CENTER);
        getContentPane().add(wrapper);

        // ========== EVENTOS ==========

        btnGuardar.addActionListener(e -> guardarUsuario());
        btnBuscar.addActionListener(e -> buscarUsuario());
        btnActualizar.addActionListener(e -> actualizarUsuario());
        btnEliminar.addActionListener(e -> eliminarUsuario());

        // Bloquear funciones a vendedores
        if (SessionManager.esVendedor()) {
            btnGuardar.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnActualizar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }

        setVisible(true);
    }

    // ======================= ACCIONES =======================

    private void guardarUsuario() {
        String user = txtUsername.getText().trim();
        String pass = txtPassword.getText().trim();
        String rol = (String) comboRol.getSelectedItem();

        if (user.isEmpty() || pass.isEmpty() || rol == null) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }

        Usuario u = new Usuario();
        u.setUsername(user);
        u.setPassword(pass);
        u.setRol(rol);

        boolean ok = controlador.insertarUsuario(u);
        JOptionPane.showMessageDialog(this, ok ? "Usuario registrado." : "Error al registrar usuario.");

        if (ok) limpiar();
    }

    private void buscarUsuario() {
        String idTxt = txtId.getText().trim();
        if (idTxt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID para buscar.");
            return;
        }

        try {
            int id = Integer.parseInt(idTxt);
            Usuario u = controlador.buscarUsuario(id);
            if (u == null) {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
                return;
            }

            txtUsername.setText(u.getUsername());
            txtPassword.setText(u.getPassword());
            comboRol.setSelectedItem(u.getRol());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        }
    }

    private void actualizarUsuario() {
        String idTxt = txtId.getText().trim();
        if (idTxt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un ID para actualizar.");
            return;
        }

        try {
            int id = Integer.parseInt(idTxt);

            Usuario nuevo = new Usuario();
            nuevo.setUsername(txtUsername.getText().trim());
            nuevo.setPassword(txtPassword.getText().trim());
            nuevo.setRol((String) comboRol.getSelectedItem());

            boolean ok = controlador.actualizarUsuario(id, nuevo);
            JOptionPane.showMessageDialog(this, ok ? "Usuario actualizado." : "Error al actualizar usuario.");

            if (ok) limpiar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
        }
    }

    private void eliminarUsuario() {
        String idTxt = txtId.getText().trim();
        if (idTxt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID para eliminar.");
            return;
        }

        try {
            int id = Integer.parseInt(idTxt);

            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Eliminar usuario con ID " + id + "?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (confirm != JOptionPane.YES_OPTION) return;

            boolean ok = controlador.eliminarUsuario(id);
            JOptionPane.showMessageDialog(this, ok ? "Usuario eliminado." : "No se pudo eliminar.");

            if (ok) limpiar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
        }
    }

    private void limpiar() {
        txtId.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        comboRol.setSelectedIndex(0);
    }
}
