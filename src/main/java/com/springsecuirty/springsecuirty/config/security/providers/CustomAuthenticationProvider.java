package com.springsecuirty.springsecuirty.config.security.providers;

import com.springsecuirty.springsecuirty.config.security.authentications.CustomAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Value("${our.very.very.very.secret.key}")
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //* the AuthenticationProvider take the authentication and check for the key
        //* if the same key provided then it authenticate the user


        CustomAuthentication ca = (CustomAuthentication) authentication;
        String headerkey = ca.getKey();
        if (key.equals(headerkey)) {
            return new CustomAuthentication(true, null);

        }

        throw new BadCredentialsException("Oh No !");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //* tell the AuthenticationManager which AuthenticationProvider to use based on the authentication type

        return CustomAuthentication.class.equals(authentication);
    }
}
