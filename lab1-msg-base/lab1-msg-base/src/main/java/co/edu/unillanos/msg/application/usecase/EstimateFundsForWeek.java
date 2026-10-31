package co.edu.unillanos.msg.application.usecase;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import co.edu.unillanos.msg.application.port.InvestmentRepository;
import co.edu.unillanos.msg.application.port.MortgageRepository;
import co.edu.unillanos.msg.application.port.OperatingExpensesRepository;
import co.edu.unillanos.msg.domain.Investment;
import co.edu.unillanos.msg.domain.Mortgage;

/**
 * Caso de uso: estimar los fondos disponibles para la semana.
 * Rol responsable: Integrador.
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
        BigDecimal total = BigDecimal.ZERO;
        for (Investment investment : investments.findAll()) {
            total = total.add(investment.weeklyReturn());
        }
        return total.setScale(2, RoundingMode.HALF_EVEN);
    }

    /** Suma del aporte semanal de todas las parejas. */
    private BigDecimal totalCoupleContributions() {
        BigDecimal total = BigDecimal.ZERO;
        for (Mortgage mortgage : mortgages.findAll()) {
            total = total.add(mortgage.weeklyCoupleContribution());
        }
        return total.setScale(2, RoundingMode.HALF_EVEN);
    }

    /** Gasto operativo de la semana. */
    private BigDecimal weeklyOperatingExpenses() {
        return expenses.current()
                .weeklyAmount()
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    /** Suma del impuesto y seguro semanal de todas las hipotecas (RN8). */
    private BigDecimal totalEscrowPaid() {
        BigDecimal total = BigDecimal.ZERO;
        for (Mortgage mortgage : mortgages.findAll()) {
            total = total.add(mortgage.weeklyEscrow());
        }
        return total.setScale(2, RoundingMode.HALF_EVEN);
    }
}