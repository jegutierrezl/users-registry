package com.lucasian.docker.api.controladores;

import com.lucasian.docker.api.modelo.UserEntity;
import com.lucasian.docker.api.modelo.UserRequest;
import com.lucasian.docker.api.modelo.UserResponse;
import com.lucasian.docker.api.servicios.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;

@RestController
@Slf4j
@RequestMapping("/user")
@CrossOrigin(origins = "*",
  methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserRegistryController {

  @Autowired
  private UserService userService;

  @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getUserById (final @RequestParam(name = "userId") Integer userID ){
    return userService
            .getUsuarioById(userID)
            .map(userEntity -> ResponseEntity
                    .ok(mapUserEntityToUserResponse(userEntity)))
            .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserResponse> createUser (final UserRequest user){
    return ResponseEntity.ok(mapUserEntityToUserResponse(
            userService.createUsuario(mapUserRequestToUserEntity(user))));
  }

  private UserResponse mapUserEntityToUserResponse (final UserEntity userEntity){
    return UserResponse.builder().
            email(userEntity.getEmail()).
            id(userEntity.getUsuarioId()).
            nombreCompleto(userEntity.getNombre()+" "+userEntity.getApellido()).
            username(userEntity.getPassword()).
            passwordEnmascarado(hashPassword(userEntity.getPassword())).
            build();
  }


  private UserEntity mapUserRequestToUserEntity (final UserRequest userRequest){
    return UserEntity.builder().
            email(userRequest.getEmail()).
            nombre(userRequest.getNombre()).
            password(userRequest.getPassword()).
            apellido(userRequest.getApellido()).
            build();
  }


  private String hashPassword ( String password )  {
    try{
      final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
      messageDigest.update(password.getBytes());
      return new String(messageDigest.digest());
    }catch (Exception e){
      return "PasswordNotParseable";
    }
  }


}
