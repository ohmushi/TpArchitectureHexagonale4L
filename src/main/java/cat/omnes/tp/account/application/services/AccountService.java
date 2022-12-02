package cat.omnes.tp.account.application.services;

import cat.omnes.tp.account.application.port.in.RegisterAccountUseCase;
import cat.omnes.tp.account.application.port.in.SendMoneyCommand;
import cat.omnes.tp.account.application.port.in.SendMoneyUseCase;
import cat.omnes.tp.account.application.port.out.AccountRepository;
import cat.omnes.tp.account.domain.*;

import java.util.Objects;

public final class AccountService implements
        SendMoneyUseCase,
        RegisterAccountUseCase
{

    private final AccountRepository accounts;
    private final AccountConfiguration accountConfiguration;

    public AccountService(
            AccountRepository accounts,
            AccountConfiguration accountConfiguration
    ) {
        this.accounts = accounts;
        this.accountConfiguration = accountConfiguration;
    }

    @Override
    public void sendMoney(SendMoneyCommand command) throws AccountException {
        Objects.requireNonNull(command);

        final var sender = this.accounts.findById(command.idSender);
        final var receiver = this.accounts.findById(command.idReceiver);

        sender.withdraw(command.amount);
        receiver.deposit(command.amount);

        this.accounts.save(sender);
        this.accounts.save(receiver);
    }

    @Override
    public AccountId registerAccount(Money initialMoney) {
        final var accountId = accounts.nextId();
        final var account = Account.create(accountId, initialMoney);

        this.accounts.save(account);

        return accountId;
    }


}
