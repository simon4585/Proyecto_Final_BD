package vista;

import javax.swing.*;

public class CrudColegios extends JFrame {

    private JTextField txtId, txtNombre, txtDireccion, txtTelefono;

    public CrudColegios() {
        setTitle("Gestión de Colegios");
        setSize(500, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblId = new JLabel("ID Colegio:");
        lblId.setBounds(30, 30, 100, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(150, 30, 100, 25);
        add(txtId);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 70, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 70, 250, 25);
        add(txtNombre);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(30, 110, 100, 25);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(150, 110, 250, 25);
        add(txtDireccion);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(30, 150, 100, 25);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(150, 150, 150, 25);
        add(txtTelefono);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(50, 220, 100, 30);
        add(btnGuardar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(180, 220, 100, 30);
        add(btnBuscar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(310, 220, 100, 30);
        add(btnEliminar);

        setVisible(true);
    }
}
