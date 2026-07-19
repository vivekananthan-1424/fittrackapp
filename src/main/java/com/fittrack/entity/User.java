package com.fittrack.entity;
import jakarta.persistence.*; import java.time.*;
@Entity @Table(name="app_users")
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @Column(nullable=false) public String name;
 @Column(nullable=false,unique=true) public String email;
 @Column(nullable=false) public String passwordHash;
 public String role="USER";
 public Double startingWeight=84.0, goalWeight=70.0, heightCm;
 public Integer age; public String sex="MALE";
 public Integer dailyStepGoal=10000; public Double dailyWaterGoal=2.5;
 public String syncTokenHash; public Instant lastLoginAt;
 public Instant createdAt=Instant.now(); public Instant updatedAt=Instant.now();
}
