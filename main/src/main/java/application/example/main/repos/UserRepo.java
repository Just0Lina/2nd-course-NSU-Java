package application.example.main.repos;

import application.example.main.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//public interface UserRepo extends CrudRepository<User, Integer> {
//    List<User> findByName(String name);
//}

public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);

    User findByActivationCode(String code);
}