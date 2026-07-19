package com.fittrack.entity;
import jakarta.persistence.*; import java.time.*;
@Entity public class WaterLog {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @ManyToOne(optional=false) @JoinColumn(name="user_id") public User user;
 public LocalDate date;
 public Integer amountMl;
 public Instant loggedAt=Instant.now();
}
