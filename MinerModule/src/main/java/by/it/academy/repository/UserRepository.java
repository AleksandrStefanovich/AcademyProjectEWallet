package by.it.academy.repository;

import by.it.academy.model.User;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;


public interface UserRepository extends CrudRepository<User, String> {

    User findByUserId(String userId);
}
