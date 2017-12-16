package com.infoshareacademy.searchengine.interceptors;

import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class AddUserInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        Object[] parameters = context.getParameters();
        User user = (User) parameters[0];

        if (user.getName().endsWith("a")){
        user.setGender(Gender.WOMAN);
        }
        else {user.setGender(Gender.MAN);
        }

        return context.proceed();
    }
}
