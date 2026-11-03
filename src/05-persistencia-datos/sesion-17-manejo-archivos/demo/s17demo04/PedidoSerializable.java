package s17demo04;

import java.io.Serializable;

public final class PedidoSerializable implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String codigo;
    private final String cliente;

    public PedidoSerializable(String codigo, String cliente) {
        this.codigo = codigo;
        this.cliente = cliente;
        validar();
    }

    public void validar() {
        if (codigo == null || cliente == null || codigo.isBlank() || cliente.isBlank()
                || codigo.length() > 64 || cliente.length() > 64
                || codigo.contains(";") || cliente.contains(";")
                || codigo.contains("\n") || cliente.contains("\n")
                || codigo.contains("\r") || cliente.contains("\r")) {
            throw new IllegalArgumentException("Codigo y cliente simples de 1 a 64 caracteres");
        }
    }

    public String comoTexto() {
        return codigo + ";" + cliente;
    }
}
