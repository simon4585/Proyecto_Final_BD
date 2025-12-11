package vista;


import controladores.ProductoControlador;
import modelo.Producto;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class CrudProductos extends JFrame {

    private JTextField txtCodigo, txtDescripcion, txtTalla, txtPrecio, txtCantidad;
    private JComboBox<String> cbSexo;
    private JComboBox<String> cbTipo;
    private ProductoControlador controlador = new ProductoControlador();

    public CrudProductos() {
        setTitle("Gestión de Productos");
        setSize(520, 450);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitulo = new JLabel("Gestión de Productos");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(150, 10, 250, 25);
        add(lblTitulo);


        JLabel lblCodigo = new JLabel("ID Producto:");
        lblCodigo.setBounds(30, 60, 100, 25);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(140, 60, 100, 25);
        add(txtCodigo);

        JLabel lblDesc = new JLabel("Descripción:");
        lblDesc.setBounds(30, 100, 100, 25);
        add(lblDesc);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(140, 100, 300, 25);
        add(txtDescripcion);

        JLabel lblTalla = new JLabel("Talla:");
        lblTalla.setBounds(30, 140, 100, 25);
        add(lblTalla);

        txtTalla = new JTextField();
        txtTalla.setBounds(140, 140, 100, 25);
        add(txtTalla);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(30, 180, 100, 25);
        add(lblSexo);

        String[] sexo = {"Masculino", "Femenino", "Unisex"};
        cbSexo = new JComboBox<>(sexo);
        cbSexo.setBounds(140, 180, 120, 25);
        add(cbSexo);

        JLabel lblTipos = new JLabel("Tipo:");
        lblTipos.setBounds(30, 300, 100, 25);
        add(lblTipos);
        String[] tipos ={"Camisa", "Pantalón", "Sudadera", "Pantaloneta", "Jardinera"};
        cbTipo = new JComboBox<>(tipos);
        cbTipo.setBounds(140, 300, 120, 25);
        add(cbTipo);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(30, 220, 100, 25);
        add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(140, 220, 150, 25);
        add(txtPrecio);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(30, 260, 100, 25);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(140, 260, 150, 25);
        add(txtCantidad);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(40, 330, 100, 35);
        add(btnGuardar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(150, 330, 100, 35);
        add(btnBuscar);

        JButton btnEditar = new JButton("Actualizar");
        btnEditar.setBounds(260, 330, 120, 35);
        add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(390, 330, 100, 35);
        add(btnEliminar);

        // ----------------------------- ACCIONES -----------------------------

        btnGuardar.addActionListener(e -> insertarProducto());
        btnBuscar.addActionListener(e -> buscarProducto());
        btnEditar.addActionListener(e -> actualizarProducto());
        btnEliminar.addActionListener(e -> eliminarProducto());

        setVisible(true);
    }

    // ------------------------- MÉTODOS DE ACCIÓN --------------------------

    private void insertarProducto() {
        try {
            Producto p = obtenerDatosFormulario(false);
            if (p == null) return;

            if (controlador.insertarProducto(p)) {
                JOptionPane.showMessageDialog(this, "Producto registrado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void buscarProducto() {
        if (txtCodigo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese ID de producto");
            return;
        }

        Producto p = controlador.buscarProducto(Integer.parseInt(txtCodigo.getText()));

        if (p == null) {
            JOptionPane.showMessageDialog(this, "Producto no encontrado");
        } else {
            txtDescripcion.setText(p.getDescripcion());
            txtTalla.setText(p.getTalla());
            cbSexo.setSelectedItem(p.getSexo());
            txtPrecio.setText(p.getPrecioVenta().toString());
            txtCantidad.setText(p.getCantidadExistente().toString());
        }
    }

    private void actualizarProducto() {
        try {
            Producto p = obtenerDatosFormulario(true);
            if (p == null) return;

            if (controlador.actualizarProducto(p)) {
                JOptionPane.showMessageDialog(this, "Producto actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void eliminarProducto() {
        if (txtCodigo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del producto a eliminar");
            return;
        }

        int id = Integer.parseInt(txtCodigo.getText());

        if (controlador.eliminarProducto(id)) {
            JOptionPane.showMessageDialog(this, "Producto eliminado");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar");
        }
    }

    // ----------------------------------------------------------------------

    /** Construye un objeto Producto a partir del formulario */
    private Producto obtenerDatosFormulario(boolean incluirID) {
        if (txtDescripcion.getText().isEmpty() ||
                txtTalla.getText().isEmpty() ||
                txtPrecio.getText().isEmpty() ||
                txtCantidad.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos");
            return null;
        }

        Producto p = new Producto();

        if (incluirID) {
            if (txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar el ID para actualizar");
                return null;
            }
            p.setIdProducto(Integer.parseInt(txtCodigo.getText()));
        }

        p.setTipoProducto(cbTipo.getSelectedItem().toString()); // puedes cambiarlo si agregas un campo
        p.setDescripcion(txtDescripcion.getText());
        p.setTalla(txtTalla.getText());
        p.setSexo(cbSexo.getSelectedItem().toString());
        p.setPrecioVenta(new BigDecimal(txtPrecio.getText()));
        p.setCantidadExistente(Integer.parseInt(txtCantidad.getText()));

        return p;
    }
}
