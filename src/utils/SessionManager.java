package utils;

import modelo.Usuario;

public class SessionManager {
    private static Usuario usuarioActual = null;

    public static void setUsuarioActual(Usuario usuario) {
        usuarioActual = usuario;
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static String getRolActual() {
        return usuarioActual != null ? usuarioActual.getRol() : null;
    }

    public static boolean esVendedor() {
        return usuarioActual != null && "VENDEDOR".equalsIgnoreCase(usuarioActual.getRol());
    }

    public static boolean esAdmin() {
        return usuarioActual != null && "ADMIN".equalsIgnoreCase(usuarioActual.getRol());
    }

    public static void cerrarSesion() {
        usuarioActual = null;
    }
}
