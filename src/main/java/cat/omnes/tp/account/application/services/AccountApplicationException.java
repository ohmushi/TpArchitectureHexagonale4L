package cat.omnes.tp.account.application.services;

import cat.omnes.tp.account.domain.AccountId;
import cat.omnes.tp.account.domain.Money;

public class AccountApplicationException extends RuntimeException {

    private AccountApplicationException(String message) {
        super(message);
    }

    public static AccountApplicationException wrongTransferMoney(Money amount) {
        return new AccountApplicationException("wrongTransferMoney " + amount.value());
    }

    public static AccountApplicationException alreadyExist(AccountId id) {
        return new AccountApplicationException("Account id " + id.value() + " already exists.");
    }
}
