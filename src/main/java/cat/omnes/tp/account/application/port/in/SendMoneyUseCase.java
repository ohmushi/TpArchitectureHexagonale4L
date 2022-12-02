package cat.omnes.tp.account.application.port.in;

import cat.omnes.tp.account.domain.AccountException;

public interface SendMoneyUseCase {
    void sendMoney(SendMoneyCommand command) throws AccountException;
}
