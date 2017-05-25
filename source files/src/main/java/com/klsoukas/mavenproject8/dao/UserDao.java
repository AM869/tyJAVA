
package com.klsoukas.mavenproject8.dao;

import com.klsoukas.mavenproject8.model.RegisteredUsers;
import java.util.List;

public interface UserDao {
    
    RegisteredUsers createUser(RegisteredUsers userToBeCreated);         //CREATE    (return void?)
    
    
    List<RegisteredUsers> findAllUsers();                                //READ
    RegisteredUsers findUserByUsername(String Username);                       //READ
    
    RegisteredUsers findUserById(Integer id);
    
    RegisteredUsers updateUser(RegisteredUsers userToBeUpdated);         //UPDATE    (return void?)
    
    boolean removeUser(RegisteredUsers userTobeRemoved);                 //DELETE    (return void?)
    
}
