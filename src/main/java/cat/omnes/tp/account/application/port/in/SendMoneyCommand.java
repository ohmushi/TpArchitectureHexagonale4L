package cat.omnes.tp.account.application.port.in;

import cat.omnes.tp.account.application.services.AccountApplication;
import cat.omnes.tp.account.domain.AccountId;
import cat.omnes.tp.account.domain.Money;

import java.math.BigDecimal;
import java.util.Objects;

public final class SendMoneyCommand {

    public final AccountId idSender;
    public final AccountId idReceiver;
    public final Money amount;

    public SendMoneyCommand(AccountId idSender, AccountId idReceiver, Money amount) {
        this.idSender = Objects.requireNonNull(idSender);
        this.idReceiver = Objects.requireNonNull(idReceiver);
        this.amount = Objects.requireNonNull(amount);
        if(!amount.isPositive()) {
            throw AccountApplication.wrongTransferMoney(amount);
        }
    }
}
