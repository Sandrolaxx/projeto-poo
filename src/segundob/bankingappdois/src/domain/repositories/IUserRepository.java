package src.segundob.bankingappdois.src.domain.repositories;

import src.segundob.bankingappdois.src.domain.dto.UserAccountDTO;

public interface IUserRepository {

    UserAccountDTO createUser(UserAccountDTO dto);

    UserAccountDTO findUserBy(String document);

}
