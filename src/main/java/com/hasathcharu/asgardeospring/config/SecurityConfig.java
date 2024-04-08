package com.hasathcharu.asgardeospring.config;


import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.proc.DefaultJOSEObjectTypeVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import org.springframework.security.config.web.server.ServerHttpSecurity.CsrfSpec;


@Configuration
public class SecurityConfig{

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String jwks;

    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .csrf(CsrfSpec::disable)
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/api/public/**")
                        .permitAll()
                        .pathMatchers("/api/admin/**").hasAuthority("SCOPE_admin")
                        .anyExchange()
                        .authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtDecoder(customDecoder())));
        return http.build();
    }

    private ReactiveJwtDecoder customDecoder() {
        return NimbusReactiveJwtDecoder.withJwkSetUri(jwks)
                .jwtProcessorCustomizer(customizer->customizer.setJWSTypeVerifier(new DefaultJOSEObjectTypeVerifier<>(new JOSEObjectType("at+jwt"))))
                .build();
    }

}
