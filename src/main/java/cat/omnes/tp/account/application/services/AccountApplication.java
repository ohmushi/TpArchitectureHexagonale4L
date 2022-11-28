package cat.omnes.tp.account.application.services;

import cat.omnes.tp.account.domain.AccountId;
import cat.omnes.tp.account.domain.Money;

public class AccountApplication extends RuntimeException {

    private AccountApplication(String message) {
        super(message);
    }

    public static AccountApplication wrongTransferMoney(Money amount) {
        return new AccountApplication("wrongTransferMoney " + amount.value());
    }

    public static AccountApplication alreadyExist(AccountId id) {
        return new AccountApplication("Account id " + id.value() + " already exists.");
    }
}
