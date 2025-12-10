package vista;

import javax.swing.*;
import java.awt.*;

public class CrudPedidos extends JFrame {

    private JTextField txtNumPedido, txtCliente, txtArticulo;
    private JTextArea txtMedidas;
    private JTextField txtFechaEncargo, txtFechaEntrega, txtAbono;

    public CrudPedidos() {

        setTitle("Gestión de Pedidos");
        setSize(650, 520);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        Font labelFont = new Font("Century Gothic", Font.BOLD, 18);
        Font buttonFont = new Font("Century Gothic", Font.BOLD, 20);
        Color buttonColor = new Color(80, 150, 255);

        int labelX = 30;
        int fieldX = 210;
        int width = 350;
        int height = 28;

        // ----------------- CAMPOS --------------------

        JLabel lblNum = new JLabel("Número de Pedido:");
        lblNum.setBounds(labelX, 20, 180, 30);
        lblNum.setFont(labelFont);
        add(lblNum);

        txtNumPedido = new JTextField();
        txtNumPedido.setBounds(fieldX, 20, width, height);
        add(txtNumPedido);

        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setBounds(labelX, 65, 150, 30);
        lblCliente.setFont(labelFont);
        add(lblCliente);

        txtCliente = new JTextField();
        txtCliente.setBounds(fieldX, 65, width, height);
        add(txtCliente);

        JLabel lblArticulo = new JLabel("Artículo:");
        lblArticulo.setBounds(labelX, 110, 150, 30);
        lblArticulo.setFont(labelFont);
        add(lblArticulo);

        txtArticulo = new JTextField();
        txtArticulo.setBounds(fieldX, 110, width, height);
        add(txtArticulo);

        JLabel lblMedidas = new JLabel("<html>Medidas /<br>Anotación:</html>");
        lblMedidas.setBounds(labelX, 155, 200, 60);
        lblMedidas.setFont(labelFont);
        add(lblMedidas);


        txtMedidas = new JTextArea();
        txtMedidas.setLineWrap(true);
        txtMedidas.setWrapStyleWord(true);
        txtMedidas.setBounds(fieldX, 155, width, 90);
        txtMedidas.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(txtMedidas);

        JLabel lblFechaEnc = new JLabel("Fecha de Encargo:");
        lblFechaEnc.setBounds(labelX, 260, 180, 30);
        lblFechaEnc.setFont(labelFont);
        add(lblFechaEnc);

        txtFechaEncargo = new JTextField();
        txtFechaEncargo.setBounds(fieldX, 260, width, height);
        add(txtFechaEncargo);

        JLabel lblFechaEnt = new JLabel("Fecha de Entrega:");
        lblFechaEnt.setBounds(labelX, 305, 180, 30);
        lblFechaEnt.setFont(labelFont);
        add(lblFechaEnt);

        txtFechaEntrega = new JTextField();
        txtFechaEntrega.setBounds(fieldX, 305, width, height);
        add(txtFechaEntrega);

        JLabel lblAbono = new JLabel("Abono:");
        lblAbono.setBounds(labelX, 350, 150, 30);
        lblAbono.setFont(labelFont);
        add(lblAbono);

        txtAbono = new JTextField();
        txtAbono.setBounds(fieldX, 350, width, height);
        add(txtAbono);

        // ---------------- BOTONES ----------------

        JButton btnGuardar = new JButton("Registrar Pedido");
        btnGuardar.setBounds(100, 410, 200, 40);
        btnGuardar.setBackground(buttonColor);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(buttonFont);
        btnGuardar.setFocusPainted(false);
        add(btnGuardar);

        JButton btnEntregado = new JButton("Marcar Entregado");
        btnEntregado.setBounds(320, 410, 220, 40);
        btnEntregado.setBackground(buttonColor);
        btnEntregado.setForeground(Color.WHITE);
        btnEntregado.setFont(buttonFont);
        btnEntregado.setFocusPainted(false);
        add(btnEntregado);

        setVisible(true);
    }
}
