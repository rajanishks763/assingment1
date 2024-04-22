package com.assignment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.dto.UserDto;
import com.assignment.entity.Contact;
import com.assignment.entity.User;
import com.assignment.repository.ContactRepository;
import com.assignment.service.AuthService;
import com.assignment.util.JwtTokenUtil;

 @Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    
    @Autowired
    private ContactRepository contactRepo;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @RequestMapping("/api")
    public String showLoginPage() {
    	return "login";
    }
    
    @RequestMapping("/login")
    public String login(@ModelAttribute UserDto user,ModelMap model) {
        String loginId = user.getLoginId();
        String password = user.getPassword();
        
        String token = authService.authenticate(loginId, password);
        
      //  TokenConfig newtoken = new TokenConfig();
    
        if (token != null) {
        	//newtoken.setTokenUrl(token);
        	boolean validateToken = jwtTokenUtil.validateToken(token);
        	List<Contact> contact = contactRepo.findAll();
        	model.addAttribute("validateToken", validateToken);
    		model.addAttribute("contact", contact);
    		return "CustomerList";
       
        } else {
        	model.addAttribute("msg", "Invilide Login Id or Password");
            return "login";
        }
    }
    
    @PostMapping("/save/user")
    public String saveUser(@RequestBody User user) {
    	return authService.saveUserDetails(user);
    }
}

