package com.authserver.authorize.configurations;

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
public class AuthServerConfig extends WebSecurityConfigurerAdapter implements AuthorizationServerConfigurer {

    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    public AuthenticationManager authenticationManager () throws Exception {
        return super.authenticationManager();
    }

@Autowired
    AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer config) throws Exception {
config.checkTokenAccess("permitAll()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clientConfig) throws Exception {
clientConfig.inMemory().withClient("web").secret(passwordEncoder.encode("web123")).scopes("READ","WRITE").authorizedGrantTypes("password","authorization_code")
.redirectUris("http://localhost:8095/login");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endPoint) throws Exception {
endPoint.authenticationManager(authenticationManager);
    }
}
