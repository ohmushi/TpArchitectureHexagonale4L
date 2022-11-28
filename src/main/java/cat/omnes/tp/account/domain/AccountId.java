package cat.omnes.tp.account.domain;

import java.util.Objects;

final class AccountId {
    private final String value;

    private AccountId(String value) {
        final var cleaned = Objects.requireNonNull(value).trim();
        if(cleaned.isBlank()) throw new IllegalArgumentException();
        this.value = value;
    }

    public static AccountId of(String value) {
        return new AccountId(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountId accountId = (AccountId) o;
        return value.equals(accountId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "AccountId{" +
                "value='" + value + '\'' +
                '}';
    }
}
