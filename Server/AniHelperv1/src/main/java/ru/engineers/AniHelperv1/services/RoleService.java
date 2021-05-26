package ru.engineers.AniHelperv1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.engineers.AniHelperv1.enteties.Role;
import ru.engineers.AniHelperv1.repos.RoleRepository;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepo;

    public List<Role> getAll() {
        return roleRepo.findAll();
    }
}
