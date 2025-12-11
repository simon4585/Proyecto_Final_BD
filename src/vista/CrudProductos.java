package vista;

import controladores.ProductoControlador;
import java.awt.*;
import java.math.BigDecimal;
import javax.swing.*;
import modelo.Producto;
import utils.SessionManager;

public class CrudProductos extends JFrame {

    private final  JTextField txtCodigo, txtDescripcion, txtTalla, txtPrecio, txtCantidad;
    private JComboBox<String> cbSexo;
    private JComboBox<String> cbTipo;
    private ProductoControlador controlador = new ProductoControlador();

    public CrudProductos() {
        setTitle("Gestión de Productos");
        setSize(700, 460);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        Font tituloFont = new Font("Century Gothic", Font.BOLD, 20);
        Font labelFont = new Font("Century Gothic", Font.BOLD, 18);
        Font campoFont = new Font("Century Gothic", Font.PLAIN, 16);
        Font botonFont = new Font("Century Gothic", Font.BOLD, 16);
        Color azul = new Color(80, 150, 255);

        // Título
        JLabel lblTitulo = new JLabel("Gestión de Productos");
        lblTitulo.setFont(tituloFont);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(12, 0, 12, 0));
        add(lblTitulo, BorderLayout.NORTH);

        // Panel central con GridBagLayout para pares etiqueta-campo
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 16, 10, 16);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        // ID Producto
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblCodigo = new JLabel("ID Producto:");
        lblCodigo.setFont(labelFont);
        panel.add(lblCodigo, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtCodigo = new JTextField();
        txtCodigo.setFont(campoFont);
        txtCodigo.setPreferredSize(new Dimension(200, 28));
        panel.add(txtCodigo, gbc);

        // Descripción
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblDesc = new JLabel("Descripción:");
        lblDesc.setFont(labelFont);
        panel.add(lblDesc, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtDescripcion = new JTextField();
        txtDescripcion.setFont(campoFont);
        panel.add(txtDescripcion, gbc);

        // Talla
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblTalla = new JLabel("Talla:");
        lblTalla.setFont(labelFont);
        panel.add(lblTalla, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtTalla = new JTextField();
        txtTalla.setFont(campoFont);
        panel.add(txtTalla, gbc);

        // Sexo
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setFont(labelFont);
        panel.add(lblSexo, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        String[] sexo = {"Masculino", "Femenino", "Unisex"};
        cbSexo = new JComboBox<>(sexo);
        cbSexo.setFont(campoFont);
        panel.add(cbSexo, gbc);

        // Precio
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(labelFont);
        panel.add(lblPrecio, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtPrecio = new JTextField();
        txtPrecio.setFont(campoFont);
        panel.add(txtPrecio, gbc);

        // Cantidad
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setFont(labelFont);
        panel.add(lblCantidad, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtCantidad = new JTextField();
        txtCantidad.setFont(campoFont);
        panel.add(txtCantidad, gbc);

        // Tipo (se deja al final, igual estilo)
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblTipos = new JLabel("Tipo:");
        lblTipos.setFont(labelFont);
        panel.add(lblTipos, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        String[] tipos = {"Camisa", "Pantalón", "Sudadera", "Pantaloneta", "Jardinera"};
        cbTipo = new JComboBox<>(tipos);
        cbTipo.setFont(campoFont);
        panel.add(cbTipo, gbc);

        // Agregar padding al panel central
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(Color.WHITE);
        wrapper.setBorder(BorderFactory.createEmptyBorder(8, 18, 8, 18));
        wrapper.add(panel, BorderLayout.CENTER);
        add(wrapper, BorderLayout.CENTER);

        // Panel de botones (abajo)
        JPanel panelBtns = new JPanel(new FlowLayout(FlowLayout.CENTER, 18, 12));
        panelBtns.setBackground(Color.WHITE);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(botonFont);
        btnGuardar.setBackground(azul);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setPreferredSize(new Dimension(140, 38));

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(botonFont);
        btnBuscar.setBackground(azul);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setPreferredSize(new Dimension(140, 38));

        JButton btnEditar = new JButton("Actualizar");
        btnEditar.setFont(botonFont);
        btnEditar.setBackground(azul);
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setPreferredSize(new Dimension(140, 38));

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(botonFont);
        btnEliminar.setBackground(azul);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setPreferredSize(new Dimension(140, 38));

        panelBtns.add(btnGuardar);
        panelBtns.add(btnBuscar);
        panelBtns.add(btnEditar);
        panelBtns.add(btnEliminar);

        add(panelBtns, BorderLayout.SOUTH);

        // ================= ACCIONES =================

        btnGuardar.addActionListener(e -> insertarProducto());
        btnBuscar.addActionListener(e -> buscarProducto());
        btnEditar.addActionListener(e -> actualizarProducto());
        btnEliminar.addActionListener(e -> eliminarProducto());

        // Deshabilitar botones de modificación para vendedores
        if (SessionManager.esVendedor()) {
            btnEliminar.setEnabled(false);
        }

        setVisible(true);
    }

    // ------------------------- MÉTODOS DE ACCIÓN --------------------------

    private void insertarProducto() {
        try {
            Producto p = obtenerDatosFormulario(false);
            if (p == null) return;

            if (controlador.insertarProducto(p)) {
                JOptionPane.showMessageDialog(this, "Producto registrado correctamente");
                limpiar();
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
            txtPrecio.setText(p.getPrecioVenta() != null ? p.getPrecioVenta().toString() : "");
            txtCantidad.setText(p.getCantidadExistente() != null ? p.getCantidadExistente().toString() : "");
            cbTipo.setSelectedItem(p.getTipoProducto());
        }
    }

    private void actualizarProducto() {
        try {
            Producto p = obtenerDatosFormulario(true);
            if (p == null) return;

            if (controlador.actualizarProducto(p)) {
                JOptionPane.showMessageDialog(this, "Producto actualizado correctamente");
                limpiar();
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
            limpiar();
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

    private void limpiar() {
        txtCodigo.setText("");
        txtDescripcion.setText("");
        txtTalla.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        cbSexo.setSelectedIndex(0);
        cbTipo.setSelectedIndex(0);
    }
}
