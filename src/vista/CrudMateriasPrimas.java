package vista;

import controladores.MateriaPrimaControlador;
import java.awt.*;
import java.math.BigDecimal;
import javax.swing.*;
import modelo.MateriaPrima;
import utils.SessionManager;

public class CrudMateriasPrimas extends JFrame {

    private JTextField txtCodigo, txtTipo, txtDescripcion, txtCantidad, txtUnidad;
    private JCheckBox chkCertificado;

    private MateriaPrimaControlador controlador = new MateriaPrimaControlador();

    public CrudMateriasPrimas() {
        setTitle("Inventario - Materias Primas");
        setSize(600, 430);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        Font fontLabel = new Font("Century Gothic", Font.BOLD, 18);
        Font fontBtn   = new Font("Century Gothic", Font.BOLD, 18);
        Font fontCheck = new Font("Century Gothic", Font.PLAIN, 16);

        // ---------------- LABELS -------------------

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setFont(fontLabel);
        lblCodigo.setBounds(30, 30, 150, 25);
        add(lblCodigo);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(fontLabel);
        lblTipo.setBounds(30, 75, 150, 25);
        add(lblTipo);

        JLabel lblDesc = new JLabel("Descripción:");
        lblDesc.setFont(fontLabel);
        lblDesc.setBounds(30, 120, 150, 25);
        add(lblDesc);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setFont(fontLabel);
        lblCantidad.setBounds(30, 165, 150, 25);
        add(lblCantidad);

        JLabel lblUnidad = new JLabel("Unidad Medida:");
        lblUnidad.setFont(fontLabel);
        lblUnidad.setBounds(30, 210, 150, 25);
        add(lblUnidad);

        JLabel lblCert = new JLabel("Certificado:");
        lblCert.setFont(fontLabel);
        lblCert.setBounds(30, 255, 150, 25);
        add(lblCert);

        // ---------------- TEXTFIELDS -------------------

        txtCodigo = new JTextField();
        txtCodigo.setBounds(190, 30, 250, 28);
        add(txtCodigo);

        txtTipo = new JTextField();
        txtTipo.setBounds(190, 75, 250, 28);
        add(txtTipo);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(190, 120, 250, 28);
        add(txtDescripcion);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(190, 165, 250, 28);
        add(txtCantidad);

        txtUnidad = new JTextField();
        txtUnidad.setBounds(190, 210, 250, 28);
        add(txtUnidad);

        // ---------------- CHECKBOX -------------------

        chkCertificado = new JCheckBox("Disponible");
        chkCertificado.setFont(fontCheck);
        chkCertificado.setBackground(Color.WHITE);
        chkCertificado.setBounds(190, 255, 200, 30);
        add(chkCertificado);

        // ---------------- BOTONES -------------------

        Color azul = new Color(80, 150, 255);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(40, 320, 120, 35);
        btnGuardar.setBackground(azul);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(fontBtn);
        add(btnGuardar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(170, 320, 120, 35);
        btnBuscar.setBackground(azul);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(fontBtn);
        add(btnBuscar);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(300, 320, 140, 35);
        btnActualizar.setBackground(azul);
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFont(fontBtn);
        add(btnActualizar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(455, 320, 120, 35);
        btnEliminar.setBackground(azul);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(fontBtn);
        add(btnEliminar);

        // Deshabilitar botones de modificación para vendedores
        if (SessionManager.esVendedor()) {
            btnEliminar.setEnabled(false);
        }

        // ---------------- EVENTOS -------------------

        // GUARDAR -> intenta insertar; si ya existe pide usar Actualizar
        btnGuardar.addActionListener(e -> {
            try {
                if (txtCodigo.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese el código antes de guardar.");
                    return;
                }
                int codigo = Integer.parseInt(txtCodigo.getText().trim());

                // Verificar existencia
                MateriaPrima existe = controlador.buscarMateriaPrima(codigo);
                if (existe != null) {
                    JOptionPane.showMessageDialog(this, "Ya existe una materia prima con ese código. Use 'Actualizar'.");
                    return;
                }

                MateriaPrima m = new MateriaPrima();
                m.setCodigo(codigo);
                m.setTipo(txtTipo.getText());
                m.setDescripcion(txtDescripcion.getText());
                m.setCantidadDispo(new BigDecimal(txtCantidad.getText()));
                m.setUnidadMedida(txtUnidad.getText());
                m.setCertificadoDispo(chkCertificado.isSelected());

                boolean ok = controlador.insertarMateriaPrima(m);
                JOptionPane.showMessageDialog(this, ok ? "Materia prima registrada." : "Error al registrar.");
                if (ok) limpiar();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Código y Cantidad deben ser números válidos.");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // BUSCAR -> carga los datos en los campos
        btnBuscar.addActionListener(e -> buscar());

        // ACTUALIZAR -> realiza la actualización si existe
        btnActualizar.addActionListener(e -> {
            try {
                if (txtCodigo.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese el código para actualizar.");
                    return;
                }
                int codigo = Integer.parseInt(txtCodigo.getText().trim());
                MateriaPrima existe = controlador.buscarMateriaPrima(codigo);
                if (existe == null) {
                    JOptionPane.showMessageDialog(this, "No existe una materia prima con ese código. Use 'Guardar' para registrar.");
                    return;
                }

                MateriaPrima m = new MateriaPrima();
                m.setCodigo(codigo);
                m.setTipo(txtTipo.getText());
                m.setDescripcion(txtDescripcion.getText());
                m.setCantidadDispo(new BigDecimal(txtCantidad.getText()));
                m.setUnidadMedida(txtUnidad.getText());
                m.setCertificadoDispo(chkCertificado.isSelected());

                boolean ok = controlador.actualizarMateriaPrima(m);
                JOptionPane.showMessageDialog(this, ok ? "Materia prima actualizada." : "Error al actualizar.");
                if (ok) limpiar();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Código y Cantidad deben ser números válidos.");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // ELIMINAR
        btnEliminar.addActionListener(e -> {
            try {
                if (txtCodigo.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese el código para eliminar.");
                    return;
                }
                int cod = Integer.parseInt(txtCodigo.getText().trim());
                boolean ok = controlador.eliminarMateriaPrima(cod);
                JOptionPane.showMessageDialog(this, ok ? "Materia prima eliminada." : "No existe ese código.");
                if (ok) limpiar();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Código inválido.");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // ya no hay búsqueda automática al presionar Enter
        // txtCodigo.addActionListener(...)  <-- eliminado

        setVisible(true);
    }

    // ---------------- MÉTODOS -------------------

    private void buscar() {
        try {
            if (txtCodigo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el código a buscar.");
                return;
            }
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            MateriaPrima m = controlador.buscarMateriaPrima(codigo);

            if (m == null) {
                JOptionPane.showMessageDialog(this, "No existe una materia prima con ese código.");
                limpiar();
                return;
            }

            txtTipo.setText(m.getTipo());
            txtDescripcion.setText(m.getDescripcion());
            txtCantidad.setText(m.getCantidadDispo() != null ? m.getCantidadDispo().toString() : "");
            txtUnidad.setText(m.getUnidadMedida());
            chkCertificado.setSelected(m.isCertificadoDispo());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código inválido.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar: " + e.getMessage());
        }
    }

    private void limpiar() {
        txtCodigo.setText("");
        txtTipo.setText("");
        txtDescripcion.setText("");
        txtCantidad.setText("");
        txtUnidad.setText("");
        chkCertificado.setSelected(false);
    }
}
