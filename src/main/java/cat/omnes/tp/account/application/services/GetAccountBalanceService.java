package cat.omnes.tp.account.application.services;

import cat.omnes.tp.account.application.port.in.AccountBalanceQuery;
import cat.omnes.tp.account.application.port.in.GetAccountBalanceUseCase;
import cat.omnes.tp.account.application.port.out.AccountPersistencePort;
import cat.omnes.tp.account.domain.Money;

import java.math.BigDecimal;

public class GetAccountBalanceService implements GetAccountBalanceUseCase {
    private final AccountPersistencePort accounts;

    public GetAccountBalanceService(AccountPersistencePort accounts) {
        this.accounts = accounts;
    }

    @Override
    public Money getAccountBalance(AccountBalanceQuery query) {

        return Money.of(BigDecimal.ZERO);
    }
}
