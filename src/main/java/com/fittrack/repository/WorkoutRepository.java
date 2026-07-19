package com.fittrack.repository;
import com.fittrack.entity.Workout; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface WorkoutRepository extends JpaRepository<Workout,Long>{
 List<Workout> findAllByUserIdOrderByIdDesc(Long userId);
 Optional<Workout> findByIdAndUserId(Long id,Long userId);
}
