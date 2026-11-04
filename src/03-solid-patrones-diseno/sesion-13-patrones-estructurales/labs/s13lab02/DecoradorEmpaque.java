package s13lab02;

import java.util.Objects;

public abstract class DecoradorEmpaque implements Empaque {
    protected final Empaque empaque;

    protected DecoradorEmpaque(Empaque empaque) {
        this.empaque = Objects.requireNonNull(empaque);
    }
}
