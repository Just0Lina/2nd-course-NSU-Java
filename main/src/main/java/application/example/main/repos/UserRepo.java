package application.example.main.repos;

import application.example.main.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

//public interface UserRepo extends CrudRepository<User, Integer> {
//    List<User> findByName(String name);
//}

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);

}