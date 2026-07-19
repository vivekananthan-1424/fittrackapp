package com.fittrack.entity;
import jakarta.persistence.*; import java.time.*;
@Entity public class MealItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @ManyToOne(optional=false) @JoinColumn(name="user_id") public User user;
 public LocalDate date; public String mealType; public String foodName;
 public Double quantity=1.0; public String unit="serving";
 public Double calories=0.0, protein=0.0, carbohydrates=0.0, fat=0.0, fiber=0.0, sugar=0.0, sodiumMg=0.0;
 public String healthRating="MODERATE";
 @Column(length=1000) public String healthReason;
 @Column(length=1000) public String notes;
 public Instant createdAt=Instant.now();
}
