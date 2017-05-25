
package com.klsoukas.mavenproject8.service;

import com.klsoukas.mavenproject8.dao.UserDao;
import com.klsoukas.mavenproject8.model.RegisteredUsers;
import com.klsoukas.mavenproject8.model.RegistrationBean;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
    
    
    @Autowired
    private UserDao ud;
    
    @Transactional
    public boolean registerNewUser(RegistrationBean registrationBean){
        
        String username = registrationBean.getUsername();
        String password = registrationBean.getPassword();
        String email = registrationBean.getEmail();
        try{
            ud.findUserByUsername(username);
        }
        //if that username DOES NOT EXIST then proceed to create one
        catch(NoResultException ex){
            RegisteredUsers newUser = new RegisteredUsers(username,password,email);
            ud.createUser(newUser);
            return true;
        }
        
        return false;
    }
}
