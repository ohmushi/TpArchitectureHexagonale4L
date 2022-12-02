package cat.omnes.tp.account.adapter.in.web;

import cat.omnes.tp.account.application.port.in.SendMoneyCommand;
import cat.omnes.tp.account.application.services.AccountService;
import cat.omnes.tp.account.domain.AccountId;
import cat.omnes.tp.account.domain.Money;

import java.math.BigDecimal;

public final class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public void sendMonney(String idSender, String idReceiver, BigDecimal initialBalance) {
        final var command = new SendMoneyCommand(
                AccountId.of(idSender),
                AccountId.of(idReceiver),
                Money.of(initialBalance)
        );
        this.accountService.sendMoney(command);
    }
}
