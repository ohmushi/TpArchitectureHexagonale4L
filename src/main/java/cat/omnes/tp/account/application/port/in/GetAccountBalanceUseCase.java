package cat.omnes.tp.account.application.port.in;

import cat.omnes.tp.account.domain.Money;

@FunctionalInterface
public interface GetAccountBalanceUseCase {
    Money getAccountBalance(AccountBalanceQuery query);
}
