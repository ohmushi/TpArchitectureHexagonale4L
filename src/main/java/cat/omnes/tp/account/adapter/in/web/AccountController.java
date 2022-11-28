package cat.omnes.tp.account.adapter.in.web;

import cat.omnes.tp.account.application.services.AccountService;

public final class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public void sendMonney(String idSendef, String idReceiver, ) {
        this.accountService.sendMoney();
    }
}
