
package com.klsoukas.mavenproject8.controller;

import com.klsoukas.mavenproject8.model.RegistrationBean;
import com.klsoukas.mavenproject8.service.RegistrationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {
    
    @Autowired
    private RegistrationService rs;
    
    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public String registration(Model model){
        
        
        //to preserve validation errors we create new RegistrationBean only when there is no RegistrationBean flashAttribute meaning the registration url visit was not from an error redirect
        //if we always create new RegistrationBean we will loose the old-persevered RegistrationBean from the previous POST request and its errors (BindingResult)
        if(!model.containsAttribute("registrationBean"))
            model.addAttribute("registrationBean", new RegistrationBean());
        
        return "registration";
    }
    
    
    @RequestMapping(value="/register",  method = {RequestMethod.POST})
    public String register(@Valid RegistrationBean registrationBean, BindingResult bindingResults, RedirectAttributes redirectAttributes, Model model){
        
        //we need a RegistrationBean with a BindingResult to display validation errors
        if(bindingResults.hasErrors()){
            redirectAttributes.addFlashAttribute("registrationBean", registrationBean);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registrationBean", bindingResults);
            return "redirect:/registration";
        }
        
        if(rs.registerNewUser(registrationBean))
            return "redirect:/login?registration=success&username="+registrationBean.getUsername();;
        
        redirectAttributes.addFlashAttribute("usernameExists","Username Already Exists! Choose another please.");
        return "redirect:/registration";
    }
    
    
    
}
