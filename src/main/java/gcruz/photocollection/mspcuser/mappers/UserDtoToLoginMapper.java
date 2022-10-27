package gcruz.photocollection.mspcuser.mappers;

import gcruz.photocollection.mspcuser.dto.UserDTO;
import gcruz.photocollection.mspcuser.model.Login;
import org.springframework.stereotype.Component;


@Component
public class UserDtoToLoginMapper {
    public Login covertTo(UserDTO userDTO){
        Login login = new Login();
        login.setUserId(userDTO.getId());
        login.setUserName(login.getUserName());
        return login;
    }
}
