package io.springlab.springbootoauth2.oauthconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class UserConfig  extends GlobalAuthenticationConfigurerAdapter {

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("priyo")
                .password("asdn*&&23")
                .roles("USER","ADMIN","DEVMANAGER")
                .authorities("CAN_READ","CAN_WRITE","CAN_DELETE")
                .and()
                .withUser("priya")
                .password("mvcbn*&&23")
                .roles("USER")
                .authorities("CAN_READ","CAN_WRITE","CAN_DELETE");
    }
}
