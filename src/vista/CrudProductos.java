package vista;

import javax.swing.*;
import java.awt.*;

public class CrudProductos extends JFrame {

    private JTextField txtCodigo, txtDescripcion, txtTalla, txtPrecio, txtCantidad;

    public CrudProductos() {

        // ----------------- CONFIG VENTANA -----------------
        setTitle("Gestión de Productos");
        setSize(570, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        Font fontLabel = new Font("Century Gothic", Font.BOLD, 18);
        Font fontBtn   = new Font("Century Gothic", Font.BOLD, 18);
        Font fontTitle = new Font("Century Gothic", Font.BOLD, 24);

        Color azul = new Color(80, 150, 255);

        // ----------------- TÍTULO -----------------
        JLabel lblTitulo = new JLabel("Gestión de Productos");
        lblTitulo.setFont(fontTitle);
        lblTitulo.setBounds(150, 15, 300, 30);
        add(lblTitulo);

        // ----------------- LABELS -----------------
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setFont(fontLabel);
        lblCodigo.setBounds(40, 70, 150, 25);
        add(lblCodigo);

        JLabel lblDesc = new JLabel("Descripción:");
        lblDesc.setFont(fontLabel);
        lblDesc.setBounds(40, 115, 150, 25);
        add(lblDesc);

        JLabel lblTalla = new JLabel("Talla:");
        lblTalla.setFont(fontLabel);
        lblTalla.setBounds(40, 160, 150, 25);
        add(lblTalla);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setFont(fontLabel);
        lblSexo.setBounds(40, 205, 150, 25);
        add(lblSexo);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(fontLabel);
        lblPrecio.setBounds(40, 250, 150, 25);
        add(lblPrecio);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setFont(fontLabel);
        lblCantidad.setBounds(40, 295, 150, 25);
        add(lblCantidad);

        // ----------------- TEXTFIELDS -----------------
        txtCodigo = new JTextField();
        txtCodigo.setBounds(190, 70, 250, 28);
        add(txtCodigo);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(190, 115, 250, 28);
        add(txtDescripcion);

        txtTalla = new JTextField();
        txtTalla.setBounds(190, 160, 250, 28);
        add(txtTalla);

        // ----------------- COMBOBOX SEXO -----------------
        String[] opcionesSexo = {"Masculino", "Femenino", "Unisex"};
        JComboBox<String> cbSexo = new JComboBox<>(opcionesSexo);
        cbSexo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        cbSexo.setBounds(190, 205, 250, 28);
        add(cbSexo);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(190, 250, 250, 28);
        add(txtPrecio);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(190, 295, 250, 28);
        add(txtCantidad);

        // ----------------- BOTONES -----------------
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(50, 360, 150, 35);
        btnGuardar.setBackground(azul);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(fontBtn);
        add(btnGuardar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(220, 360, 150, 35);
        btnBuscar.setBackground(azul);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(fontBtn);
        add(btnBuscar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(390, 360, 150, 35);
        btnEditar.setBackground(azul);
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setFont(fontBtn);
        add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(220, 410, 150, 35);
        btnEliminar.setBackground(azul);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(fontBtn);
        add(btnEliminar);

        setVisible(true);
    }
}
