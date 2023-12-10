package bridge.bms32back.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username = ?1 and u.password = ?2 and u.status = ?3")
    Optional<User> findUserBy(String username, String password, String status);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO \"user\" (username, password, role_id, status) VALUES (?1, ?2, 2, 'A')", nativeQuery = true)
    void addUser(String username, String password);
}