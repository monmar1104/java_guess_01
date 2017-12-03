package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.repository.UsersRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserRepositoryDaoBean implements UsersRepositoryDao, UsersRepositoryDaoRemote {

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        UsersRepository.getRepository().add(user);
    }

    @Override
    public User getUserById(int id) {
        List<User> userList = UsersRepository.getRepository();
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }

        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        List<User> userList = UsersRepository.getRepository();
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUserList() {
        return UsersRepository.getRepository();
    }

    @Override
    public List<String> getUsersNames(){
        List<String> usersNames = new ArrayList<>();
        for(User user : UsersRepository.getRepository()){
            usersNames.add(user.getName());
        }
        return usersNames;
    }
}
