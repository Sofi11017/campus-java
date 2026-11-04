package s16demo02;

import java.util.concurrent.atomic.AtomicInteger;

public final class ContadorAtomico implements Contador {
    private final AtomicInteger valor = new AtomicInteger();

    @Override
    public void incrementar() {
        valor.incrementAndGet();
    }

    @Override
    public int consultar() {
        return valor.get();
    }
}
