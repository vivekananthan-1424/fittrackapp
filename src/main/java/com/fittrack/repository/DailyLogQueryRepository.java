package com.fittrack.repository;
import com.fittrack.entity.*; import org.springframework.data.jpa.repository.JpaRepository; import java.time.*; import java.util.*;
public interface DailyLogQueryRepository extends JpaRepository<DailyLog,Long>{
 Optional<DailyLog> findByUserIdAndDate(Long userId,LocalDate date);
 List<DailyLog> findAllByUserIdOrderByDateAsc(Long userId);
 Optional<DailyLog> findByIdAndUserId(Long id,Long userId);
}
