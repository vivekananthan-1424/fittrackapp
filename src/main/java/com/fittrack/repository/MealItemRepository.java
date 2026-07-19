package com.fittrack.repository;
import com.fittrack.entity.MealItem; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface MealItemRepository extends JpaRepository<MealItem,Long>{
 List<MealItem> findAllByUserIdOrderByIdDesc(Long userId);
 Optional<MealItem> findByIdAndUserId(Long id,Long userId);
}
