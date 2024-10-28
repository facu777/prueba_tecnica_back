package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // permite CORS en todas las rutas
                .allowedOrigins("http://localhost:3000") // origen permitido, cambia este valor según sea necesario
                .allowedMethods("GET", "POST", "PUT", "DELETE") // métodos permitidos
                .allowedHeaders("*") // cabeceras permitidas
                .allowCredentials(true); // permite enviar cookies o credenciales
    }
}
