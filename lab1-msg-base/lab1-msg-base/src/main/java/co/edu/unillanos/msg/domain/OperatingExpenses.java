package co.edu.unillanos.msg.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Gastos operativos anuales estimados de la MSG Foundation.
 * Rol responsable: Inversiones.
 */
public final class OperatingExpenses {

    private final BigDecimal annualAmount;

    public OperatingExpenses(BigDecimal annualAmount) {
        this.annualAmount = Objects.requireNonNull(annualAmount);
    }

    public BigDecimal annualAmount() {
        return annualAmount;
    }

    /** RN7: gasto anual repartido igual entre 52 semanas, con 2 decimales. */
    public BigDecimal weeklyAmount() {
        throw new UnsupportedOperationException("TODO");
    }
}
