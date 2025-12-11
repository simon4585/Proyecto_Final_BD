package vista;

import controladores.ReportesControlador;
import dto.ProductoPendienteClienteDTO;
import dto.ProductoPendienteDTO;
import modelo.Producto;
import modelo.Colegio;
import modelo.Uniforme;
import dao.ReportesDAO.ProductosVendidosPorColegio;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Reportes extends JFrame {

    private ReportesControlador controlador = new ReportesControlador();

    public Reportes() {

        setTitle("Reportes");
        setSize(520, 420);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        Font fontLabels = new Font("Century Gothic", Font.BOLD, 18);
        Font fontBotones = new Font("Century Gothic", Font.BOLD, 20);

        JLabel lbl = new JLabel("Módulo de Reportes");
        lbl.setFont(fontLabels);
        lbl.setBounds(150, 20, 250, 30);
        add(lbl);

        String[] reportes = {
                "Pedidos pendientes por entregar",
                "Pedidos por cliente",
                "Productos disponibles",
                "Colegios de los que se fabrican uniformes",
                "Colegio las características de su uniforme",
                "Total de productos vendidos por colegio",
                "Total de ventas"
        };

        JList<String> lista = new JList<>(reportes);
        lista.setFont(new Font("Century Gothic", Font.PLAIN, 16));

        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBounds(60, 70, 380, 220);
        add(scroll);

        JButton btnGenerar = new JButton("Generar Reporte");
        btnGenerar.setBounds(160, 310, 200, 40);
        btnGenerar.setBackground(new Color(80, 150, 255));
        btnGenerar.setForeground(Color.WHITE);
        btnGenerar.setFocusPainted(false);
        btnGenerar.setFont(fontBotones);
        add(btnGenerar);

        // ------------------ ACCIÓN DEL BOTÓN -------------------
        btnGenerar.addActionListener(e -> generarReporte(lista.getSelectedIndex()));

        setVisible(true);
    }

    // ---------------------- LÓGICA PRINCIPAL ----------------------
    private void generarReporte(int opcion) {
        switch (opcion) {

            case 0 -> mostrarPendientes();

            case 1 -> {
                String dni = JOptionPane.showInputDialog(this, "Ingrese el DNI:");
                if (dni != null) mostrarPendientesCliente(dni);
            }

            case 2 -> mostrarExistenciaConEncargos();

            case 3 -> mostrarColegios();

            case 4 -> {
                String id = JOptionPane.showInputDialog(this, "Ingrese ID del colegio:");
                if (id != null) mostrarUniformesColegio(Integer.parseInt(id));
            }

            case 5 -> mostrarProductosVendidosColegio();

            case 6 -> mostrarTotalVentas();

            default -> JOptionPane.showMessageDialog(this, "Seleccione un reporte", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    // ------------------- MÉTODOS PARA MOSTRAR REPORTES ---------------------
    //1 Listado de productos encargados pendientes por entregar (ordenados por fecha)
    private void mostrarPendientes() {
        List<ProductoPendienteDTO> lista = controlador.productosPendientes();

        StringBuilder sb = new StringBuilder("productos encargados pendientes por entregar:\n\n");

        for (ProductoPendienteDTO p : lista) {
            sb.append("ID: ").append(p.getIdProducto())
                    .append(" | Tipo: ").append(p.getTipoProducto())
                    .append(" | Desc: ").append(p.getDescripcion())
                    .append(" | Cantidad: ").append(p.getCantidad())
                    .append(" | Fecha pedido: ").append(p.getFechaPedido())
                    .append("\n");
        }

        mostrarTexto(sb.toString());
    }


    // 2) Por cada cliente, listar los productos encargados que no han sido entregados
    private void mostrarPendientesCliente(String dni) {

        List<ProductoPendienteClienteDTO> lista = controlador.productosPendientesPorCliente(dni);

        StringBuilder sb = new StringBuilder(
                "productos encargados que no han sido entregados " + dni + ":\n\n"
        );

        lista.forEach(p ->
                sb.append("Producto: ").append(p.getIdProducto())
                        .append(" | Tipo: ").append(p.getTipoProducto())
                        .append(" | Descripción: ").append(p.getDescripcion())
                        .append(" | Cantidad: ").append(p.getCantidad())
                        .append(" | Pedido #: ").append(p.getIdPedido())
                        .append("\n")
        );

        mostrarTexto(sb.toString());
    }

    // 3) Por cada producto, cantidad en existencia descontando los que están encargados
    private void mostrarExistenciaConEncargos() {
        List<Producto> lista = controlador.existenciaConEncargos();

        StringBuilder sb = new StringBuilder("PRODUCTOS DISPONIBLES:\n\n");
        lista.forEach(p -> sb.append("ID ").append(p.getIdProducto())
                .append(" | Tipo: ").append(p.getTipoProducto())
                .append(" | Disponible: ").append(p.getCantidadExistente())
                .append("\n"));

        mostrarTexto(sb.toString());
    }

    // 4) Listado de colegios de los que se fabrican uniformes
    private void mostrarColegios() {
        List<Colegio> lista = controlador.listadoColegios();

        StringBuilder sb = new StringBuilder("colegios de los que se fabrican uniformes:\n\n");
        lista.forEach(c -> sb.append(
                        "ID: ").append(c.getIdColegio())
                .append(" | Nombre: ").append(c.getNombre())
                .append(" | Dirección: ").append(c.getDireccion())
                .append(" | Tel: ").append(c.getTelefono())
                .append("\n")
        );

        mostrarTexto(sb.toString());
    }

    // 5) Dado un colegio las características de su uniforme
    private void mostrarUniformesColegio(int id) {
        List<Uniforme> lista = controlador.uniformesPorColegio(id);

        StringBuilder sb = new StringBuilder("colegio las características de su uniforme " + id + ":\n\n");
        if (lista.isEmpty()) {
            sb.append("No tiene uniformes registrados.");
        } else {
            lista.forEach(u -> sb.append(
                            "ID Uniforme: ").append(u.getIdUniforme())
                    .append(" | Tipo: ").append(u.getTipo())
                    .append(" | Color: ").append(u.getColor())
                    .append(" | Tela: ").append(u.getTipoTela())
                    .append(" | Bordado: ").append(u.isLlevaBordado() ? "Sí" : "No")
                    .append(" | Lugar Bordado: ").append(u.getLugarBordado())
                    .append(" | Tipo Bordado: ").append(u.getTipoBordado())
                    .append(" | Estampado: ").append(u.getEstampado())
                    .append(" | ID Colegio: ").append(u.getIdColegio())
                    .append(" | ID Producto: ").append(u.getIdProducto())
                    .append("\n\n")
            );
        }

        mostrarTexto(sb.toString());
    }

    // 6) Calcular el total de productos vendidos por colegio
    private void mostrarProductosVendidosColegio() {
        List<ProductosVendidosPorColegio> lista = controlador.totalProductosVendidosPorColegio();

        StringBuilder sb = new StringBuilder("total de productos vendidos por colegio:\n\n");
        lista.forEach(r -> sb.append("Colegio: ").append(r.getNombreColegio())
                .append(" | Producto ").append(r.getIdProducto())
                .append(" | Vendidos ").append(r.getTotalVendidos())
                .append("\n"));

        mostrarTexto(sb.toString());
    }

    // 7) Calcular el total de ventas (dinero)
    private void mostrarTotalVentas() {
        var total = controlador.totalVentas();
        mostrarTexto("TOTAL DE VENTAS: $" + total);
    }

    // ------------------- VISOR DE RESULTADOS ---------------------
    private void mostrarTexto(String texto) {
        JTextArea area = new JTextArea(texto);
        area.setEditable(false);
        area.setFont(new Font("Consolas", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(500, 350));

        JOptionPane.showMessageDialog(this, scroll, "Resultado", JOptionPane.PLAIN_MESSAGE);
    }
}
