package cat.omnes.tp.account.application.port.out;

import cat.omnes.tp.account.domain.Account;

@FunctionalInterface
public interface CreateAccountPort {
    void create(Account account);
}
