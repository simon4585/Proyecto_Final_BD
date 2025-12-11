package vista;

import controladores.UsuarioControlador;
import java.awt.*;
import javax.swing.*;
import modelo.Usuario;
import utils.SessionManager;

public class Login extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private UsuarioControlador controlador = new UsuarioControlador();

    public Login() {

        setTitle("Login - Urban Stitch");
        setSize(420, 520);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        setLayout(new GridBagLayout());

        //panel
        RoundedPanel panel = new RoundedPanel(40, Color.WHITE, new Color(80, 150, 255), 4);
        panel.setPreferredSize(new Dimension(330, 430));
        panel.setMaximumSize(new Dimension(330, 430));

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        add(panel);


        JLabel lblTitulo = new JLabel("URBAN STITCH", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 30));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 5, 0));
        panel.add(lblTitulo);

        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Century Gothic", Font.BOLD, 22));
        lblUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblUsuario);

        txtUsuario = new JTextField(15);
        txtUsuario.setMaximumSize(new Dimension(220, 30));
        panel.add(txtUsuario);

        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        JLabel lblClave = new JLabel("Contraseña:");
        lblClave.setFont(new Font("Century Gothic", Font.BOLD, 22));
        lblClave.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblClave);

        txtClave = new JPasswordField(15);
        txtClave.setMaximumSize(new Dimension(220, 30));
        panel.add(txtClave);

        panel.add(Box.createRigidArea(new Dimension(0, 35)));

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("Century Gothic", Font.BOLD, 22));
        btnIngresar.setBackground(new Color(80, 150, 255));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIngresar.setMaximumSize(new Dimension(150, 40));
        panel.add(btnIngresar);

        btnIngresar.addActionListener(e -> {
            String username = txtUsuario.getText().trim();
            String password = new String(txtClave.getPassword());

            System.out.println("DEBUG: Intentando login con usuario: '" + username + "'");
            
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese usuario y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Usuario usuario = controlador.login(username, password);
                System.out.println("DEBUG: Resultado login: " + (usuario != null ? "Exitoso - " + usuario.getRol() : "Fallido"));

                if (usuario != null) {
                    SessionManager.setUsuarioActual(usuario);
                    JOptionPane.showMessageDialog(this, "Bienvenido " + usuario.getUsername() + " (" + usuario.getRol() + ")", "Login Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    SwingUtilities.invokeLater(Menu::new);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error de Login", JOptionPane.ERROR_MESSAGE);
                    txtClave.setText("");
                }
            } catch (HeadlessException ex) {
                System.err.println("ERROR: Excepción durante login: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
