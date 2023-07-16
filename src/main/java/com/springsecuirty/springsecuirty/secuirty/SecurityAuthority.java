package com.springsecuirty.springsecuirty.secuirty;

import com.springsecuirty.springsecuirty.entities.Autority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final Autority autority;
    @Override
    public String getAuthority() {
        return autority.getName();
    }
}
