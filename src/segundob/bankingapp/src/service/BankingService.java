package src.segundob.bankingapp.src.service;

import src.segundob.bankingapp.src.domain.dto.UserAccountDTO;
import src.segundob.bankingapp.src.domain.repositories.IUserInterface;

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
