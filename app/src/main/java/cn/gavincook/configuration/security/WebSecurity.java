package cn.gavincook.configuration.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author gavincook
 * @since 2023-05-16
 */
@EnableWebSecurity
@Configuration
public class WebSecurity {
    @Value("${service.token}")
    private String serviceToken;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterBefore(new BearerTokenFilter(serviceToken), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests((requests) -> {
                    requests.requestMatchers("/todos/**").authenticated()
                            .anyRequest().permitAll();
                });
        return http.build();
    }
}
