package cat.omnes.tp.account.application.services;

import cat.omnes.tp.account.application.port.out.AccountRepository;
import cat.omnes.tp.account.domain.*;

import java.util.Objects;

public final class AccountService {

    private final AccountRepository accounts;
    private final AccountConfiguration accountConfiguration;

    public AccountService(
            AccountRepository accounts,
            AccountConfiguration accountConfiguration
    ) {
        this.accounts = accounts;
        this.accountConfiguration = accountConfiguration;
    }

    public void sendMoney(AccountId idSender, AccountId idReceiver, Money amount) throws AccountException {
        checkInputSendMoney(idSender, idReceiver, amount);

        final var sender = this.accounts.findById(idSender);
        final var receiver = this.accounts.findById(idReceiver);

        sender.withdraw(amount);
        receiver.deposit(amount);

        this.accounts.save(sender);
        this.accounts.save(receiver);
    }

    private void checkInputSendMoney(AccountId idSender, AccountId idReceiver, Money amount) {
        Objects.requireNonNull(idSender);
        Objects.requireNonNull(idReceiver);

        if(!amount.isPositive()) {
            throw AccountApplication.wrongTransferMoney(amount);
        }
    }

    public AccountId registerAccount(Money initialMoney) {
        final var accountId = accounts.nextId();
        final var account = Account.create(accountId, initialMoney);

        this.accounts.save(account);

        return accountId;
    }


}
