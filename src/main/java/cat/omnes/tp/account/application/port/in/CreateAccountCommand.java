package cat.omnes.tp.account.application.port.in;

import java.math.BigDecimal;
import java.util.Objects;

public final class CreateAccountCommand {
    public final BigDecimal initialAmount;

    public CreateAccountCommand(BigDecimal initialAmount) {
        this.initialAmount = Objects.requireNonNull(initialAmount);
    }
}
