package co.edu.unillanos.msg.application.usecase;

import co.edu.unillanos.msg.infrastructure.InMemoryMortgageRepository;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class RegisterMortgageTest {

    private static BigDecimal bd(String v) { return new BigDecimal(v); }

    private final RegisterMortgageRequest request = new RegisterMortgageRequest("M-001",
            bd("300.00"), bd("2600.00"), bd("1040.00"), bd("1000.00"));

    @Test void savesTheNewMortgage() {
        var repository = new InMemoryMortgageRepository();
        new RegisterMortgage(repository).execute(request);
        assertTrue(repository.findByNumber("M-001").isPresent());
    }

    @Test void rejectsDuplicateMortgageNumber() {
        var register = new RegisterMortgage(new InMemoryMortgageRepository());
        register.execute(request);
        assertThrows(IllegalStateException.class, () -> register.execute(request));
    }
}
