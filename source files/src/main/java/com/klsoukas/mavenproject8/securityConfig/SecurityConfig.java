
package com.klsoukas.mavenproject8.securityConfig;

import com.klsoukas.mavenproject8.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
        @Autowired
        private AuthenticationService authenticationService;
    
        //AUTHENTICATION
        @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

//            ShaPasswordEncoder encoder = new ShaPasswordEncoder();
//            auth.userDetailsService(authenticationService).passwordEncoder(encoder);
            
            auth.userDetailsService(authenticationService);
	}
        
        //AUTHORIZATION using authentication info
    	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().

                antMatchers("/home/**").authenticated().
                antMatchers(HttpMethod.POST, "/submit_quiz/**").authenticated().
                antMatchers("/quiz_results/**").authenticated().
                antMatchers("/view_stats/**").authenticated().
		antMatchers(HttpMethod.GET, "/beginner_quiz/**").hasAnyRole("Beginner,Intermediate, Advanced, Master").
                antMatchers(HttpMethod.GET, "/intermediate_quiz/**").hasAnyRole("Intermediate, Advanced, Master").
                antMatchers(HttpMethod.GET, "/advanced_quiz/**").hasAnyRole("Advanced, Master").
//                        antMatchers("/").authenticated().
                and().
                exceptionHandling().accessDeniedPage("/home?access_denied=true").//error handling for access denied( if user is already authenticated but has no privileges)
                            //the exception is forwarded here not redirected like in failureUrl in login, the spring is removing the parameter if it doesnt have a value unlike when redirecting like login?someparam here we are forwarding so we need to put a value in /home?someparam=somevalue otherwise if i only have /home?someparam spring will not parse it/ recognize it as a valid empty "" but will take it as null!!!
                        //there is no rule in whether a query param should have a value, some implementations parse it as null if it doesnt have a value some parse it as empty string
                        
		and().formLogin().  //login configuration
                loginPage("/login").
                loginProcessingUrl("/appLogin").
                usernameParameter("username").
                passwordParameter("password").
                defaultSuccessUrl("/home").	
                failureUrl("/login?bad_credentials"). // default is /login?error
                        
		and().logout().    //logout configuration
		logoutUrl("/appLogout"). 
		logoutSuccessUrl("/login");
                
                
                http.csrf().disable();
                
	} 

}
