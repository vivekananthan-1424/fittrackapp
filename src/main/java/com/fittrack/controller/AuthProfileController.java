package com.fittrack.controller;
import com.fittrack.entity.User; import com.fittrack.repository.UserRepository; import com.fittrack.service.CurrentUserService;
import org.springframework.http.*; import org.springframework.security.core.Authentication; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.web.bind.annotation.*;
import java.time.*; import java.util.*;
@RestController @RequestMapping("/api") public class AuthProfileController {
 private final UserRepository users; private final PasswordEncoder enc; private final CurrentUserService current;
 public AuthProfileController(UserRepository u,PasswordEncoder e,CurrentUserService c){users=u;enc=e;current=c;}
 private Map<String,Object> safe(User u){
  Map<String,Object> data=new LinkedHashMap<>();
  data.put("id",u.id); data.put("name",u.name); data.put("email",u.email); data.put("role",u.role);
  data.put("startingWeight",u.startingWeight==null?0:u.startingWeight);
  data.put("goalWeight",u.goalWeight==null?0:u.goalWeight);
  data.put("heightCm",u.heightCm==null?0:u.heightCm);
  data.put("dailyStepGoal",u.dailyStepGoal==null?10000:u.dailyStepGoal);
  data.put("dailyWaterGoal",u.dailyWaterGoal==null?2.5:u.dailyWaterGoal);
  data.put("age",u.age==null?0:u.age); data.put("sex",u.sex==null?"":u.sex);
  return data;
 }
 @PostMapping("/auth/register") public ResponseEntity<?> register(@RequestBody Map<String,Object> p){
  String name=String.valueOf(p.getOrDefault("name","")).trim(),email=String.valueOf(p.getOrDefault("email","")).trim().toLowerCase(),password=String.valueOf(p.getOrDefault("password",""));
  if(name.isBlank()||email.isBlank()||password.length()<8)return ResponseEntity.badRequest().body(Map.of("success",false,"message","Name, email and password of at least 8 characters are required"));
  if(users.existsByEmailIgnoreCase(email))return ResponseEntity.status(409).body(Map.of("success",false,"message","Email already registered"));
  User u=new User();u.name=name;u.email=email;u.passwordHash=enc.encode(password);users.save(u);
  return ResponseEntity.status(201).body(Map.of("success",true,"message","Account created. Please sign in."));
 }
 @GetMapping("/me") public Map<String,Object> me(Authentication a){return Map.of("success",true,"data",safe(current.get(a)));}
 @PutMapping("/me") public ResponseEntity<?> update(Authentication a,@RequestBody Map<String,Object> p){
  User u=current.get(a);String email=String.valueOf(p.getOrDefault("email",u.email)).trim().toLowerCase();
  var other=users.findByEmailIgnoreCase(email);if(other.isPresent()&&!other.get().id.equals(u.id))return ResponseEntity.status(409).body(Map.of("success",false,"message","Email already in use"));
  u.name=String.valueOf(p.getOrDefault("name",u.name)).trim();u.email=email;
  if(p.get("startingWeight") instanceof Number n)u.startingWeight=n.doubleValue();if(p.get("goalWeight") instanceof Number n)u.goalWeight=n.doubleValue();
  if(p.get("heightCm") instanceof Number n)u.heightCm=n.doubleValue();if(p.get("age") instanceof Number n)u.age=n.intValue();if(p.get("sex")!=null)u.sex=String.valueOf(p.get("sex"));if(p.get("dailyStepGoal") instanceof Number n)u.dailyStepGoal=n.intValue();if(p.get("dailyWaterGoal") instanceof Number n)u.dailyWaterGoal=n.doubleValue();
  u.updatedAt=Instant.now();users.save(u);return ResponseEntity.ok(Map.of("success",true,"message","Profile updated","data",safe(u)));
 }
 @PutMapping("/me/password") public ResponseEntity<?> password(Authentication a,@RequestBody Map<String,Object> p){
  User u=current.get(a);String old=String.valueOf(p.getOrDefault("currentPassword","")),nw=String.valueOf(p.getOrDefault("newPassword",""));
  if(!enc.matches(old,u.passwordHash))return ResponseEntity.badRequest().body(Map.of("success",false,"message","Current password is incorrect"));
  if(nw.length()<8)return ResponseEntity.badRequest().body(Map.of("success",false,"message","New password must be at least 8 characters"));
  u.passwordHash=enc.encode(nw);u.updatedAt=Instant.now();users.save(u);return ResponseEntity.ok(Map.of("success",true,"message","Password changed"));
 }
}
