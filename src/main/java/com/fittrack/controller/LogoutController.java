package com.fittrack.controller;
import jakarta.servlet.http.*; import org.springframework.stereotype.Controller; import org.springframework.web.bind.annotation.GetMapping;
@Controller public class LogoutController {
 @GetMapping("/signout") public String signout(HttpServletRequest req){
  try{req.logout();}catch(Exception ignored){}
  HttpSession session=req.getSession(false); if(session!=null)session.invalidate();
  return "redirect:/login.html";
 }
}
