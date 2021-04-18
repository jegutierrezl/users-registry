package com.lucasian.docker.api.modelo;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class UserRequest {

  private String username;

  private String nombre;

  private String apellido;

  private String email;

  private String password;
}
