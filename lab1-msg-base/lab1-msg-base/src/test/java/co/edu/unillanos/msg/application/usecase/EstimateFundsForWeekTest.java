package co.edu.unillanos.msg.application.usecase;

import co.edu.unillanos.msg.domain.*;
import co.edu.unillanos.msg.infrastructure.*;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class EstimateFundsForWeekTest {

    private static BigDecimal bd(String v) { return new BigDecimal(v); }

    @Test void estimatesFundsWithCaseData() {
        var mortgages = new InMemoryMortgageRepository();
        var investments = new InMemoryInvestmentRepository();
        var expenses = new InMemoryOperatingExpensesRepository(
                new OperatingExpenses(bd("39000.00")));

        var register = new RegisterMortgage(mortgages);
        register.execute(new RegisterMortgageRequest("M-001",
                bd("300.00"), bd("2600.00"), bd("1040.00"), bd("1000.00")));
        register.execute(new RegisterMortgageRequest("M-002",
                bd("200.00"), bd("1560.00"), bd("520.00"), bd("1000.00")));
        investments.save(new Investment("I-01", "Bonos del Tesoro", bd("52000.00")));
        investments.save(new Investment("I-02", "CDT", bd("26000.00")));

        var estimate = new EstimateFundsForWeek(mortgages, investments, expenses);

        assertEquals(0, bd("1160.00").compareTo(estimate.execute()));
    }
}
