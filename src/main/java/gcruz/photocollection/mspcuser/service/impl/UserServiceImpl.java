package gcruz.photocollection.mspcuser.service.impl;

import gcruz.photocollection.mspcuser.dto.UserDTO;
import gcruz.photocollection.mspcuser.exceptions.UserConflictException;
import gcruz.photocollection.mspcuser.exceptions.UserNotFoundException;
import gcruz.photocollection.mspcuser.restclient.IUserRestClient;
import gcruz.photocollection.mspcuser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private final IUserRestClient userRestClient;

    public UserServiceImpl(IUserRestClient userRestClient) {
        this.userRestClient = userRestClient;
    }


    @Override
    public UserDTO getUserById(Integer id) throws UserNotFoundException, UserConflictException {
        List<UserDTO> listUserDTO = userRestClient.getUserById(id).getBody();

        if(listUserDTO.isEmpty()){
            throw new UserNotFoundException("Not found user by id from JsonPlaceHolder");
        }
        if(listUserDTO.size()>1){
            throw new UserConflictException("There are more than two users with the same id, from JsonPlaceHolder");
        }
        return listUserDTO.get(0);
    }

    @Override
    public UserDTO getUserByUserName(String name) throws UserNotFoundException, UserConflictException {
        List<UserDTO> listUserDTO = userRestClient.getUserByUserName(name).getBody();

        if(listUserDTO.isEmpty()){
            throw new UserNotFoundException("Not found user by username from JsonPlaceHolder");
        }
        if(listUserDTO.size()>1){
            throw new UserConflictException("There are more than two users with the same username, from JsonPlaceHolder");
        }
        return listUserDTO.get(0);
    }

    @Override
    public List<UserDTO> getAllUsers() throws UserNotFoundException {
        List<UserDTO> listUserDTO = userRestClient.getAllUsers().getBody();

        if(listUserDTO.isEmpty()){
            throw new UserNotFoundException("Not found users");
        }
        return listUserDTO;
    }
}
