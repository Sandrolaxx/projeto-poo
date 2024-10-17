package src.segundob.bankingappdois.src.infra.testdb;

import java.util.ArrayList;
import java.util.List;

import src.segundob.bankingappdois.src.domain.dto.UserAccountDTO;
import src.segundob.bankingappdois.src.domain.repositories.IUserRepository;

public class UserTestDBRepository implements IUserRepository {

    List<UserAccountDTO> userList = new ArrayList<>();

    @Override
    public UserAccountDTO createUser(UserAccountDTO dto) {
        userList.add(dto);

        return dto;
    }

    @Override
    public UserAccountDTO findUserBy(String document) {
    
        for (UserAccountDTO userAccountDTO : userList) {
            if (userAccountDTO.getDocument().equals(document)) {
                return userAccountDTO;
            }
        }
        
        return null;
    }
    
}
