package io.springlab.springbootoauth2.oauthconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
public class Oauth2Config extends WebSecurityConfigurerAdapter implements AuthorizationServerConfigurer {

    @Bean
    public AuthenticationManager autheticationManagerBean() throws  Exception{
        return super.authenticationManagerBean();
    }

    @Autowired
    AuthenticationManager authenticationManager;

    PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer client) throws Exception {
        client.inMemory()
                .withClient("web")
                .secret(passwordEncoder.encode("webpass"))
                .scopes("READ","WRITE")
                .authorizedGrantTypes("password","authorization");

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer auth) throws Exception {
        auth.authenticationManager(authenticationManager);
    }
}
