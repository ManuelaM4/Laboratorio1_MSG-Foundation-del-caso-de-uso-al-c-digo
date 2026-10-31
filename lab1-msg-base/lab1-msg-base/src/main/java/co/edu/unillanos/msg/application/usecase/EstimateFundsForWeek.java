package co.edu.unillanos.msg.application.usecase;

import co.edu.unillanos.msg.application.port.InvestmentRepository;
import co.edu.unillanos.msg.application.port.MortgageRepository;
import co.edu.unillanos.msg.application.port.OperatingExpensesRepository;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Caso de uso: estimar los fondos disponibles para la semana.
 * Rol responsable: Integrador.
 *
 * Regla: esta clase no contiene ninguna fórmula de RN2 a RN7.
 * Le pide cada valor a la clase experta y solo suma.
 *
 * Decisión D6 (tomada, revisable): las sumas sobre todas las hipotecas e
 * inversiones están en métodos privados de este caso de uso.
 * ¿Se quedan aquí o pasan a un experto nuevo del dominio?
 */
public final class EstimateFundsForWeek {

    private final MortgageRepository mortgages;
    private final InvestmentRepository investments;
    private final OperatingExpensesRepository expenses;

    public EstimateFundsForWeek(MortgageRepository mortgages,
                                InvestmentRepository investments,
                                OperatingExpensesRepository expenses) {
        this.mortgages = Objects.requireNonNull(mortgages);
        this.investments = Objects.requireNonNull(investments);
        this.expenses = Objects.requireNonNull(expenses);
    }

    public BigDecimal execute() {
        return totalInvestmentIncome()
                .add(totalCoupleContributions())
                .subtract(weeklyOperatingExpenses())
                .subtract(totalEscrowPaid());
    }

    /** Suma del rendimiento semanal de todas las inversiones. */
    private BigDecimal totalInvestmentIncome() {
        throw new UnsupportedOperationException("TODO");
    }

    /** Suma del aporte semanal de todas las parejas. */
    private BigDecimal totalCoupleContributions() {
        throw new UnsupportedOperationException("TODO");
    }

    /** Gasto operativo de la semana. */
    private BigDecimal weeklyOperatingExpenses() {
        throw new UnsupportedOperationException("TODO");
    }

    /** Suma del impuesto y seguro semanal de todas las hipotecas (RN8). */
    private BigDecimal totalEscrowPaid() {
        throw new UnsupportedOperationException("TODO");
    }
}
