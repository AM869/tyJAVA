
package com.klsoukas.mavenproject8.dao;

import com.klsoukas.mavenproject8.model.RegisteredUsers;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext(unitName = "PU1")
    EntityManager em;

    
    @Override
    public RegisteredUsers createUser(RegisteredUsers userToBeCreated) {
        em.persist(userToBeCreated);
        return userToBeCreated;
    }

    @Override
    public List<RegisteredUsers> findAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public RegisteredUsers findUserById(Integer id) {
        return em.find(RegisteredUsers.class, id);
    }

    @Override
    public RegisteredUsers updateUser(RegisteredUsers userToBeUpdated) {
        return em.merge(userToBeUpdated);
    }

    @Override
    public boolean removeUser(RegisteredUsers userTobeRemoved) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RegisteredUsers findUserByUsername(String username) {
        RegisteredUsers user = (RegisteredUsers)em.createNamedQuery("RegisteredUsers.findByUsername").setParameter("username",username).getSingleResult();
//          RegisteredUsers user = em.createNamedQuery("RegisteredUsers.findByUsername", RegisteredUsers.class).setParameter("username",username).getSingleResult();
        return user;
    }


    
}
