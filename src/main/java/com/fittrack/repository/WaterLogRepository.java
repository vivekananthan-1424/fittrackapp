package com.fittrack.repository;
import com.fittrack.entity.WaterLog; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface WaterLogRepository extends JpaRepository<WaterLog,Long>{
 List<WaterLog> findAllByUserIdOrderByIdDesc(Long userId); Optional<WaterLog> findByIdAndUserId(Long id,Long userId);
}
