package com.lucasian.docker.api.servicios;


import com.lucasian.docker.api.modelo.UserEntity;

import java.util.Optional;

public interface UserService {


    public Optional<UserEntity> getUsuarioById (final Integer id );

    public UserEntity createUsuario ( final UserEntity user );

}
