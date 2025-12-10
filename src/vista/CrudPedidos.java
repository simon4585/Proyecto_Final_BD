package vista;

import javax.swing.*;

public class CrudPedidos extends JFrame {

    private JTextField txtNumPedido, txtCliente, txtArticulo;
    private JTextArea txtMedidas;
    private JTextField txtFechaEncargo, txtFechaEntrega, txtAbono;

    public CrudPedidos() {
        setTitle("Gestión de Pedidos");
        setSize(600, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNum = new JLabel("Número de Pedido:");
        lblNum.setBounds(30, 20, 150, 25);
        add(lblNum);

        txtNumPedido = new JTextField();
        txtNumPedido.setBounds(190, 20, 200, 25);
        add(txtNumPedido);

        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setBounds(30, 60, 150, 25);
        add(lblCliente);

        txtCliente = new JTextField();
        txtCliente.setBounds(190, 60, 300, 25);
        add(txtCliente);

        JLabel lblArticulo = new JLabel("Artículo:");
        lblArticulo.setBounds(30, 100, 150, 25);
        add(lblArticulo);

        txtArticulo = new JTextField();
        txtArticulo.setBounds(190, 100, 300, 25);
        add(txtArticulo);

        JLabel lblMedidas = new JLabel("Medidas / Anotación:");
        lblMedidas.setBounds(30, 140, 160, 25);
        add(lblMedidas);

        txtMedidas = new JTextArea();
        JScrollPane scroll = new JScrollPane(txtMedidas);
        scroll.setBounds(190, 140, 350, 80);
        add(scroll);

        JLabel lblFechaEnc = new JLabel("Fecha de Encargo:");
        lblFechaEnc.setBounds(30, 240, 150, 25);
        add(lblFechaEnc);

        txtFechaEncargo = new JTextField();
        txtFechaEncargo.setBounds(190, 240, 200, 25);
        add(txtFechaEncargo);

        JLabel lblFechaEnt = new JLabel("Fecha de Entrega:");
        lblFechaEnt.setBounds(30, 280, 150, 25);
        add(lblFechaEnt);

        txtFechaEntrega = new JTextField();
        txtFechaEntrega.setBounds(190, 280, 200, 25);
        add(txtFechaEntrega);

        JLabel lblAbono = new JLabel("Abono:");
        lblAbono.setBounds(30, 320, 150, 25);
        add(lblAbono);

        txtAbono = new JTextField();
        txtAbono.setBounds(190, 320, 200, 25);
        add(txtAbono);

        JButton btnGuardar = new JButton("Registrar Pedido");
        btnGuardar.setBounds(100, 380, 160, 35);
        add(btnGuardar);

        JButton btnEntregado = new JButton("Marcar como Entregado");
        btnEntregado.setBounds(300, 380, 220, 35);
        add(btnEntregado);

        setVisible(true);
    }
}
