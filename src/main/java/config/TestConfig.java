package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
/* A anotação "@Configuration" é usada para definir uma ou mais configurações de beans, métodos para criar e
* configurar beans, ou importa outras classes de configuração. */
@Profile("test")
public class TestConfig {

}
