package gcruz.photocollection.mspcuser.controller;

import gcruz.photocollection.mspcuser.dto.JWTTokenDTO;
import gcruz.photocollection.mspcuser.dto.UserDTO;
import gcruz.photocollection.mspcuser.exceptions.LoginNotFoundException;
import gcruz.photocollection.mspcuser.exceptions.LoginUnauthorizedException;
import gcruz.photocollection.mspcuser.exceptions.UserConflictException;
import gcruz.photocollection.mspcuser.exceptions.UserNotFoundException;
import gcruz.photocollection.mspcuser.service.ILoginService;
import gcruz.photocollection.mspcuser.utils.JwtTokenUtil;
import gcruz.photocollection.mspcuser.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/login")
public class LoginController {

    @Autowired
    private final JwtTokenUtil jwtTokenUtil;
    @Autowired
    private ILoginService loginService;

    public LoginController(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("auth")
    public ResponseEntity<JWTTokenDTO> login(@RequestBody LoginDTO loginDTO) throws LoginNotFoundException, UserNotFoundException, UserConflictException, LoginUnauthorizedException {
        String token = null;
        UserDTO userDTO = this.loginService.existsLoginAndUserByUserNameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
        if(userDTO!=null){
            token = this.jwtTokenUtil.getJWTToken(userDTO.getId(),userDTO.getUsername());
        }
        return ResponseEntity.ok().body(new JWTTokenDTO(200,token));
    }
    @PostMapping("create-users-from-jsonplaceholder")
    public ResponseEntity<?> createAllUsersFromPlaceHolder() throws UserNotFoundException {
        List<UserDTO> lstUserDto = loginService.createAllLoginFromJsonPlaceHolderUsers();
        return ResponseEntity.ok().body(lstUserDto);
    }
}