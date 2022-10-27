package gcruz.photocollection.mspcuser.service.impl;

import gcruz.photocollection.mspcuser.dto.UserDTO;
import gcruz.photocollection.mspcuser.exceptions.LoginNotFoundException;
import gcruz.photocollection.mspcuser.exceptions.LoginUnauthorizedException;
import gcruz.photocollection.mspcuser.exceptions.UserConflictException;
import gcruz.photocollection.mspcuser.exceptions.UserNotFoundException;
import gcruz.photocollection.mspcuser.mappers.UserDtoToLoginMapper;
import gcruz.photocollection.mspcuser.model.Login;
import gcruz.photocollection.mspcuser.repository.ILoginRepository;
import gcruz.photocollection.mspcuser.restclient.IUserRestClient;
import gcruz.photocollection.mspcuser.service.ILoginService;
import gcruz.photocollection.mspcuser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final UserDtoToLoginMapper userDtoToLoginMapper;

    @Autowired
    private final ILoginRepository loginRepository;

    @Autowired
    private final IUserService userService;

    public LoginServiceImpl(PasswordEncoder passwordEncoder, UserDtoToLoginMapper userDtoToLoginMapper, ILoginRepository loginRepository, IUserRestClient userRestClient, IUserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userDtoToLoginMapper = userDtoToLoginMapper;
        this.loginRepository = loginRepository;
        this.userService = userService;
    }

    @Override
    public Login getLoginByUserId(Integer userId) throws LoginNotFoundException {
        Optional<Login> opLogin = loginRepository.findById(userId);
        if(!opLogin.isPresent()){
            throw new LoginNotFoundException("Login not found by userId");
        }
        return opLogin.get();
    }


    @Override
    public UserDTO existsLoginAndUserByUserNameAndPassword(String userName, String password) throws UserNotFoundException, UserConflictException, LoginNotFoundException, LoginUnauthorizedException {
        UserDTO userDTO = this.userService.getUserByUserName(userName);
        Login login = this.getLoginByUserId(userDTO.getId());
        if(passwordEncoder.matches(login.getPassword(),password)){
            throw  new LoginUnauthorizedException("Login Invalid");
        }
        return userDTO;
    }

    @Override
    public List<UserDTO> createAllLoginFromJsonPlaceHolderUsers() throws UserNotFoundException {
        List<UserDTO> lstUserDTO = userService.getAllUsers();

        assert lstUserDTO != null;
        lstUserDTO.forEach(userDTO -> {
            Login login = userDtoToLoginMapper.covertTo(userDTO);
            login.setPassword(passwordEncoder.encode("abc123456"));
            login.setActive(false);
            Login loginSave = loginRepository.save(login);
            if(loginSave.getId() != null && loginSave.getId()!=0){
                userDTO.setCreateLogin(true);
            }
        });
        return lstUserDTO;
    }
}
