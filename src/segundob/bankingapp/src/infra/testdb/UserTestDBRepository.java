package src.segundob.bankingapp.src.infra.testdb;

import java.util.List;

import src.segundob.bankingapp.src.domain.dto.UserAccountDTO;
import src.segundob.bankingapp.src.domain.repositories.IUserRepository;

public class UserTestDBRepository implements IUserRepository {

    List<UserAccountDTO> userAccounts;

    @Override
    public UserAccountDTO createUser(UserAccountDTO dto) {
        userAccounts.add(dto);

        return dto;
    }

    @Override
    public UserAccountDTO findUserBy(String document) {
        if (userAccounts != null) {
            return userAccounts.stream()
                    .filter(user -> user.getDocument().equals(document))
                    .findFirst()
                    .orElse(null);
        }

        return null;
    }

}
