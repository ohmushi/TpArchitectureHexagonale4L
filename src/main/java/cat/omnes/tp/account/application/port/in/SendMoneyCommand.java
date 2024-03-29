package cat.omnes.tp.account.application.port.in;

import cat.omnes.tp.account.application.services.AccountApplicationException;
import cat.omnes.tp.account.domain.AccountId;
import cat.omnes.tp.account.domain.Money;
import cat.omnes.tp.account.kernel.Command;

import java.util.Objects;

public final class SendMoneyCommand implements Command {

    public final AccountId idSender;
    public final AccountId idReceiver;
    public final Money amount;

    public SendMoneyCommand(AccountId idSender, AccountId idReceiver, Money amount) {
        this.idSender = Objects.requireNonNull(idSender);
        this.idReceiver = Objects.requireNonNull(idReceiver);
        this.amount = Objects.requireNonNull(amount);
        if(!amount.isPositive()) {
            throw AccountApplicationException.wrongTransferMoney(amount);
        }
    }
}
