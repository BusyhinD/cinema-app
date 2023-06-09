package cinema.util;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;
    private final AuthenticationService authenticationService;

    public DataInitializer(RoleService roleService, UserService userService,
                           AuthenticationService authenticationService) {
        this.roleService = roleService;
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @PostConstruct
    public void inject() {
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(userRole);
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        authenticationService.register("user@gmail.com", "12345678");
        User admin = new User();
        admin.setPassword("87654321");
        admin.setEmail("admin@gmail.com");
        admin.setRoles(Set.of(adminRole));
        userService.add(admin);
        User adminUser = new User();
        adminUser.setPassword("87651234");
        adminUser.setEmail("adminUser@gmail.com");
        adminUser.setRoles(Set.of(adminRole, userRole));
        userService.add(adminUser);
    }
}
