package vista;

import javax.swing.*;

public class CrudProveedores extends JFrame {

    private JTextField txtNit, txtNombre, txtDireccion, txtTelefono, txtContacto;

    public CrudProveedores() {
        setTitle("Gestión de Proveedores");
        setSize(520, 380);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNit = new JLabel("NIT:");
        lblNit.setBounds(30, 30, 100, 25);
        add(lblNit);

        txtNit = new JTextField();
        txtNit.setBounds(150, 30, 200, 25);
        add(txtNit);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 70, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 70, 280, 25);
        add(txtNombre);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(30, 110, 100, 25);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(150, 110, 280, 25);
        add(txtDireccion);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(30, 150, 100, 25);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(150, 150, 200, 25);
        add(txtTelefono);

        JLabel lblContacto = new JLabel("Nombre Contacto:");
        lblContacto.setBounds(30, 190, 120, 25);
        add(lblContacto);

        txtContacto = new JTextField();
        txtContacto.setBounds(150, 190, 280, 25);
        add(txtContacto);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(90, 260, 120, 30);
        add(btnGuardar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(240, 260, 120, 30);
        add(btnBuscar);

        setVisible(true);
    }
}
