package s13demo02;

public class S13Demo02DecoratorMain {
    public static void main(String[] args) {
        System.out.println("*** Notificación Base:");
        Notificador base = new NotificadorBase();
        new ModuloNotificaciones(base).avisar("Hola");

        System.out.println("*** Notificación DecoradorPrefijo:");
        new ModuloNotificaciones(new DecoradorPrefijo(base)).avisar("Hola");
        System.out.println("*** Notificación DecoradorAuditoria:");
        new ModuloNotificaciones(new DecoradorAuditoria(base)).avisar("Hola");

        System.out.println("*** Auditoria exterior:");
        //new ModuloNotificaciones(new DecoradorAuditoria(new DecoradorPrefijo(base))).avisar("Hola");
        // 1. Tenemos el notificador original
        Notificador baseAuditoriaExterior = new NotificadorBase();

        // 2. Envolvemos al notificador original
        Notificador conPrefijo = new DecoradorPrefijo(baseAuditoriaExterior);

        // 3. Envolvemos al decorador anterior
        Notificador conAuditoria = new DecoradorAuditoria(conPrefijo);

        // 4. Entregamos la configuración al módulo
        ModuloNotificaciones modulo = new ModuloNotificaciones(conAuditoria);
        modulo.avisar("Hola");

        System.out.println("*** Prefijo exterior:");
        new ModuloNotificaciones(new DecoradorPrefijo(new DecoradorAuditoria(base))).avisar("Hola");
    }
}
