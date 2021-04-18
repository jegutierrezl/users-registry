package com.lucasian.docker.api.repositorios;

import com.lucasian.docker.api.modelo.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * Repositorio JPA para interaccion con la entidad CLIMA_DIA
 * de la base de datos
 *
 * @author Jairo Gutierrez
 * @version 1.0.0
 * @date 2021-03-29
 */
public interface UserRepository extends CrudRepository<UserEntity,Integer> {


}
