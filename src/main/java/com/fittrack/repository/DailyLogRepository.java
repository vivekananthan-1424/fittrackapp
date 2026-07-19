package com.fittrack.repository;
import com.fittrack.entity.DailyLog; import org.springframework.data.jpa.repository.JpaRepository;
public interface DailyLogRepository extends JpaRepository<DailyLog,Long> {}
