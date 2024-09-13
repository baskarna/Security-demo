package com.bk.SecuDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private Service service;

    @PostMapping("/register")
    public Users users(@RequestBody Users users) throws InterruptedException{
        System.out.print("error");
        Thread.sleep(60000);
        return service.saveUser(users);
    }
    
     @PostMapping("/log")
    public String log(@RequestBody Log log){
        try{
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(log.getUsername(), log.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "Good Username"+log.getUsername() ;
        }catch(Exception e){
            return "error";
        }
       
    }
    
    @GetMapping("/greet")
    public String greet(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null && authentication.isAuthenticated()){
            UserDetails userDetails=(UserDetails)authentication.getPrincipal();
            return  "Hello "+userDetails.getUsername();
        }
        return "NOT LOGED";
       
    }
}
