package com.lucasian.docker.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

/**
 *
 * Clase que inicializa la aplicación y los beans y controladores de spring
 *
 * @author jairo gutierrez
 * @date   2021-03-29
 * @version 1.0.0
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class UserRegistryApplication {
  /**Logger instance*/
  final Logger LOGGER = LoggerFactory.getLogger(UserRegistryApplication.class);

  /**
   * Main Method
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(UserRegistryApplication.class, args);
  }

  /**
   * Bean for run in command line
   * @param ctx
   * @return
   */
  @Bean
  public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
    return args -> {

      LOGGER.info("Inicializando servicios spring:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        LOGGER.info(beanName);
      }

    };
  }
}
