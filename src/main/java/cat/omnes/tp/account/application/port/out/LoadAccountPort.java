package cat.omnes.tp.account.application.port.out;

import cat.omnes.tp.account.domain.Account;
import cat.omnes.tp.account.domain.AccountId;

@FunctionalInterface
public interface LoadAccountPort {
    Account findById(AccountId id);
}
