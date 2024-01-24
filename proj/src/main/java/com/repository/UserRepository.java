package com.repository;

import com.model.User;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    @Autowired
    private org.hibernate.Session session;

    public UserRepository(){

    }

    public void add(User user){
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
    }

    public User findLogin(String username, String password){
        String statement = "FROM User WHERE username = :username AND password = :password";
        Query query = session.createQuery(statement).setParameter("username", username).setParameter("password", password);
        User user = (User) query.list().get(0);
        return user;
    }
    public User findByName(String username) {
        String statement = "FROM User WHERE username LIKE :username";
        Query query = session.createQuery(statement).setParameter("username", username);
        User user = (User) query.list().get(0);
        return user;
    }


    public List<User> getAll(){
       return new ArrayList<>();
    }

    public void delete(String name){

    }

}