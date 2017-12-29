package com.infoshareacademy.searchengine.dao;

import org.jboss.security.auth.spi.Users;
import org.wildfly.security.authz.Roles;

import javax.ejb.Local;

@Local
public interface AuthorizedUsersDao {

    void addAuthorizedUser(Users users, Roles roles);
    String getHexPassword(String password);

}
