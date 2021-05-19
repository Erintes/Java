package ru.engineers.AniHelperv1.repos;

import ru.engineers.AniHelperv1.enteties.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,
        Long> {

    Users findByLogin(String login);
}
