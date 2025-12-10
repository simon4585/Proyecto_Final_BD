package vista;

import javax.swing.*;

public class Login extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtClave;

    public Login() {
        setTitle("Login - Empresa de Confecciones");
        setSize(350, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblUser = new JLabel("Usuario:");
        lblUser.setBounds(50, 50, 100, 25);
        add(lblUser);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(150, 50, 130, 25);
        add(txtUsuario);

        JLabel lblClave = new JLabel("Contraseña:");
        lblClave.setBounds(50, 95, 100, 25);
        add(lblClave);

        txtClave = new JPasswordField();
        txtClave.setBounds(150, 95, 130, 25);
        add(txtClave);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(110, 150, 120, 30);
        add(btnIngresar);

        btnIngresar.addActionListener(e -> {
            new Menu();
            dispose();
        });

        setVisible(true);
    }
}