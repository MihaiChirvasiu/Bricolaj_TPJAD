package com.repository;

import com.model.Product;
import com.util.SessionDB;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


@Component
public class ProductRepository {
    @Autowired
    private org.hibernate.Session session;

    public ProductRepository(){
        session = SessionDB.getSession();
    }

    public void add(Product product){
        session.beginTransaction();
        session.persist(product);
        session.getTransaction().commit();
    }

    public Product findByName(String name){
        String statement = "FROM Product WHERE name LIKE :name";
        Query query = session.createQuery(statement).setParameter("name", name);
        Product product = (Product) query.list().get(0);
        return product;
    }

    public void updateQuantity(String name, int newQuantity){
        Product product = findByName(name);
        product.setQuantity(newQuantity);
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
    }

    public List<Product> getAll(){
        String statement = "FROM Product";
        Query query = session.createQuery(statement);
        List<Product> productList = new ArrayList<>();
        for(int i = 0; i < query.list().size(); i++){
            productList.add((Product) query.list().get(i));
        }
        return productList;
    }

    public void delete(String name){

    }

}
