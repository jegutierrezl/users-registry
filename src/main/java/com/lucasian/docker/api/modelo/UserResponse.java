package com.lucasian.docker.api.modelo;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class UserResponse {

  private Integer id;

  private String username;

  private String nombreCompleto;

  private String email;

  private String passwordEnmascarado;
}
