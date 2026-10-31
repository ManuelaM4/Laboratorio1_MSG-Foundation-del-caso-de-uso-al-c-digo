package co.edu.unillanos.msg.infrastructure;

import co.edu.unillanos.msg.application.port.MortgageRepository;
import co.edu.unillanos.msg.domain.Mortgage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Implementación en memoria del puerto MortgageRepository. */
public final class InMemoryMortgageRepository implements MortgageRepository {

    private final Map<String, Mortgage> byNumber = new LinkedHashMap<>();

    @Override
    public void save(Mortgage mortgage) {
        byNumber.put(mortgage.mortgageNumber(), mortgage);
    }

    @Override
    public Optional<Mortgage> findByNumber(String mortgageNumber) {
        return Optional.ofNullable(byNumber.get(mortgageNumber));
    }

    @Override
    public List<Mortgage> findAll() {
        return List.copyOf(byNumber.values());
    }
}
