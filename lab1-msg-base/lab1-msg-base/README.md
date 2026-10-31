# Laboratorio 1 — MSG Foundation

Ingeniería de Software I (603501) — Universidad de los Llanos

Proyecto base del laboratorio. Compila desde el primer minuto, pero los métodos
sin implementar lanzan `UnsupportedOperationException("TODO")`. Por eso
`mvn test` arranca en rojo: cada rol pone en verde sus propias pruebas.

**Las pruebas no se modifican.** Si una parece incorrecta, se discute con el docente.

## Roles

| Rol | Rama | Archivos | Pruebas |
|---|---|---|---|
| Integrador | `feature/estimate-funds` | `EstimateFundsForWeek` | `EstimateFundsForWeekTest` |
| Hipotecas | `feature/mortgage` | `Mortgage` | `MortgageTest` |
| Inversiones | `feature/investment` | `Investment`, `OperatingExpenses` | `InvestmentTest`, `OperatingExpensesTest` |
| Registro | `feature/register-mortgage` | `RegisterMortgage`, `Main` | `RegisterMortgageTest` |

## Parte 0 — Integrador: crear el repositorio

Primero llene la tabla del equipo en `BITACORA.md`. Luego:

```bash
git init -b main
git add .
git commit -m "Código base del Laboratorio 1"
# En GitHub: New repository → lab1-msg-equipoN, público, SIN README
git remote add origin https://github.com/USUARIO/lab1-msg-equipoN.git
git push -u origin main
```

Después, en GitHub:

1. *Settings → Collaborators*: invite a los otros tres miembros.
2. *Settings → Branches*: regla para `main` con *Require a pull request before merging* y una aprobación.

## Parte 0 — Los demás: clonar

Acepte la invitación en `https://github.com/USUARIO/lab1-msg-equipoN/invitations` y luego:

```bash
git clone https://github.com/USUARIO/lab1-msg-equipoN.git
cd lab1-msg-equipoN
mvn test
```

Esperado: compila y las pruebas fallan con `UnsupportedOperationException`.
`BUILD FAILURE` por pruebas fallidas es normal; `COMPILATION ERROR` no lo es.

## Parte B — Trabajar en su rama

```bash
git switch -c feature/mortgage          # la rama de su rol
mvn test -Dtest=MortgageTest            # solo las pruebas de su rol
git add src
git commit -m "Calcula el subsidio semanal de la hipoteca"
git push -u origin feature/mortgage
```

En GitHub: *Compare & pull request* y asigne como revisor a quien indica el enunciado.

## Parte C — Integrar

```bash
git switch main
git pull
mvn test                   # esperado: BUILD SUCCESS
mvn -q compile exec:java   # ejecuta Main; esperado: 1160.00
```

## Entrega

Lo que debe quedar en `main` antes de marcar la entrega:

- `BITACORA.md` con la tabla del equipo completa.
- La carpeta `docs` con un PDF de la tabla de la Parte A (por ejemplo, `docs/parte-a.pdf`).
  Se sube como cualquier otro cambio: en una rama y por pull request.

Luego, solo el Integrador marca la versión entregada:

```bash
git switch main
git pull
git tag lab1-entrega
git push origin lab1-entrega
```

Al salir: cierre su sesión de GitHub en el navegador y borre sus credenciales del computador de la sala.
