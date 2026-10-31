package co.edu.unillanos.msg.domain;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class OperatingExpensesTest {

    @Test void weeklyAmountSpreadsAnnualExpensesOver52Weeks() {
        OperatingExpenses e = new OperatingExpenses(new BigDecimal("39000.00"));
        assertEquals(0, new BigDecimal("750.00").compareTo(e.weeklyAmount()));
    }
}
