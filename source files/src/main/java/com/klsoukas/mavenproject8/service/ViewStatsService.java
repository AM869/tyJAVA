
package com.klsoukas.mavenproject8.service;

import com.klsoukas.mavenproject8.model.RegisteredUsers;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ViewStatsService {
    
    
    public void viewStatsModelAttributes(Model model, RegisteredUsers user){
     
        model.addAttribute("username",user.getUsername());
        model.addAttribute("rank",user.getRank());
        model.addAttribute("beginnerCount", user.getCount1());
        model.addAttribute("intermediateCount",user.getCount2());
        model.addAttribute("advancedCount",user.getCount3());
        model.addAttribute("beginnerScore",user.getMean1());
        model.addAttribute("intermediateScore",user.getMean2());
        model.addAttribute("advancedScore",user.getMean3());
    }
}
