
package com.klsoukas.mavenproject8.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "registered_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegisteredUsers.findAll", query = "SELECT r FROM RegisteredUsers r")
    , @NamedQuery(name = "RegisteredUsers.findById", query = "SELECT r FROM RegisteredUsers r WHERE r.id = :id")
    , @NamedQuery(name = "RegisteredUsers.findByUsername", query = "SELECT r FROM RegisteredUsers r WHERE r.username = :username")
    , @NamedQuery(name = "RegisteredUsers.findByPassword", query = "SELECT r FROM RegisteredUsers r WHERE r.password = :password")
    , @NamedQuery(name = "RegisteredUsers.findByEmail", query = "SELECT r FROM RegisteredUsers r WHERE r.email = :email")
    , @NamedQuery(name = "RegisteredUsers.findByMean1", query = "SELECT r FROM RegisteredUsers r WHERE r.mean1 = :mean1")
    , @NamedQuery(name = "RegisteredUsers.findByMean2", query = "SELECT r FROM RegisteredUsers r WHERE r.mean2 = :mean2")
    , @NamedQuery(name = "RegisteredUsers.findByMean3", query = "SELECT r FROM RegisteredUsers r WHERE r.mean3 = :mean3")
    , @NamedQuery(name = "RegisteredUsers.findByRank", query = "SELECT r FROM RegisteredUsers r WHERE r.rank = :rank")
    , @NamedQuery(name = "RegisteredUsers.findByCount1", query = "SELECT r FROM RegisteredUsers r WHERE r.count1 = :count1")
    , @NamedQuery(name = "RegisteredUsers.findByCount2", query = "SELECT r FROM RegisteredUsers r WHERE r.count2 = :count2")
    , @NamedQuery(name = "RegisteredUsers.findByCount3", query = "SELECT r FROM RegisteredUsers r WHERE r.count3 = :count3")})
public class RegisteredUsers implements UserDetails, Serializable {
//spring class "User" implements UserDetails and here we just extend spring's "User" class
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mean1")
    private float mean1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mean2")
    private float mean2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mean3")
    private float mean3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "rank")
    private String rank;
    @Basic(optional = false)
    @NotNull
    @Column(name = "count1")
    private int count1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "count2")
    private int count2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "count3")
    private int count3;

    
    @Transient
    private String lastQuizType;

    
    public String getLastQuizType() {
        return lastQuizType;
    }

    public void setLastQuizType(String lastQuizType) {
        this.lastQuizType = lastQuizType;
    }
    
    
    public RegisteredUsers() {
//        super("guest","guest",Arrays.asList(new SimpleGrantedAuthority("ROLE_Intermediate")));
    }

    public RegisteredUsers(Integer id) {
//        super("guest","guest",Arrays.asList(new SimpleGrantedAuthority("ROLE_Beginner")));
        this.id = id;
    }

    public RegisteredUsers(Integer id, String username, String password, String email, float mean1, float mean2, float mean3, String rank, int count1, int count2, int count3) {
//        super(username,password,Arrays.asList(new SimpleGrantedAuthority("ROLE_"+rank)));
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mean1 = mean1;
        this.mean2 = mean2;
        this.mean3 = mean3;
        this.rank = rank;
        this.count1 = count1;
        this.count2 = count2;
        this.count3 = count3;
    }

    public RegisteredUsers(String username, String password, String email, float mean1, float mean2, float mean3, String rank, int count1, int count2, int count3) {
//        super(username,password,Arrays.asList(new SimpleGrantedAuthority("ROLE_"+rank)));

        this.username = username;
        this.password = password;
        this.email = email;
        this.mean1 = mean1;
        this.mean2 = mean2;
        this.mean3 = mean3;
        this.rank = rank;
        this.count1 = count1;
        this.count2 = count2;
        this.count3 = count3;
    }
    
    
    public RegisteredUsers(String username, String password, String email) {
//        super(username,password,Arrays.asList(new SimpleGrantedAuthority("ROLE_Beginner")));

        this.username = username;
        this.password = password;
        this.email = email;
        this.mean1 = 0;
        this.mean2 = 0;
        this.mean3 = 0;
        this.rank = "Beginner";
        this.count1 = 0;
        this.count2 = 0;
        this.count3 = 0;
    }    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getMean1() {
        return mean1;
    }

    public void setMean1(float mean1) {
        this.mean1 = mean1;
    }

    public float getMean2() {
        return mean2;
    }

    public void setMean2(float mean2) {
        this.mean2 = mean2;
    }

    public float getMean3() {
        return mean3;
    }

    public void setMean3(float mean3) {
        this.mean3 = mean3;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public int getCount2() {
        return count2;
    }

    public void setCount2(int count2) {
        this.count2 = count2;
    }

    public int getCount3() {
        return count3;
    }

    public void setCount3(int count3) {
        this.count3 = count3;
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
        if (!(object instanceof RegisteredUsers)) {
            return false;
        }
        RegisteredUsers other = (RegisteredUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.klsoukas.mavenproject8.model.RegisteredUsers[ id=" + id + " ]";
    }
    
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>(1);
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+getRank());
        authorities.add(authority);
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
