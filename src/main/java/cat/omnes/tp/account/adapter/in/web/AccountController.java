package cat.omnes.tp.account.adapter.in.web;

import cat.omnes.tp.account.application.port.in.AccountBalanceQuery;
import cat.omnes.tp.account.application.port.in.SendMoneyCommand;
import cat.omnes.tp.account.application.services.GetAccountBalanceService;
import cat.omnes.tp.account.application.services.RegisterAccountService;
import cat.omnes.tp.account.application.services.SendMoneyService;
import cat.omnes.tp.account.domain.AccountId;
import cat.omnes.tp.account.domain.Money;

import java.math.BigDecimal;

public final class AccountController {

    private final SendMoneyService sendMoneyService;
    private final RegisterAccountService registerAccountService;
    private final GetAccountBalanceService getAccountBalanceService;

    public AccountController(
            SendMoneyService sendMoneyService,
            RegisterAccountService registerAccountService,
            GetAccountBalanceService getAccountBalanceService
    ) {
        this.sendMoneyService = sendMoneyService;
        this.registerAccountService = registerAccountService;
        this.getAccountBalanceService = getAccountBalanceService;
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

    public BigDecimal getAccountBalance(String id) {
        return this.getAccountBalanceService
                .getAccountBalance(new AccountBalanceQuery(AccountId.of(id)))
                .value();
    }
}
