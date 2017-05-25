
package com.klsoukas.mavenproject8.service;

import com.klsoukas.mavenproject8.dao.UserDao;
import com.klsoukas.mavenproject8.model.Questions;
import com.klsoukas.mavenproject8.model.RegisteredUsers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;

@Service

public class QuizResultsService {
    
    @Autowired
    private UserDao ud;
    
    @Autowired
    private SpringSecurityUserRoleService ssurs;
        
    @Transactional
    public String updateUserStats(RegisteredUsers user, String quizType, int answeredCorrectly){
        
        String rankUp = null;
        float mean = 0f;
        
        
        //update user's stats
        switch (quizType) {
            case "beginner":            
                mean = (user.getMean1()*user.getCount1()+answeredCorrectly)/(user.getCount1()+1);
                user.setCount1(user.getCount1()+1);
                user.setMean1(mean);
                break;
            case "intermediate":
                mean = (user.getMean2()*user.getCount2()+answeredCorrectly)/(user.getCount2()+1);
                user.setCount2(user.getCount2()+1);
                user.setMean2(mean);
                break;
            case "advanced":
                mean = (user.getMean3()*user.getCount3()+answeredCorrectly)/(user.getCount3()+1);
                user.setCount3(user.getCount3()+1);
                user.setMean3(mean);                
                break;
        }
        
                        
        //check if user can progress rank based on his results
        if(quizType.equals(user.getRank().toLowerCase()) && mean>8 ){
            if(quizType.equals("beginner")){
                user.setRank("Intermediate");
                rankUp = "Congratulations! You can now access intermediate quizzes.";
                //update dynamically spring user role-rank without user having to log and spring fetch from database the user's new role
                ssurs.updateSpringSecurityUserRole(user);
            }
            else if(quizType.equals("intermediate")){
                user.setRank("Advanced");
                rankUp = "Congratulations! You can now access advanced quizzes.";
                //update dynamically spring user role-rank without user having to log and spring fetch from database the user's new role
                ssurs.updateSpringSecurityUserRole(user);
            }
            else if(quizType.equals("advanced")){
                user.setRank("Master");
                rankUp = "Congratulations! You have mastered this!";
                //update dynamically spring user role-rank without user having to log and spring fetch from database the user's new role
                ssurs.updateSpringSecurityUserRole(user);
            }
        }
        
        //update user(along with its role-rank) in database
        ud.updateUser(user);
        
        return rankUp;
    }
    
    @Transactional
    public void addQuizResultsModelAttributes(Model model, List<Questions> list, MultiValueMap<String,String> submittedAnswers, String quizType, RegisteredUsers user){
        
        
        List<Questions> wronglyAnsweredQuestionList = new ArrayList<>();
       
        int unanswered=0;
        int answeredCorrectly=0;
        int answeredWrongly=0;
        
        Integer id;
        String correct_answer;
        String user_answer;
        
        for(Questions question: list){
            id = question.getId();
            correct_answer = question.getCorrectanswer().toString();
            user_answer = submittedAnswers.getFirst(id.toString());
            
            if(user_answer == null){
                unanswered++;
            }
            else if(correct_answer.equals(user_answer)){
                answeredCorrectly++;
            }
            else{
                answeredWrongly++;
                
                question.setUserAnswer(user_answer);
                wronglyAnsweredQuestionList.add(question);
                                
            }
                       
        }
        model.addAttribute("username",user.getUsername());
        model.addAttribute("unanswered", unanswered);
        model.addAttribute("answeredCorrectly", answeredCorrectly);
        model.addAttribute("answeredWrongly", answeredWrongly);
        model.addAttribute("wronglyAnsweredQuestionList", wronglyAnsweredQuestionList);
        
        //@Transactional here applies only on the current method not the "updateUserStats" method because it is the same class' method calling the "updateUserStats" method
        String rankUp = updateUserStats(user, quizType, answeredCorrectly);
        if(rankUp!=null)
            model.addAttribute("rankUp",rankUp);
            
        
    }
}
