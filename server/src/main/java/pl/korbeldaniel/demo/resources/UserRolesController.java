package pl.korbeldaniel.demo.resources;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class UserRolesController implements UserRolesResource {
    private Long userId;

    @Override public String getAll() {
        return userId + "=r1, r2, r3";
    }

    @Override public String getById(Long id) {
        return "userId " + userId + "roleId=" + id;
    }

    UserRolesResource withUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}
