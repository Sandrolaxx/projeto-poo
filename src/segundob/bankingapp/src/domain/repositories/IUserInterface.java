package src.segundob.bankingapp.src.domain.repositories;

import src.segundob.bankingapp.src.domain.dto.LoginDTO;
import src.segundob.bankingapp.src.domain.dto.UserAccountDTO;

public interface IUserInterface {
    
    Integer showInitialScreenMenu();

    Integer showHomeMenu(String userName);

    LoginDTO getLoginData();

    UserAccountDTO getCreateUserData();

    void showErrorMsg(String msg);

    void showExitMessage();

}
