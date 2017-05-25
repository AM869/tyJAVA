
package com.klsoukas.mavenproject8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.klsoukas.mavenproject8.model.RegisteredUsers;
import com.klsoukas.mavenproject8.dao.UserDao;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;


@Service
public class AuthenticationService implements UserDetailsService {
    
	@Autowired
	private UserDao userDao;
        
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		RegisteredUsers user = userDao.findUserByUsername(username);
                                
                if(user == null)
                    throw new UsernameNotFoundException("User not found");
                
                
//		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+user.getRank());//have to put role here so this authority can be treated as role
                
//		UserDetails userDetails = (UserDetails)new User(user.getUsername(), 
//				user.getPassword(), Arrays.asList(authority));

                UserDetails userDetails = user;  // we customized model RegisteredUsers to extend spring's User class which also implements spring's UserDetails interface


		return userDetails; //return authentication(valid username and password) together with roles and/or authorities in the form of spring's UserDetails
	}
} 