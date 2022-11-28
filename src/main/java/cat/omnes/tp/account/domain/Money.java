package cat.omnes.tp.account.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Money {
    private final BigDecimal value;

    private Money(BigDecimal value) {
        this.value = value;
    }

    public static Money of(BigDecimal amount) {
        return new Money(amount);
    }

    public boolean isPositive() {
        return value.intValue() >= 0;
    }

    public BigDecimal value() {
        return this.value;
    }

    private enum CURRENCY {
        EURO
    }

    public Money add(Money money) {
        return new Money(value.add(money.value));
    }

    public Money minus(Money money) {
        return new Money(value.subtract(money.value));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value.equals(money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + value +
                '}';
    }
}
