package co.edu.unillanos.msg.application.port;

import co.edu.unillanos.msg.domain.Investment;

import java.util.List;

/** Puerto: lo que la aplicación necesita para guardar y recuperar inversiones. */
public interface InvestmentRepository {

    void save(Investment investment);

    List<Investment> findAll();
}
