package co.edu.unillanos.msg.application.port;

import co.edu.unillanos.msg.domain.Mortgage;

import java.util.List;
import java.util.Optional;

/** Puerto: lo que la aplicación necesita para guardar y recuperar hipotecas. */
public interface MortgageRepository {

    void save(Mortgage mortgage);

    Optional<Mortgage> findByNumber(String mortgageNumber);

    List<Mortgage> findAll();
}
