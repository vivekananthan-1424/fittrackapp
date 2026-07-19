package com.fittrack.config;
import org.springframework.context.annotation.*; import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity; import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*; import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.security.web.SecurityFilterChain;
import com.fittrack.repository.UserRepository;
@Configuration @EnableMethodSecurity public class SecurityConfig {
 @Bean PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
 @Bean UserDetailsService userDetailsService(UserRepository users){return email->{
  var u=users.findByEmailIgnoreCase(email).orElseThrow(()->new UsernameNotFoundException("User not found"));
  return org.springframework.security.core.userdetails.User.withUsername(u.email).password(u.passwordHash).roles(u.role).build();
 };}
 @Bean SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
  http.authorizeHttpRequests(a->a.requestMatchers("/login.html","/register.html","/api/auth/register","/css/**","/js/**","/actuator/health/**").permitAll().anyRequest().authenticated())
   .formLogin(f->f.loginPage("/login.html").loginProcessingUrl("/login").defaultSuccessUrl("/",true).failureUrl("/login.html?error=true").permitAll())
   .logout(l->l.logoutUrl("/logout").logoutSuccessUrl("/login.html").invalidateHttpSession(true).deleteCookies("JSESSIONID"))
   .csrf(c->c.ignoringRequestMatchers("/api/**","/login","/logout"));
  return http.build();
 }
}
