package cat.omnes.tp.account.application.services;

import cat.omnes.tp.account.application.port.in.SendMoneyCommand;
import cat.omnes.tp.account.application.port.in.SendMoneyUseCase;
import cat.omnes.tp.account.application.port.out.AccountPersistencePort;

import java.util.Objects;

public final class SendMoneyService implements SendMoneyUseCase {

    private final AccountPersistencePort accounts;

    public SendMoneyService(AccountPersistencePort accounts) {
        this.accounts = accounts;
    }

    @Override
    public void sendMoney(SendMoneyCommand command) {
        Objects.requireNonNull(command);

        final var sender = this.accounts.load(command.idSender);
        final var receiver = this.accounts.load(command.idReceiver);

        sender.withdraw(command.amount);
        receiver.deposit(command.amount);

        this.accounts.update(sender);
        this.accounts.update(receiver);
    }
}
