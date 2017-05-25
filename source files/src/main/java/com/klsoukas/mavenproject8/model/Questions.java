
package com.klsoukas.mavenproject8.model;


public interface Questions {
    
    Integer getId();
    String getQuestionbody();
    Character getCorrectanswer();
    String getAnswer1();
    String getAnswer2();
    String getAnswer3();
    String getAnswer4();
    String getUserAnswer();
    void setUserAnswer(String userAnswer);
    
}
