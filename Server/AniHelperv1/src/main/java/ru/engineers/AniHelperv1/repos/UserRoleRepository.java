package ru.engineers.AniHelperv1.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.engineers.AniHelperv1.enteties.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
