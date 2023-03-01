package nick_snt1.lab.weblab4back.repository;

import nick_snt1.lab.weblab4back.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);
}
