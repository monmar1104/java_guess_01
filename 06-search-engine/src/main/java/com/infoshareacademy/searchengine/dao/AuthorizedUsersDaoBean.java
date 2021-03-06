package com.infoshareacademy.searchengine.dao;

import org.jboss.crypto.CryptoUtil;
import org.jboss.security.auth.spi.Users;
import org.wildfly.security.authz.Roles;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//TODO dodawanie użytkowników do tabel users i roles
//TODO rozwiązać problem dwóch persistence unit
@Stateless
public class AuthorizedUsersDaoBean implements AuthorizedUsersDao {

//    @PersistenceContext(unitName = "pUnitAuth")
//    EntityManager entityManager;

    @Override
    public void addAuthorizedUser(Users users, Roles roles){
//        entityManager.persist(users);
//        entityManager.persist(roles);
    }

    @Override
    public String getHexPassword(String password){
        return CryptoUtil.createPasswordHash("MD5", "hex", null, null, password);
    }
}
