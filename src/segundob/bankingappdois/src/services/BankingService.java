package src.segundob.bankingappdois.src.services;

import src.segundob.bankingappdois.src.domain.dto.UserAccountDTO;
import src.segundob.bankingappdois.src.domain.repositories.IUserInterface;

public class BankingService {
    
     private IUserInterface userInterface;

    public BankingService(IUserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void execute(UserAccountDTO dto) {
        Integer option = userInterface.showHomeMenu(dto.getName());

        System.out.println(option);
    }

}
