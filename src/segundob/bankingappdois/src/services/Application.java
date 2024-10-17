package src.segundob.bankingappdois.src.services;

import src.segundob.bankingappdois.src.domain.dto.UserAccountDTO;
import src.segundob.bankingappdois.src.domain.repositories.IUserInterface;
import src.segundob.bankingappdois.src.domain.repositories.IUserRepository;

public class Application {

    public void execute(IUserInterface gui, IUserRepository userRepo) {
        UserService userService = new UserService(gui, userRepo);
        BankingService bankingService = new BankingService(gui);

        while (true) {
            Integer option = gui.showInitialScreenMenu();

            switch (option) {
                case 1:
                    UserAccountDTO user = userService.handleLogin();

                    if (user != null) {
                        bankingService.execute(user);
                    }
                    break;
                case 2:
                    UserAccountDTO createdAcc = userService.handleOnboardingAcc();

                    if (createdAcc != null) {
                        bankingService.execute(createdAcc);
                    }
                    break;
                case 3:
                    gui.showExitMessage();
                    return;
            }
        }

    }

}
