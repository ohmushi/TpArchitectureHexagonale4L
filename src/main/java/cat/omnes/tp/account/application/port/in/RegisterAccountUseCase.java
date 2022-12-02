package cat.omnes.tp.account.application.port.in;

import cat.omnes.tp.account.domain.AccountId;
import cat.omnes.tp.account.domain.Money;

public interface RegisterAccountUseCase {
    AccountId registerAccount(Money initialMoney);
}
