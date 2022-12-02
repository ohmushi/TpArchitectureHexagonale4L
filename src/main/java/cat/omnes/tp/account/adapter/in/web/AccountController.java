package cat.omnes.tp.account.adapter.in.web;

import cat.omnes.tp.account.application.port.in.SendMoneyCommand;
import cat.omnes.tp.account.application.services.RegisterAccountService;
import cat.omnes.tp.account.application.services.SendMoneyService;
import cat.omnes.tp.account.domain.AccountId;
import cat.omnes.tp.account.domain.Money;

import java.math.BigDecimal;

public final class AccountController {

    private final SendMoneyService sendMoneyService;
    private final RegisterAccountService registerAccountService;

    public AccountController(
            SendMoneyService sendMoneyService,
            RegisterAccountService registerAccountService
    ) {
        this.sendMoneyService = sendMoneyService;
        this.registerAccountService = registerAccountService;
    }

    public void sendMonney(String idSender, String idReceiver, BigDecimal amount) {
        final var command = new SendMoneyCommand(
                AccountId.of(idSender),
                AccountId.of(idReceiver),
                Money.of(amount)
        );
        this.sendMoneyService.sendMoney(command);
    }

    public String registerAccount(BigDecimal initialBalance) {
        final var idRegistered = this.registerAccountService.registerAccount(Money.of(initialBalance));
        return idRegistered.value();
    }
}
