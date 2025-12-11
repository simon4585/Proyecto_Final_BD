package vista;

import java.awt.*;
import javax.swing.*;
import utils.SessionManager;

public class CrudSuministros extends JFrame {

    private final JTextField txtId, txtNitProveedor, txtCodigoMateria, txtCantidad;
    private final JTextArea txtObservaciones;
    private final JButton btnGuardar, btnBuscar, btnEliminar;

    public CrudSuministros() {
        setTitle("Registro de Suministros");
        setSize(620, 420);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        Font fontLabel = new Font("Century Gothic", Font.BOLD, 16);
        Font fontField = new Font("Century Gothic", Font.PLAIN, 15);
        Font fontBtn = new Font("Century Gothic", Font.BOLD, 16);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 12, 8, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        // ID Suministro
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;
        JLabel lblId = new JLabel("ID Suministro:");
        lblId.setFont(fontLabel);
        panel.add(lblId, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtId = new JTextField();
        txtId.setFont(fontField);
        panel.add(txtId, gbc);

        // NIT Proveedor
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblNit = new JLabel("NIT Proveedor:");
        lblNit.setFont(fontLabel);
        panel.add(lblNit, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtNitProveedor = new JTextField();
        txtNitProveedor.setFont(fontField);
        panel.add(txtNitProveedor, gbc);

        // Código Materia Prima
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblCodigo = new JLabel("Código Materia Prima:");
        lblCodigo.setFont(fontLabel);
        panel.add(lblCodigo, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtCodigoMateria = new JTextField();
        txtCodigoMateria.setFont(fontField);
        panel.add(txtCodigoMateria, gbc);

        // Cantidad ingresada
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblCantidad = new JLabel("Cantidad ingresada:");
        lblCantidad.setFont(fontLabel);
        panel.add(lblCantidad, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtCantidad = new JTextField();
        txtCantidad.setFont(fontField);
        panel.add(txtCantidad, gbc);

        // Observaciones (label + textarea)
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        JLabel lblObs = new JLabel("Observaciones:");
        lblObs.setFont(fontLabel);
        panel.add(lblObs, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipady = 80; // altura del textarea
        txtObservaciones = new JTextArea();
        txtObservaciones.setLineWrap(true);
        txtObservaciones.setWrapStyleWord(true);
        txtObservaciones.setFont(fontField);
        JScrollPane scrollObs = new JScrollPane(txtObservaciones);
        panel.add(scrollObs, gbc);

        // Reset constraints para botones
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0;

        // Botones centrados
        JPanel panelBtns = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 6));
        panelBtns.setBackground(Color.WHITE);

        Color azul = new Color(80, 150, 255);
        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(fontBtn);
        btnGuardar.setBackground(azul);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setPreferredSize(new Dimension(140, 40));

        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(fontBtn);
        btnBuscar.setBackground(azul);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setPreferredSize(new Dimension(140, 40));

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(fontBtn);
        btnEliminar.setBackground(azul);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setPreferredSize(new Dimension(140, 40));

        panelBtns.add(btnGuardar);
        panelBtns.add(btnBuscar);
        panelBtns.add(btnEliminar);

        panel.add(panelBtns, gbc);

        // Wrapper con padding
        getContentPane().setLayout(new BorderLayout());
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(Color.WHITE);
        wrapper.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        wrapper.add(panel, BorderLayout.CENTER);
        getContentPane().add(wrapper, BorderLayout.CENTER);

        // Deshabilitar botones para vendedores
        if (SessionManager.esVendedor()) {
            btnGuardar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }

        setVisible(true);
    }


}
