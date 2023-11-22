package cat.omnes.tp.account.application.services;

import cat.omnes.tp.account.application.port.in.RegisterAccountUseCase;
import cat.omnes.tp.account.application.port.out.AccountPersistencePort;
import cat.omnes.tp.account.domain.Account;
import cat.omnes.tp.account.domain.AccountId;
import cat.omnes.tp.account.domain.Money;

public class RegisterAccountService implements RegisterAccountUseCase {

    private final AccountPersistencePort accounts;

    public RegisterAccountService(AccountPersistencePort accounts) {
        this.accounts = accounts;
    }

    @Override
    public AccountId registerAccount(Money initialMoney) {
        final var accountId = accounts.nextId();
        final var account = Account.create(accountId, initialMoney);

        this.accounts.create(account);

        return accountId;
    }
}
