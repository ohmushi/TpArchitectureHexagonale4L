package cat.omnes.tp.account.adapter.out.persistence;

import cat.omnes.tp.account.application.port.out.AccountRepository;
import cat.omnes.tp.account.domain.Account;
import cat.omnes.tp.account.domain.AccountId;
import cat.omnes.tp.account.domain.Money;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class InMemoryAccountRepository implements AccountRepository {

    final Map<String, Account> registry = new HashMap<>(Map.of(
            "1", Account.create("1", Money.of(BigDecimal.ONE)),
            "2", Account.create("1", Money.of(BigDecimal.TWO)),
            "3", Account.create("1", Money.of(BigDecimal.TEN))
    ));

    @Override
    public Account findById(AccountId id) {
        return this.registry.get(id.value());
    }

    @Override
    public boolean exists(AccountId id) {
        return this.registry.containsKey(id.value());
    }

    @Override
    public void save(Account account) {
        this.registry.put(account.id().value(), account);
    }
}
