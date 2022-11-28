package cat.omnes.tp.account.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Account {

    private final AccountId id;
    private BigDecimal balance;

    private Account(AccountId id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public static Account create(String id, BigDecimal balance) {
        return new Account(
                AccountId.of(id),
                balance
        );
    }

    public void deposit(BigDecimal amount) {
        this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        this.balance.subtract(amount);
    }


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
}
