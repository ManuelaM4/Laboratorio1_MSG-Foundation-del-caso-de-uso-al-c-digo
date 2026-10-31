package co.edu.unillanos.msg.infrastructure;

import co.edu.unillanos.msg.application.port.InvestmentRepository;
import co.edu.unillanos.msg.domain.Investment;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Implementación en memoria del puerto InvestmentRepository. */
public final class InMemoryInvestmentRepository implements InvestmentRepository {

    private final Map<String, Investment> byId = new LinkedHashMap<>();

    @Override
    public void save(Investment investment) {
        byId.put(investment.investmentId(), investment);
    }

    @Override
    public List<Investment> findAll() {
        return List.copyOf(byId.values());
    }
}
