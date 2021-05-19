package ru.engineers.AniHelperv1.services;

import ru.engineers.AniHelperv1.User;
import ru.engineers.AniHelperv1.enteties.Users;
import ru.engineers.AniHelperv1.repos.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public void createUsers(Users users) {
        usersRepository.save(users);
    }

    public Users findByLogin(String login){
        return usersRepository.findByLogin(login);
    }
}
