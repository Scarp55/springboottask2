package ru.pivovarov.springboottask2.repository;

import org.springframework.stereotype.Repository;
import ru.pivovarov.springboottask2.model.Authorities;
import ru.pivovarov.springboottask2.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {

    private final User admin = new User("admin", "123");
    private final User developer = new User("developer", "456");
    private final User worker = new User("worker", "789");
    private final List<Authorities> adminAuthorities = Arrays.asList(Authorities.DELETE, Authorities.READ, Authorities.WRITE);
    private final List<Authorities> developerAuthorities = Arrays.asList(Authorities.DELETE, Authorities.READ);
    private final List<Authorities> workerAuthorities = List.of(Authorities.READ);


    public List<Authorities> getUserAuthorities(String user, String password) {
        if (admin.getName().equals(user) && (admin.getPassword().equals(password))) {
            return adminAuthorities;
        } else if (developer.getName().equals(user) && (developer.getPassword().equals(password))) {
            return developerAuthorities;
        } else if (worker.getName().equals(user) && (worker.getPassword().equals(password))) {
            return workerAuthorities;
        }
        return new ArrayList<>();
    }
}
