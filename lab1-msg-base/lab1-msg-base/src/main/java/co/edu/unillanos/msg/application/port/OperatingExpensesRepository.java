package co.edu.unillanos.msg.application.port;

import co.edu.unillanos.msg.domain.OperatingExpenses;

/** Puerto: lo que la aplicación necesita para conocer los gastos operativos vigentes. */
public interface OperatingExpensesRepository {

    OperatingExpenses current();
}
