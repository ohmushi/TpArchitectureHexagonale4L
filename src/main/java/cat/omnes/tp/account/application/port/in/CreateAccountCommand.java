package cat.omnes.tp.account.application.port.in;

import cat.omnes.tp.account.kernel.Command;

import java.math.BigDecimal;
import java.util.Objects;

public final class CreateAccountCommand implements Command {
    public final BigDecimal initialAmount;

    public CreateAccountCommand(BigDecimal initialAmount) {
        this.initialAmount = Objects.requireNonNull(initialAmount);
    }
}
