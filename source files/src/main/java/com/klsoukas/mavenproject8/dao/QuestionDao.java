
package com.klsoukas.mavenproject8.dao;

import java.util.List;

public interface QuestionDao <T> {
    
    List<T> rand_questions();
    
}
