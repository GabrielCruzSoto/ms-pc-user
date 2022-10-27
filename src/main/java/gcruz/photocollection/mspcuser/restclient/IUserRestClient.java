package gcruz.photocollection.mspcuser.restclient;

import gcruz.photocollection.mspcuser.dto.UserDTO;
import org.apache.tomcat.jni.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value ="jsonplaceholder-user", url="${jsonplaceholder-user.url}")
public interface IUserRestClient {

    @GetMapping()
    ResponseEntity<List<UserDTO>> getUserById(@RequestParam(name="id")Integer id);

    @GetMapping()
    ResponseEntity<List<UserDTO>> getUserByUserName(@RequestParam(name="username")String userName);


    @GetMapping()
    ResponseEntity<List<UserDTO>> getAllUsers();

}
