package vista;

import javax.swing.*;

public class CrudClientes extends JFrame {

    private JTextField txtDocumento, txtNombre, txtTelefono;

    public CrudClientes() {
        setTitle("Gestión de Clientes");
        setSize(450, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblDoc = new JLabel("Documento:");
        lblDoc.setBounds(30, 30, 100, 25);
        add(lblDoc);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(140, 30, 200, 25);
        add(txtDocumento);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 70, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(140, 70, 200, 25);
        add(txtNombre);

        JLabel lblTel = new JLabel("Teléfono:");
        lblTel.setBounds(30, 110, 100, 25);
        add(lblTel);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(140, 110, 200, 25);
        add(txtTelefono);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(50, 170, 100, 30);
        add(btnGuardar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(170, 170, 100, 30);
        add(btnBuscar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(290, 170, 100, 30);
        add(btnEliminar);

        setVisible(true);
    }
}
