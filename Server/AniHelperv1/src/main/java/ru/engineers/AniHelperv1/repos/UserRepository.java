package ru.engineers.AniHelperv1.repos;

import ru.engineers.AniHelperv1.enteties.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,
        Long> {

    User findByUsername(String username);
}
