package cat.omnes.tp.account.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Account {

    private final AccountId id;
    private Money balance;

    private Account(AccountId id, Money balance) {
        this.id = id;
        this.balance = balance;
    }

    public static Account create(AccountId id, Money balance) {
        return new Account(
                id,
                balance
        );
    }

    public void deposit(Money amount) {
        validateTransfer(amount);
        this.balance.add(amount);
    }

    private void validateTransfer(Money amount) {
        if(!amount.isPositive()) {
            throw new AccountException("Money transferred cannot be negative");
        }
    }

    public void withdraw(Money amount) {
        validateTransfer(amount);
        this.balance.minus(amount);
    }

    public AccountId id() {
        return this.id;
    }


    //region Equals & hash
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id.equals(account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    //endregion
}
