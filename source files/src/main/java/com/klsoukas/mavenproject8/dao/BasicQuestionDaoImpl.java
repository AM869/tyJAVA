
package com.klsoukas.mavenproject8.dao;

import com.klsoukas.mavenproject8.model.BasicQuestions;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;


@Repository
public class BasicQuestionDaoImpl implements QuestionDao<BasicQuestions>{

    @PersistenceContext(unitName = "PU1")
    private EntityManager em;
    
    @Override
    public List<BasicQuestions> rand_questions() {
        
        Query query = em.createNamedQuery("find_10_rand_basic_questions");
        List list = query.getResultList();      
        return list;
    }
    
}
