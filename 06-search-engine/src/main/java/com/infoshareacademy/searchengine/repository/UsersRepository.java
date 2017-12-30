package com.infoshareacademy.searchengine.repository;

import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.Stateless;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UsersRepository {
    @PersistenceContext(unitName = "pUnit")
    EntityManager entityManager;

    public boolean addUser(User user){
        entityManager.persist(user);
        return true;
    }

    public User getUserById(int id){
        return entityManager.find(User.class, id);
    }

    public User getUserByLogin(String login){
        return (User) entityManager.createNamedQuery("selectUserByLogin")
                .setParameter("login",login)
                .getSingleResult();
    }

    public List<User> getUsersList(){
        return entityManager.createNamedQuery("selectAll")
                .getResultList();
    }

    public void updateUser(User user){
        entityManager.createNamedQuery("updateUser")
                .setParameter("id",user.getId())
                .setParameter("name", user.getName())
                .setParameter("surname", user.getSurname())
                .setParameter("login", user.getLogin())
                .setParameter("age", user.getAge())
                .setParameter("gender", user.getGender())
                .executeUpdate();
    }
}
