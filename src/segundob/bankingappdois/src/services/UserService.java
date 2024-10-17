package src.segundob.bankingappdois.src.services;

import java.util.UUID;

import src.segundob.bankingappdois.src.domain.dto.LoginDTO;
import src.segundob.bankingappdois.src.domain.dto.UserAccountDTO;
import src.segundob.bankingappdois.src.domain.repositories.IUserInterface;
import src.segundob.bankingappdois.src.domain.repositories.IUserRepository;

public class UserService {
    
    private IUserInterface userInterface;

    private IUserRepository userRepository;

    public UserService(IUserInterface userInterface, IUserRepository userRepository) {
        this.userInterface = userInterface;
        this.userRepository = userRepository;
    }

    public UserAccountDTO handleLogin() {
        LoginDTO login = userInterface.getLoginData();

        UserAccountDTO user = userRepository.findUserBy(login.getDocument());

        if (user == null) {
            //Será trocado pela nossa exception customizada
            userInterface.showErrorMsg("Usuário não encontrado!");
        }
        
        return user;
    }

    public UserAccountDTO handleOnboardingAcc() {
        UserAccountDTO user = userInterface.getCreateUserData();

        user.setId(UUID.randomUUID().toString());

        userRepository.createUser(user);

        return user;
    }

}
