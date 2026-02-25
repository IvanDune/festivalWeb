package festivalWeb.project.model;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, ARCHITECTURE, MASTER, MARKET, LECTURER, CREATOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
