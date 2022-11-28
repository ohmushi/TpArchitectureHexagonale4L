package cat.omnes.tp.account.application.port.out;

import cat.omnes.tp.account.domain.Account;
import cat.omnes.tp.account.domain.AccountId;

import java.util.UUID;

public interface AccountRepository {
    Account findById(AccountId id);
    boolean exists(AccountId id);

    void save(Account account);

    default AccountId nextId() {
        return AccountId.of(UUID.randomUUID().toString());
    }
}
