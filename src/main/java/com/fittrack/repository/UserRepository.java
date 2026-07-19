package com.fittrack.repository;
import com.fittrack.entity.User; import org.springframework.data.jpa.repository.JpaRepository; import java.time.*; import java.util.*;
public interface UserRepository extends JpaRepository<User,Long>{
 Optional<User> findByEmailIgnoreCase(String email); boolean existsByEmailIgnoreCase(String email);
 long countByCreatedAtAfter(Instant since); List<User> findAllByOrderByCreatedAtDesc();
}
