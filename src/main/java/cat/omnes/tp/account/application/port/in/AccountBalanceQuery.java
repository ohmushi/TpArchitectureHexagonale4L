package cat.omnes.tp.account.application.port.in;

import cat.omnes.tp.account.domain.AccountId;
import cat.omnes.tp.account.kernel.Query;

import java.util.Objects;

public final class AccountBalanceQuery implements Query {
    public final AccountId id;

    public AccountBalanceQuery(AccountId id) {
        this.id = Objects.requireNonNull(id);
    }
}
