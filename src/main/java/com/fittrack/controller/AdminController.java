package com.fittrack.controller;
import com.fittrack.repository.UserRepository; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*;
import java.time.*; import java.util.*;
@RestController @RequestMapping("/api/admin") @PreAuthorize("hasRole('ADMIN')")
public class AdminController {
 private final UserRepository users; public AdminController(UserRepository u){users=u;}
 @GetMapping("/overview") public Map<String,Object> overview(){
  var all=users.findAllByOrderByCreatedAtDesc(); Instant week=Instant.now().minus(Duration.ofDays(7));
  Map<String,Long> trend=new TreeMap<>(); for(int i=6;i>=0;i--){LocalDate d=LocalDate.now().minusDays(i);trend.put(d.toString(),0L);}
  all.forEach(u->{String d=u.createdAt.atZone(ZoneId.systemDefault()).toLocalDate().toString();if(trend.containsKey(d))trend.put(d,trend.get(d)+1);});
  var safe=all.stream().map(u->Map.of("id",u.id,"name",u.name,"email",u.email,"role",u.role,"createdAt",u.createdAt.toString())).toList();
  return Map.of("success",true,"data",Map.of("totalUsers",all.size(),"newUsers7d",users.countByCreatedAtAfter(week),"registrationTrend",trend,"users",safe));
 }
}
