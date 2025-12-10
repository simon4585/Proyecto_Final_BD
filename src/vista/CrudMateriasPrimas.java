package vista;

import javax.swing.*;

public class CrudMateriasPrimas extends JFrame {

    private JTextField txtCodigo, txtTipo, txtDescripcion, txtCantidad, txtUnidad;
    private JCheckBox chkCertificado;

    public CrudMateriasPrimas() {
        setTitle("Inventario - Materias Primas");
        setSize(520, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(30, 30, 100, 25);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 30, 150, 25);
        add(txtCodigo);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(30, 70, 100, 25);
        add(lblTipo);

        txtTipo = new JTextField();
        txtTipo.setBounds(150, 70, 200, 25);
        add(txtTipo);

        JLabel lblDesc = new JLabel("Descripción:");
        lblDesc.setBounds(30, 110, 100, 25);
        add(lblDesc);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(150, 110, 280, 25);
        add(txtDescripcion);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(30, 150, 100, 25);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(150, 150, 150, 25);
        add(txtCantidad);

        JLabel lblUnidad = new JLabel("Unidad Medida:");
        lblUnidad.setBounds(30, 190, 120, 25);
        add(lblUnidad);

        txtUnidad = new JTextField();
        txtUnidad.setBounds(150, 190, 150, 25);
        add(txtUnidad);

        JLabel lblCert = new JLabel("Certificado:");
        lblCert.setBounds(30, 230, 100, 25);
        add(lblCert);

        chkCertificado = new JCheckBox("Disponible");
        chkCertificado.setBounds(150, 230, 150, 25);
        add(chkCertificado);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 290, 120, 30);
        add(btnGuardar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(260, 290, 120, 30);
        add(btnEliminar);

        setVisible(true);
    }
}
