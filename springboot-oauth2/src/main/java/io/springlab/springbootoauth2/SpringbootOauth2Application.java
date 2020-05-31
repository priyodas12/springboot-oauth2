package io.springlab.springbootoauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
/*
*localhost:9992/oauth/token
*localhost:9992/oauth/check_token?token=23d3d076-7eb7-4c50-8e6f-3c0f4fb873ca
*/
@SpringBootApplication
@EnableAuthorizationServer
public class SpringbootOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootOauth2Application.class, args);
	}


}
