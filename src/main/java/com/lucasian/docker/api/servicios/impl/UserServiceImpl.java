package com.lucasian.docker.api.servicios.impl;

import com.lucasian.docker.api.modelo.UserEntity;
import com.lucasian.docker.api.repositorios.UserRepository;
import com.lucasian.docker.api.servicios.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

/**
 *
 * implementacion spring de los metodos del clima service
 *
 * @author Jairo Gutierrez
 * @version 1.0.0
 * @date 2021-03-29
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

  /**Objeto para interactuar con la entidad Clima_Dia de base de datos*/
  private UserRepository userRepository;

  @Autowired
  public UserServiceImpl(final UserRepository userRepository ){
    this.userRepository = userRepository;
  }

  @Override
  public Optional<UserEntity> getUsuarioById(Integer id) {
    return userRepository.findById(id);
  }

  @Override
  public UserEntity createUsuario(UserEntity user) {
    return userRepository.save(user);
  }
}
