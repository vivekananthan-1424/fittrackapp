package com.fittrack.config;
import com.fittrack.entity.User; import com.fittrack.repository.UserRepository; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.*; import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration public class SeedData {
 @Bean CommandLineRunner seed(UserRepository users,PasswordEncoder enc){return args->{
  if(users.findByEmailIgnoreCase("admin@fittrack.local").isEmpty()){User a=new User();a.name="FitTrack Admin";a.email="admin@fittrack.local";a.passwordHash=enc.encode("ChangeAdmin123!");a.role="ADMIN";users.save(a);}
  if(users.findByEmailIgnoreCase("demo@fittrack.local").isEmpty()){User u=new User();u.name="FitTrack User";u.email="demo@fittrack.local";u.passwordHash=enc.encode("ChangeMe123!");users.save(u);}
 };}
}
