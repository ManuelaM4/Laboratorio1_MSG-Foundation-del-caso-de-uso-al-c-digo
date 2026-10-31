package co.edu.unillanos.msg.domain;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class InvestmentTest {

    @Test void weeklyReturnIsAnnualOver52() {
        Investment i = new Investment("I-01", "Bonos del Tesoro", new BigDecimal("52000.00"));
        assertEquals(0, new BigDecimal("1000.00").compareTo(i.weeklyReturn()));
    }
}
