package vista;

import java.awt.*;
import javax.swing.*;
import utils.SessionManager;

public class CrudProveedores extends JFrame {

    private final JTextField txtNit, txtNombre, txtDireccion, txtTelefono, txtContacto;

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
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(110, 260, 150, 40);
        btnGuardar.setBackground(new Color(80, 150, 255));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(fontBotones);
        btnGuardar.setFocusPainted(false);
        add(btnGuardar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(300, 260, 150, 40);
        btnBuscar.setBackground(new Color(80, 150, 255));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(fontBotones);
        btnBuscar.setFocusPainted(false);
        add(btnBuscar);

        // Deshabilitar botones para vendedores
        if (SessionManager.esVendedor()) {
            btnGuardar.setEnabled(false);
        }

        setVisible(true);
    }
}
