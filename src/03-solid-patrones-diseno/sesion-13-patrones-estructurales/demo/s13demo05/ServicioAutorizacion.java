package s13demo05;

public class ServicioAutorizacion {
    public boolean tienePermiso(Usuario usuario) {
        return usuario != null && usuario.estaAutorizado();
    }
}
