
package com.klsoukas.mavenproject8.applicationListener;

import com.klsoukas.mavenproject8.model.RegisteredUsers;
import com.klsoukas.mavenproject8.service.QuizResultsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;

@Component
public class SessionDestroyedListener implements ApplicationListener<SessionDestroyedEvent> {

    @Autowired
    QuizResultsService qrs;
        
    @Override
    public void onApplicationEvent(SessionDestroyedEvent event)
    {
        
        //get auth object
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        //if user is authenticated
        if(!(auth instanceof AnonymousAuthenticationToken) ){
                       
            List<SecurityContext> listSecurityContext = event.getSecurityContexts();
            RegisteredUsers user;
            for (SecurityContext securityContext : listSecurityContext)
            {

                user = (RegisteredUsers) securityContext.getAuthentication().getPrincipal();
                
                //if user was in the middle of a quiz
                if(user.getLastQuizType() != null){
                    //update user stats for canceled quiz making score 0 for that particular quiz
                    qrs.updateUserStats(user, user.getLastQuizType(), 0);
                }

            }
        }
    }
}