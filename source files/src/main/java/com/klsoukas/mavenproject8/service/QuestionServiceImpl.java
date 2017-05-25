package com.klsoukas.mavenproject8.service;

import com.klsoukas.mavenproject8.dao.QuestionDao;
import com.klsoukas.mavenproject8.model.AdvancedQuestions;
import com.klsoukas.mavenproject8.model.BasicQuestions;
import com.klsoukas.mavenproject8.model.IntermediateQuestions;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionServiceImpl implements QuestionService {
    
    @Autowired
    private QuestionDao<BasicQuestions> basicQuestionsDao;
    
    @Autowired
    private QuestionDao<IntermediateQuestions> intermediateQuestionsDao;
        
    @Autowired
    private QuestionDao<AdvancedQuestions> advancedQuestionsDao;
    
    
    @Transactional
    public List<BasicQuestions> getBasicQuestions(){
     
        return basicQuestionsDao.rand_questions();
    }


    @Transactional
    public List<IntermediateQuestions> getIntermediateQuestions(){
     
        return intermediateQuestionsDao.rand_questions();
    }
    
    
    @Transactional
    public List<AdvancedQuestions> getAdvancedQuestions(){
     
        return advancedQuestionsDao.rand_questions();
    }
    
}