
package com.klsoukas.mavenproject8.controller;

import com.klsoukas.mavenproject8.model.RegisteredUsers;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginAndHomeController {
    

    //same result can be achieved with putting "antMatchers("/").authenticated()." in the SecurityConfig.java in "authorizeRequests()." section
    @RequestMapping({"/"})
    public String defaultUrl(){
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        //if user is not authenticated -> display login.jsp 
        if (auth instanceof AnonymousAuthenticationToken) {  
            return "login";
        }

        //else -> display home.jsp
        return "home";
    }
    
    
    
    @RequestMapping({"/login"})
    public String login(HttpServletResponse response, HttpServletRequest req, HttpSession session){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        //if user is already logged-in/authenticated -> redirect to /home == display home.jsp
        if (!(auth instanceof AnonymousAuthenticationToken)) {  
            return "redirect:/home";
        }
        else{
            session.invalidate();
        }
        
        return "login";
    }
    
    
    @RequestMapping({"/home"})
    public String home(Model model){

        RegisteredUsers user = (RegisteredUsers)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("username",user.getUsername());
        return "home";
    }
    
    @RequestMapping({"/info"})
    public String infoUrl(){
        

        return "generalInfo";
    }
    
        @RequestMapping({"/wtf"})
    public String wtf(HttpServletRequest request, @RequestBody MultiValueMap<String,String> formData){
        
        for (Map.Entry<String, List<String>> entry : formData.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
        }
        
        return "wtf";
    }

}
