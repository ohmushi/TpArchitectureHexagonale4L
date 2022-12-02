package cat.omnes.tp.account.application.services;

import cat.omnes.tp.account.application.port.in.SendMoneyCommand;
import cat.omnes.tp.account.application.port.in.SendMoneyUseCase;
import cat.omnes.tp.account.application.port.out.AccountRepository;
import cat.omnes.tp.account.domain.AccountException;

import java.util.Objects;

public final class SendMoneyService implements SendMoneyUseCase {

    private final AccountRepository accounts;

    public SendMoneyService(AccountRepository accounts) {
        this.accounts = accounts;
    }

    @Override
    public void sendMoney(SendMoneyCommand command) {
        Objects.requireNonNull(command);

        final var sender = this.accounts.findById(command.idSender);
        final var receiver = this.accounts.findById(command.idReceiver);

        sender.withdraw(command.amount);
        receiver.deposit(command.amount);

        this.accounts.save(sender);
        this.accounts.save(receiver);
    }
}
