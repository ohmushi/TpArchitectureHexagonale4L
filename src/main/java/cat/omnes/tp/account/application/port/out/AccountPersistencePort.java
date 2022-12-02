package cat.omnes.tp.account.application.port.out;

import cat.omnes.tp.account.domain.AccountId;

import java.util.UUID;

public interface AccountPersistencePort extends
        CreateAccountPort,
        LoadAccountPort,
        UpdateAccountPort
{

    default AccountId nextId() {
        return AccountId.of(UUID.randomUUID().toString());
    }
}
