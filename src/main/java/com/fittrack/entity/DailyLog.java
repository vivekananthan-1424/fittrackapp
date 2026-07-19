package com.fittrack.entity;
import jakarta.persistence.*; import java.time.*;
@Entity @Table(name="daily_logs",uniqueConstraints=@UniqueConstraint(columnNames={"user_id","log_date"}))
public class DailyLog {
 @ManyToOne(optional=false) @JoinColumn(name="user_id") public User user;
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @Column(name="log_date",nullable=false) public LocalDate date;
 public Double weight; public Long steps=0L; public Double distanceKm=0.0; public Double caloriesBurned=0.0;
 public Double waterLiters=0.0; public Double sleepHours=0.0; public Boolean sugarFree=false; public Boolean workoutCompleted=false;
 public Integer workoutDuration=0; public String workoutType; public String mood; public Integer energyLevel; @Column(length=2000) public String notes;
 public Instant createdAt=Instant.now(); public Instant updatedAt=Instant.now();
}
