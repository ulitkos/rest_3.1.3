package mvc.service;

import mvc.model.Role;
import mvc.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void updateRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void removeRoleById(long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findByName(name);
    }

//    @Autowired
//    public void setRoleDao(RoleDao roleDao) {
//        this.roleDao = roleDao;
//    }
//
//    @Override
//    public void addRole(Role role) {
//        roleDao.addRole(role);
//    }
//
//    @Override
//    public void updateRole(Role role) {
//        roleDao.updateRole(role);
//    }
//
//    @Override
//    public void removeRoleById(long id) {
//        roleDao.removeRoleById(id);
//    }
//
//    @Override
//    public List<Role> getAllRoles() {
//        return roleDao.getAllRoles();
//    }
//
//    @Override
//    public Role getRoleByName(String name) {
//        return roleDao.getRoleByName(name);
//    }
//
//    @Override
//    public Set<Role> getRoleSetFromStrings(String[] roleNames) {
//        Set<Role> roleSet = new HashSet<>();
//        for (String role : roleNames) {
//            roleSet.add(getRoleByName(role));
//        }
//        return roleSet;
//    }
}
