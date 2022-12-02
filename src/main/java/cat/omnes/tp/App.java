package cat.omnes.tp;

import cat.omnes.tp.account.adapter.in.web.AccountController;
import cat.omnes.tp.account.adapter.out.persistence.InMemoryAccountPersistenceAdapter;
import cat.omnes.tp.account.application.services.RegisterAccountService;
import cat.omnes.tp.account.application.services.SendMoneyService;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        // return this.registry.containsKey(id.value()
        final var accountPersistence = new InMemoryAccountPersistenceAdapter();

        final var sendMoneyService = new SendMoneyService(accountPersistence);
        final var registerAccountService = new RegisterAccountService(accountPersistence);


        final var controller = new AccountController(sendMoneyService, registerAccountService);

        final var idSender = controller.registerAccount(BigDecimal.valueOf(100));
        final var idReceiver = controller.registerAccount(BigDecimal.valueOf(100));

        controller.sendMonney(idSender, idReceiver, BigDecimal.valueOf(50));



    }
}
