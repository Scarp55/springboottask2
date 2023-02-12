package ru.pivovarov.springboottask2.repository;

import org.springframework.stereotype.Repository;
import ru.pivovarov.springboottask2.model.Authorities;
import ru.pivovarov.springboottask2.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    List<User> userList = new ArrayList<>();

    public UserRepository() {
        userList.add(new User("admin", "123", List.of(Authorities.WRITE, Authorities.READ, Authorities.DELETE)));
        userList.add(new User("developer", "456", List.of(Authorities.READ, Authorities.DELETE)));
        userList.add(new User("worker", "789", List.of(Authorities.READ)));
    }

    public List<Authorities> getUserAuthorities(String name, String password) {
        for (User user : userList) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return user.getAuthoritiesList();
            }
        }
        return new ArrayList<>();
    }
}
