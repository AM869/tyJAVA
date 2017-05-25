
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
@Table(name = "basic_questions")
@XmlRootElement

//MySQL native query
@NamedNativeQueries({
    @NamedNativeQuery(name = "find_10_rand_basic_questions", query = "SELECT * FROM basic_questions  ORDER BY RAND()  LIMIT 10", resultClass = BasicQuestions.class)
})

@NamedQueries({
    @NamedQuery(name = "BasicQuestions.findAll", query = "SELECT b FROM BasicQuestions b")
    , @NamedQuery(name = "BasicQuestions.findById", query = "SELECT b FROM BasicQuestions b WHERE b.id = :id")
    , @NamedQuery(name = "BasicQuestions.findByQuestionbody", query = "SELECT b FROM BasicQuestions b WHERE b.questionbody = :questionbody")
    , @NamedQuery(name = "BasicQuestions.findByAnswer1", query = "SELECT b FROM BasicQuestions b WHERE b.answer1 = :answer1")
    , @NamedQuery(name = "BasicQuestions.findByAnswer2", query = "SELECT b FROM BasicQuestions b WHERE b.answer2 = :answer2")
    , @NamedQuery(name = "BasicQuestions.findByAnswer3", query = "SELECT b FROM BasicQuestions b WHERE b.answer3 = :answer3")
    , @NamedQuery(name = "BasicQuestions.findByAnswer4", query = "SELECT b FROM BasicQuestions b WHERE b.answer4 = :answer4")
    , @NamedQuery(name = "BasicQuestions.findByCorrectanswer", query = "SELECT b FROM BasicQuestions b WHERE b.correctanswer = :correctanswer")})
public class BasicQuestions implements Serializable, Questions {

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

    @Override
    public String getUserAnswer() {
        return userAnswer;
    }

    @Override
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
    
    public BasicQuestions() {
    }

    public BasicQuestions(Integer id) {
        this.id = id;
    }

    public BasicQuestions(Integer id, String questionbody, String answer1, String answer2, String answer3, String answer4, Character correctanswer) {
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
        if (!(object instanceof BasicQuestions)) {
            return false;
        }
        BasicQuestions other = (BasicQuestions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "com.klsoukas.mavenproject8.model.BasicQuestions[ id=" + id + " ]";
    }




    
}
