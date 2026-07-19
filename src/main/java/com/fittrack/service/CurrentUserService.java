package com.fittrack.service;
import com.fittrack.entity.User; import com.fittrack.repository.UserRepository; import org.springframework.security.core.Authentication; import org.springframework.stereotype.Service;
@Service public class CurrentUserService {
 private final UserRepository users; public CurrentUserService(UserRepository u){users=u;}
 public User get(Authentication a){return users.findByEmailIgnoreCase(a.getName()).orElseThrow();}
}
