    
package com.klsoukas.mavenproject8.controller;

import com.klsoukas.mavenproject8.model.AdvancedQuestions;
import com.klsoukas.mavenproject8.model.BasicQuestions;
import com.klsoukas.mavenproject8.model.IntermediateQuestions;
import com.klsoukas.mavenproject8.model.Questions;
import com.klsoukas.mavenproject8.model.RegisteredUsers;
import com.klsoukas.mavenproject8.service.QuestionService;
import com.klsoukas.mavenproject8.service.QuizResultsService;
import com.klsoukas.mavenproject8.service.ViewStatsService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"question_list","quiz_type","submitted_answers"})
public class QuizController {
    
    @Autowired
    private QuestionService qs;
    
    @Autowired
    private QuizResultsService qrs;
    
    @Autowired
    private ViewStatsService vss;
    
    @RequestMapping(value={"/beginner_quiz"}, method = {RequestMethod.GET})
    public String beginner_quiz(HttpSession session,Model model){
        
        List<BasicQuestions> list = qs.getBasicQuestions();   

        model.addAttribute("question_list",list);
        model.addAttribute("quiz_type","beginner");
        
        RegisteredUsers user = (RegisteredUsers)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setLastQuizType("beginner");
        
        session.setAttribute("quiz_initiated","quiz_initiated");
        session.setAttribute("quiz_start_time",System.currentTimeMillis());
        return "quiz";
    }
    

    @RequestMapping(value={"/intermediate_quiz"}, method = {RequestMethod.GET})
    public String intermediate_quiz(HttpSession session,Model model){
        
        List<IntermediateQuestions> list = qs.getIntermediateQuestions();

        model.addAttribute("question_list",list);
        model.addAttribute("quiz_type","intermediate");
        
        RegisteredUsers user = (RegisteredUsers)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setLastQuizType("intermediate");
        
        session.setAttribute("quiz_initiated","quiz_initiated");
        session.setAttribute("quiz_start_time",System.currentTimeMillis());
        return "quiz";
    }
    
    
    @RequestMapping(value={"/advanced_quiz"}, method = {RequestMethod.GET})
    public String advanced_quiz(HttpSession session,Model model){
        
        List<AdvancedQuestions> list = qs.getAdvancedQuestions();  

        model.addAttribute("question_list",list);
        model.addAttribute("quiz_type","advanced");

        RegisteredUsers user = (RegisteredUsers)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setLastQuizType("advanced");        
        
        session.setAttribute("quiz_initiated","quiz_initiated");
        session.setAttribute("quiz_start_time",System.currentTimeMillis());
        return "quiz";
    }
    
    
    
    @RequestMapping(value = "/submit_quiz", method = {RequestMethod.POST})
    public String submit_quiz(HttpSession session, Model model, @RequestBody MultiValueMap<String,String> formData){
        
        model.addAttribute("submitted_answers", formData);

        
        
        session.removeAttribute("quiz_initiated");
        session.removeAttribute("quiz_start_time");
        
        RegisteredUsers user = (RegisteredUsers)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setLastQuizType(null);
        
        return "redirect:/quiz_results";
    }
    
    
    @RequestMapping(value={"/quiz_results"}, method = RequestMethod.GET)

    public String quiz_results(HttpSession session,Model model, SessionStatus status,
            @ModelAttribute("question_list") List<Questions> list,
            @ModelAttribute("submitted_answers")  MultiValueMap<String,String> submittedAnswers,
            @ModelAttribute("quiz_type") String quizType)
            {
                                
        RegisteredUsers user = (RegisteredUsers)SecurityContextHolder.getContext().getAuthentication().getPrincipal();      
        
        qrs.addQuizResultsModelAttributes(model, list, submittedAnswers, quizType, user);
        
        status.setComplete();
        
        return "quiz_results";
    }
    
    
    @RequestMapping({"/view_stats"})
    public String viewStats(Model model){
        RegisteredUsers user = (RegisteredUsers)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        vss.viewStatsModelAttributes(model, user);
        return "view_stats";
    }
}
