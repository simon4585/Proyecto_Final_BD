package vista;

import javax.swing.*;
import java.awt.*;

public class CrudMateriasPrimas extends JFrame {

    private JTextField txtCodigo, txtTipo, txtDescripcion, txtCantidad, txtUnidad;
    private JCheckBox chkCertificado;

    public CrudMateriasPrimas() {
        setTitle("Inventario - Materias Primas");
        setSize(550, 430);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE); // Fondo blanco

        Font fontLabel = new Font("Century Gothic", Font.BOLD, 18);
        Font fontBtn   = new Font("Century Gothic", Font.BOLD, 18);
        Font fontCheck = new Font("Century Gothic", Font.PLAIN, 16);

        // ---------------- LABELS -------------------

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setFont(fontLabel);
        lblCodigo.setBounds(30, 30, 150, 25);
        add(lblCodigo);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(fontLabel);
        lblTipo.setBounds(30, 75, 150, 25);
        add(lblTipo);

        JLabel lblDesc = new JLabel("Descripción:");
        lblDesc.setFont(fontLabel);
        lblDesc.setBounds(30, 120, 150, 25);
        add(lblDesc);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setFont(fontLabel);
        lblCantidad.setBounds(30, 165, 150, 25);
        add(lblCantidad);

        JLabel lblUnidad = new JLabel("Unidad Medida:");
        lblUnidad.setFont(fontLabel);
        lblUnidad.setBounds(30, 210, 150, 25);
        add(lblUnidad);

        JLabel lblCert = new JLabel("Certificado:");
        lblCert.setFont(fontLabel);
        lblCert.setBounds(30, 255, 150, 25);
        add(lblCert);

        // ---------------- TEXTFIELDS -------------------

        txtCodigo = new JTextField();
        txtCodigo.setBounds(190, 30, 250, 28);
        add(txtCodigo);

        txtTipo = new JTextField();
        txtTipo.setBounds(190, 75, 250, 28);
        add(txtTipo);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(190, 120, 250, 28);
        add(txtDescripcion);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(190, 165, 250, 28);
        add(txtCantidad);

        txtUnidad = new JTextField();
        txtUnidad.setBounds(190, 210, 250, 28);
        add(txtUnidad);

        // ---------------- CHECKBOX -------------------

        chkCertificado = new JCheckBox("Disponible");
        chkCertificado.setFont(fontCheck);
        chkCertificado.setBackground(Color.WHITE);
        chkCertificado.setBounds(190, 255, 200, 30);
        add(chkCertificado);

        // ---------------- BOTONES -------------------

        Color azul = new Color(80, 150, 255);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(110, 320, 140, 35);
        btnGuardar.setBackground(azul);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(fontBtn);
        add(btnGuardar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(290, 320, 140, 35);
        btnEliminar.setBackground(azul);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(fontBtn);
        add(btnEliminar);

        setVisible(true);
    }
}
