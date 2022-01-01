package mvc.service;

import mvc.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    void addRole(Role role);

    void updateRole(Role role);

    void removeRoleById(long id);

    List<Role> getAllRoles();

    Role getRoleByName(String name);

    Set<Role> getRoleSetFromStrings(String[] roleNames);
}
