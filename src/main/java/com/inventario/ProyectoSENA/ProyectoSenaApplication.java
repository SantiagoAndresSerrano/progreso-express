package com.inventario.ProyectoSENA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication()
//@ComponentScan(basePackages = {"com.inventario.ProyectoSENA.Controlador"})
//@EntityScan("com.inventario.ProyectoSENA.Modelo")

public class ProyectoSenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoSenaApplication.class, args);
	}
//   @Bean
//   public WebMvcConfigurer corsConfigurer() {
//      return new WebMvcConfigurerAdapter() {
//         @Override
//         public void addCorsMappings(CorsRegistry registry) {
//            registry.addMapping("/usuario/guardar").allowedOrigins("http://localhost:4200/registro");
//         }
//      };
//   }
}

