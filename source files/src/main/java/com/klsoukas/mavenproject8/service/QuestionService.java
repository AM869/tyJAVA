package com.klsoukas.mavenproject8.service;

import com.klsoukas.mavenproject8.model.AdvancedQuestions;
import com.klsoukas.mavenproject8.model.BasicQuestions;
import com.klsoukas.mavenproject8.model.IntermediateQuestions;
import java.util.List;


public interface QuestionService {
    
    public List<BasicQuestions> getBasicQuestions();

    public List<IntermediateQuestions> getIntermediateQuestions();
    
    public List<AdvancedQuestions> getAdvancedQuestions();
}