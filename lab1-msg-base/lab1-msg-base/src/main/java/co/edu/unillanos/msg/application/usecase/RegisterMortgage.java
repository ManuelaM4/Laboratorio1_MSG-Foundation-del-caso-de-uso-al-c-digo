package co.edu.unillanos.msg.application.usecase;

import co.edu.unillanos.msg.application.port.MortgageRepository;
import co.edu.unillanos.msg.domain.Mortgage;

import java.util.Objects;

/**
 * Caso de uso: registrar una hipoteca nueva.
 * Rol responsable: Registro.
 *
 * Decisión D4 (abierta): ¿quién detecta un número de hipoteca repetido,
 * este caso de uso o el repositorio?
 */
public final class RegisterMortgage {

    private final MortgageRepository mortgages;

    public RegisterMortgage(MortgageRepository mortgages) {
        this.mortgages = Objects.requireNonNull(mortgages);
    }

    /**
     * Crea la hipoteca con los datos del request, la guarda y la devuelve.
     * Rechaza con IllegalStateException un número de hipoteca repetido.
     */
    public Mortgage execute(RegisterMortgageRequest request) {
        throw new UnsupportedOperationException("TODO");
    }
}
