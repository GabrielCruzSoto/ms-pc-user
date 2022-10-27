package gcruz.photocollection.mspcuser.service;

import gcruz.photocollection.mspcuser.dto.UserDTO;
import gcruz.photocollection.mspcuser.exceptions.UserConflictException;
import gcruz.photocollection.mspcuser.exceptions.UserNotFoundException;

import java.util.List;

public interface IUserService {
    UserDTO getUserById(Integer id) throws UserNotFoundException, UserConflictException;
    UserDTO getUserByUserName(String name) throws UserNotFoundException, UserConflictException;
    List<UserDTO> getAllUsers() throws UserNotFoundException;

}
