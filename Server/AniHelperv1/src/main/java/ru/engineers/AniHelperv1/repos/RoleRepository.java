package ru.engineers.AniHelperv1.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.engineers.AniHelperv1.enteties.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
