package cat.omnes.tp.account.application.port.in;

import cat.omnes.tp.account.domain.AccountException;

@FunctionalInterface
public interface SendMoneyUseCase {
    void sendMoney(SendMoneyCommand command);
}
