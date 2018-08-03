package dulk.baseMan.pojo;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Long id;

    private String username;

    private String password;

    private String salt;

    private Boolean locked;

    private Set<Role> roles = new HashSet<Role>();
    private Set<String> rolesString;
    private Set<String> rolesPermissionsString;

    public User(Long id, String username, String password, String salt, Boolean locked) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.locked = locked;
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<String> getRolesString() {
        Set<String> roles = new HashSet<String>();
        for (Role role : getRoles()) {
            roles.add(role.getRole());
        }
        return roles;
    }

    public Set<String> getRolesPermissionsString() {
        Set<String> permissions = new HashSet<String>();
        for (Role role : getRoles()) {
            Set<Permission> permissionSet = role.getPermissions();
            for (Permission permission : permissionSet) {
                permissions.add(permission.getPermission());
            }
        }

        return permissions;
    }
}