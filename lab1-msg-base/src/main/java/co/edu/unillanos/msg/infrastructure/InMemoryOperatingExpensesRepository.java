package co.edu.unillanos.msg.infrastructure;

import co.edu.unillanos.msg.application.port.OperatingExpensesRepository;
import co.edu.unillanos.msg.domain.OperatingExpenses;

import java.util.Objects;

/** Implementación en memoria del puerto OperatingExpensesRepository. */
public final class InMemoryOperatingExpensesRepository implements OperatingExpensesRepository {

    private final OperatingExpenses current;

    public InMemoryOperatingExpensesRepository(OperatingExpenses current) {
        this.current = Objects.requireNonNull(current);
    }

    @Override
    public OperatingExpenses current() {
        return current;
    }
}
