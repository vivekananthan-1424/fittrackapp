package com.fittrack.entity;
import jakarta.persistence.*; import java.time.*;
@Entity public class Workout {
 @ManyToOne(optional=false) @JoinColumn(name="user_id") public User user;
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 public LocalDate workoutDate; public String workoutType; public String exerciseName; public Integer sets; public Integer repetitions;
 public Integer duration=0; public Double caloriesBurned=0.0; @Column(length=1000) public String notes; public Instant createdAt=Instant.now();
}
