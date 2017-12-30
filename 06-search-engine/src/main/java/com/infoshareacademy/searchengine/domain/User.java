package com.infoshareacademy.searchengine.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "selectUserByLogin", query = "from User where login=:login"),
        @NamedQuery(name = "selectAll", query = "from User "),
        @NamedQuery(name = "updateUser", query = "update User u set u.name=:name, u.surname=:surname,u.age=:age,u.login=:login, u.gender=:gender where u.id=:id")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private int id;
    @Column
    private String name;
    private String surname;
    private String login;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int hashCode(){
        return this.id;
    }

    public boolean equals(Object o){
        if(o instanceof User){
            User other = (User) o;
            return this.id == other.id;
        }
        return false;
    }
}