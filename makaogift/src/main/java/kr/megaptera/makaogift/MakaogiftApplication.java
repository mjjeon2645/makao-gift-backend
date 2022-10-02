package kr.megaptera.makaogift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.argon2.*;
import org.springframework.security.crypto.password.*;

@SpringBootApplication
public class MakaogiftApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakaogiftApplication.class, args);
	}

	@Bean
	public WebSecurityCustomizer ignoringCustomizer() {
		return (web) -> web.ignoring().antMatchers("/**");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new Argon2PasswordEncoder();
	}
}
