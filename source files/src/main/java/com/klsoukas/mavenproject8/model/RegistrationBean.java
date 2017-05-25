
package com.klsoukas.mavenproject8.model;

import com.klsoukas.mavenproject8.customValidation.Matches;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Matches.List(
        {
            @Matches(field="password", verifyField="confirmPassword"), 
            @Matches(field="email", verifyField="confirmEmail")
        }
)
public class RegistrationBean {
    
    @Size(min=2, max=30)
    private String username;
    
    @Size(min=4, max=30)
    private String password;
    
    @Size(min=4, max=30)
    private String confirmPassword;
    
    @NotEmpty @Email
    private String email;
    
    @NotEmpty @Email
    private String confirmEmail;

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String retypedPassword) {
        this.confirmPassword = retypedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
