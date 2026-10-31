package co.edu.unillanos.msg.application.usecase;

import java.math.BigDecimal;

/** Datos que digita el usuario para registrar una hipoteca. */
public record RegisterMortgageRequest(
        String mortgageNumber,
        BigDecimal weeklyPrincipalAndInterest,
        BigDecimal annualPropertyTax,
        BigDecimal annualInsurancePremium,
        BigDecimal coupleWeeklyIncome) {
}
