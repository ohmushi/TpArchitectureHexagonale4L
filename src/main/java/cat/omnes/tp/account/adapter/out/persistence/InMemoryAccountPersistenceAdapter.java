package cat.omnes.tp.account.adapter.out.persistence;

import cat.omnes.tp.account.application.port.out.AccountPersistencePort;
import cat.omnes.tp.account.domain.Account;
import cat.omnes.tp.account.domain.AccountId;
import cat.omnes.tp.account.domain.Money;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class InMemoryAccountPersistenceAdapter implements AccountPersistencePort {

    final Map<String, Account> registry = new HashMap<>(Map.of(
            "1", Account.create(AccountId.of("1"), Money.of(BigDecimal.ONE)),
            "2", Account.create(AccountId.of("2"), Money.of(BigDecimal.TWO)),
            "3", Account.create(AccountId.of("3"), Money.of(BigDecimal.TEN))
    ));

    @Override
    public Account load(AccountId id) {
        return this.registry.get(id.value());
    }

    @Override
    public void create(Account account) {

    }

    @Override
    public void update(Account account) {

    }
}
