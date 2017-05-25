
package com.klsoukas.mavenproject8.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "intermediate_questions")
@XmlRootElement

//MySQL native query
@NamedNativeQueries({
    @NamedNativeQuery(name = "find_10_rand_intermediate_questions", query = "SELECT * FROM intermediate_questions  ORDER BY RAND()  LIMIT 10", resultClass = IntermediateQuestions.class)
})

@NamedQueries({
    @NamedQuery(name = "IntermediateQuestions.findAll", query = "SELECT i FROM IntermediateQuestions i")
    , @NamedQuery(name = "IntermediateQuestions.findById", query = "SELECT i FROM IntermediateQuestions i WHERE i.id = :id")
    , @NamedQuery(name = "IntermediateQuestions.findByQuestionbody", query = "SELECT i FROM IntermediateQuestions i WHERE i.questionbody = :questionbody")
    , @NamedQuery(name = "IntermediateQuestions.findByAnswer1", query = "SELECT i FROM IntermediateQuestions i WHERE i.answer1 = :answer1")
    , @NamedQuery(name = "IntermediateQuestions.findByAnswer2", query = "SELECT i FROM IntermediateQuestions i WHERE i.answer2 = :answer2")
    , @NamedQuery(name = "IntermediateQuestions.findByAnswer3", query = "SELECT i FROM IntermediateQuestions i WHERE i.answer3 = :answer3")
    , @NamedQuery(name = "IntermediateQuestions.findByAnswer4", query = "SELECT i FROM IntermediateQuestions i WHERE i.answer4 = :answer4")
    , @NamedQuery(name = "IntermediateQuestions.findByCorrectanswer", query = "SELECT i FROM IntermediateQuestions i WHERE i.correctanswer = :correctanswer")})
public class IntermediateQuestions implements Serializable, Questions {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "questionbody")
    private String questionbody;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "answer1")
    private String answer1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "answer2")
    private String answer2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "answer3")
    private String answer3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "answer4")
    private String answer4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "correctanswer")
    private Character correctanswer;

    @Transient
    private String userAnswer;
    
    public IntermediateQuestions() {
    }

    public IntermediateQuestions(Integer id) {
        this.id = id;
    }

    public IntermediateQuestions(Integer id, String questionbody, String answer1, String answer2, String answer3, String answer4, Character correctanswer) {
        this.id = id;
        this.questionbody = questionbody;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctanswer = correctanswer;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getQuestionbody() {
        return questionbody;
    }

    public void setQuestionbody(String questionbody) {
        this.questionbody = questionbody;
    }

    @Override
    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    @Override
    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    @Override
    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    @Override
    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    @Override
    public Character getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(Character correctanswer) {
        this.correctanswer = correctanswer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntermediateQuestions)) {
            return false;
        }
        IntermediateQuestions other = (IntermediateQuestions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.klsoukas.mavenproject8.model.IntermediateQuestions[ id=" + id + " ]";
    }
    
    
    @Override
    public String getUserAnswer() {
        return userAnswer;
    }

    
    @Override
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    
}
