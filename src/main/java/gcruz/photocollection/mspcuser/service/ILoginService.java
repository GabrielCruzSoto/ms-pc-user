package gcruz.photocollection.mspcuser.service;

import gcruz.photocollection.mspcuser.dto.UserDTO;
import gcruz.photocollection.mspcuser.exceptions.LoginNotFoundException;
import gcruz.photocollection.mspcuser.exceptions.LoginUnauthorizedException;
import gcruz.photocollection.mspcuser.exceptions.UserConflictException;
import gcruz.photocollection.mspcuser.exceptions.UserNotFoundException;
import gcruz.photocollection.mspcuser.model.Login;

import java.util.List;

public interface ILoginService {
    Login getLoginByUserId(Integer userId) throws LoginNotFoundException;
    UserDTO existsLoginAndUserByUserNameAndPassword(String userName, String password) throws LoginNotFoundException, UserNotFoundException, UserConflictException, LoginUnauthorizedException;
    List<UserDTO> createAllLoginFromJsonPlaceHolderUsers() throws UserNotFoundException;
}
