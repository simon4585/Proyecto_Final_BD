package vista;

import javax.swing.*;
import java.awt.*;

public class CrudUniformes extends JFrame {

    private JTextField txtId, txtTipo, txtColor, txtTipoTela,
            txtLugarBordado, txtTipoBordado, txtEstampado,
            txtIdColegio, txtIdProducto;
    private JCheckBox chkLlevaBordado;
    private JButton btnGuardar, btnBuscar, btnEliminar;

    public CrudUniformes() {
        setTitle("Gestión de Uniformes");
        setSize(900, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        Font fontLabel = new Font("Century Gothic", Font.BOLD, 16);
        Font fontBtn = new Font("Century Gothic", Font.BOLD, 16);
        Font fontField = new Font("Century Gothic", Font.PLAIN, 15);

        // Panel principal con GridBagLayout para 2 columnas limpias
        JPanel content = new JPanel(new GridBagLayout());
        content.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 8, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        // ----- fila 0: ID (col 0-1) y Tipo (col 2-3)
        gbc.gridy = row;

        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblId = new JLabel("ID Uniforme:");
        lblId.setFont(fontLabel);
        content.add(lblId, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.3;
        txtId = new JTextField();
        txtId.setFont(fontField);
        content.add(txtId, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0;
        JLabel lblTipo = new JLabel("Tipo (camisa/pantalón):");
        lblTipo.setFont(fontLabel);
        content.add(lblTipo, gbc);

        gbc.gridx = 3;
        gbc.weightx = 0.7;
        txtTipo = new JTextField();
        txtTipo.setFont(fontField);
        content.add(txtTipo, gbc);

        // ----- fila 1: Color | Tipo de tela
        row++;
        gbc.gridy = row;

        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblColor = new JLabel("Color:");
        lblColor.setFont(fontLabel);
        content.add(lblColor, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.3;
        txtColor = new JTextField();
        txtColor.setFont(fontField);
        content.add(txtColor, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0;
        JLabel lblTela = new JLabel("Tipo de tela:");
        lblTela.setFont(fontLabel);
        content.add(lblTela, gbc);

        gbc.gridx = 3;
        gbc.weightx = 0.7;
        txtTipoTela = new JTextField();
        txtTipoTela.setFont(fontField);
        content.add(txtTipoTela, gbc);

        // ----- fila 2: Lleva bordado (checkbox) | Lugar del bordado
        row++;
        gbc.gridy = row;

        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblBordado = new JLabel("Lleva bordado:");
        lblBordado.setFont(fontLabel);
        content.add(lblBordado, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.3;
        chkLlevaBordado = new JCheckBox();
        chkLlevaBordado.setBackground(Color.WHITE);
        content.add(chkLlevaBordado, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0;
        JLabel lblLugar = new JLabel("Lugar del bordado:");
        lblLugar.setFont(fontLabel);
        content.add(lblLugar, gbc);

        gbc.gridx = 3;
        gbc.weightx = 0.7;
        txtLugarBordado = new JTextField();
        txtLugarBordado.setFont(fontField);
        content.add(txtLugarBordado, gbc);

        // ----- fila 3: Tipo bordado | Estampado
        row++;
        gbc.gridy = row;

        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblTipoB = new JLabel("Tipo de bordado:");
        lblTipoB.setFont(fontLabel);
        content.add(lblTipoB, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.3;
        txtTipoBordado = new JTextField();
        txtTipoBordado.setFont(fontField);
        content.add(txtTipoBordado, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0;
        JLabel lblEstampado = new JLabel("Estampado (si aplica):");
        lblEstampado.setFont(fontLabel);
        content.add(lblEstampado, gbc);

        gbc.gridx = 3;
        gbc.weightx = 0.7;
        txtEstampado = new JTextField();
        txtEstampado.setFont(fontField);
        content.add(txtEstampado, gbc);

        // ----- fila 4: ID Colegio | ID Producto
        row++;
        gbc.gridy = row;

        gbc.gridx = 0;
        gbc.weightx = 0;
        JLabel lblCole = new JLabel("ID Colegio (FK):");
        lblCole.setFont(fontLabel);
        content.add(lblCole, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.3;
        txtIdColegio = new JTextField();
        txtIdColegio.setFont(fontField);
        content.add(txtIdColegio, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0;
        JLabel lblProd = new JLabel("ID Producto (FK):");
        lblProd.setFont(fontLabel);
        content.add(lblProd, gbc);

        gbc.gridx = 3;
        gbc.weightx = 0.7;
        txtIdProducto = new JTextField();
        txtIdProducto.setFont(fontField);
        content.add(txtIdProducto, gbc);

        // ----- fila 5: espacio vertical (para separar botones)
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.weighty = 1.0;             // ocupa el espacio sobrante
        gbc.fill = GridBagConstraints.VERTICAL;
        content.add(Box.createVerticalGlue(), gbc);

        // ----- fila 6: botones centrados (span 4 columnas)
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel panelBtns = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        panelBtns.setBackground(Color.WHITE);

        Color azul = new Color(80, 150, 255);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(fontBtn);
        btnGuardar.setBackground(azul);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setPreferredSize(new Dimension(160, 40));

        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(fontBtn);
        btnBuscar.setBackground(azul);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setPreferredSize(new Dimension(160, 40));

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(fontBtn);
        btnEliminar.setBackground(azul);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setPreferredSize(new Dimension(160, 40));

        panelBtns.add(btnGuardar);
        panelBtns.add(btnBuscar);
        panelBtns.add(btnEliminar);

        content.add(panelBtns, gbc);

        // Wrapper con padding
        getContentPane().setLayout(new BorderLayout());
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(Color.WHITE);
        wrapper.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));
        wrapper.add(content, BorderLayout.CENTER);
        getContentPane().add(wrapper, BorderLayout.CENTER);

        setVisible(true);
    }

}
