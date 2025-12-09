package vista;

import javax.swing.*;

public class CrudProductos extends JFrame {

    private JTextField txtCodigo, txtDescripcion, txtTalla, txtSexo, txtPrecio, txtCantidad;

    public CrudProductos() {
        setTitle("Gestión de Productos");
        setSize(500, 420);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblTitulo = new JLabel("Gestión de Productos");
        lblTitulo.setBounds(160, 10, 200, 25);
        add(lblTitulo);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(30, 50, 100, 25);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(140, 50, 200, 25);
        add(txtCodigo);

        JLabel lblDesc = new JLabel("Descripción:");
        lblDesc.setBounds(30, 90, 100, 25);
        add(lblDesc);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(140, 90, 250, 25);
        add(txtDescripcion);

        JLabel lblTalla = new JLabel("Talla:");
        lblTalla.setBounds(30, 130, 100, 25);
        add(lblTalla);

        txtTalla = new JTextField();
        txtTalla.setBounds(140, 130, 100, 25);
        add(txtTalla);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(30, 170, 100, 25);
        add(lblSexo);

        String[] sexo = {"Masculino", "Femenino", "Unisex"};
        JComboBox<String> cbSexo = new JComboBox<>(sexo);
        cbSexo.setBounds(140, 170, 120, 25);
        add(cbSexo);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(30, 210, 100, 25);
        add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(140, 210, 150, 25);
        add(txtPrecio);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(30, 250, 100, 25);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(140, 250, 150, 25);
        add(txtCantidad);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(50, 310, 100, 30);
        add(btnGuardar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(170, 310, 100, 30);
        add(btnBuscar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(290, 310, 100, 30);
        add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(170, 355, 100, 30);
        add(btnEliminar);

        setVisible(true);
    }
}
