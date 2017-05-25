
package com.klsoukas.mavenproject8.controller.interceptor;

import com.klsoukas.mavenproject8.model.RegisteredUsers;
import com.klsoukas.mavenproject8.service.QuizResultsService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class QuizSecurityInterceptor extends HandlerInterceptorAdapter {
    
        @Autowired
        QuizResultsService qrs;
        
    	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws ModelAndViewDefiningException{

                        
            String servletPath = request.getServletPath();
            HttpSession session = request.getSession();
            
            
            //if user access again quiz_results by enter same url
            if(session.getAttribute("question_list")== null && servletPath.equals("/quiz_results")){
                illegalResourceAccess();
            }
            
            //if user has undertaken a quiz
            if(session.getAttribute("quiz_initiated") != null){
                
                
                //if user has submitted quiz correctly in this url
                if( servletPath.equals("/submit_quiz") ){
                    Long currTimeMillis = System.currentTimeMillis();
                    Long durationMillis = currTimeMillis - (Long)session.getAttribute("quiz_start_time");
                    
                    //if user has taken too long to submit a quiz, e.g. user has disabled client/browser javascript and the form with answers wont be autosended automatically
                    //ideally should be 180000 ms == 3min but maybe we consider some latency etc
                    if (durationMillis > 190000){
                        illegalQuizSubmission(session);
                    }
                    
                }
                //if servlet path not equals "/submit_quiz"
                else{                    
                    illegalQuizSubmission(session);             
                }
            }
            
            return true;
	}
        
        private void illegalResourceAccess() throws ModelAndViewDefiningException{
            RegisteredUsers user = (RegisteredUsers)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            ModelAndView quiz_results_twice = new ModelAndView("home");
            quiz_results_twice.addObject("username",user.getUsername());
            throw new ModelAndViewDefiningException(quiz_results_twice);   
            
            
        }
        private void illegalQuizSubmission(HttpSession session) throws ModelAndViewDefiningException{
            
            RegisteredUsers user = (RegisteredUsers)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            
            //update user stats for canceled quiz making score 0 for that particular quiz
            qrs.updateUserStats(user, (String)session.getAttribute("quiz_type"), 0);
            
            //remove all quiz related session attributes
            session.removeAttribute("quiz_type");
            session.removeAttribute("question_list"); 
            
            //remove session attributes that flag a user that is ON a quiz right now
            session.removeAttribute("quiz_initiated");
            session.removeAttribute("quiz_start_time");
            
            
            //model attributes for quiz_result forwarded view for canceled quiz
            ModelAndView quiz_canceled = new ModelAndView("quiz_results");
            quiz_canceled.addObject("username",user.getUsername());
            quiz_canceled.addObject("unanswered", 10);
            quiz_canceled.addObject("answeredCorrectly", 0);
            throw new ModelAndViewDefiningException(quiz_canceled);      
        }
}
