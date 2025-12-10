package vista;

import javax.swing.*;
import java.awt.*;

public class CrudColegios extends JFrame {

    private JTextField txtId, txtNombre, txtDireccion, txtTelefono;

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

        setVisible(true);
    }
}
