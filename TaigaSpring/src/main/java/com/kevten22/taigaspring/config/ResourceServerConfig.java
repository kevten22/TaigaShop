package com.kevten22.taigaspring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter
{

    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources)
    {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").access("hasAnyRole('ROLE_ADMIN')")
                .antMatchers("/users/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_SHOPKEEPER')")
//                .antMatchers("/products/**").access("hasAnyRole('ROLE_ADMIN','ROLE_USER', 'ROLE_SHOPKEEPER')")
//                .antMatchers("/suppliers/**").access("hasAnyRole('ROLE_ADMIN','ROLE_USER', 'ROLE_SHOPKEEPER')")
//                .antMatchers("/carts/**").access("hasAnyRole('ROLE_ADMIN','ROLE_USER', 'ROLE_SHOPKEEPER')")
//                .antMatchers("/cartiems/**").access("hasAnyRole('ROLE_USER','ROLE_SHOPKEEPER', 'ROLE_ADMIN')")
//                .antMatchers("/orders/**").access("hasAnyRole('ROLE_USER','ROLE_SHOPKEEPER', 'ROLE_ADMIN')")
                .antMatchers("/shopkeepers/**").access("hasAnyRole('ROLE_SHOPKEEPER')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
