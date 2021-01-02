/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fudn.dao;

import edu.fudn.entities.Product;
import edu.fudn.helpers.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author SuongNTM
 */
public class ProductDao {
    public Product insertProduct(Product entity) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction trans = session.beginTransaction();
        
        try {
            session.persist(entity);
            trans.commit();
            
            return entity;
        } catch (Exception e) {
            trans.rollback(); //có lỗi xảy ra thì rollback xử lý không lưu dữ liệu trở lại (không có thay đổi cơ sở dữ liệu)
            throw  e;
        }
    }
    
    public Product updateProduct(Product entity) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction trans = session.beginTransaction();
        
        try {
            session.saveOrUpdate(entity);
            trans.commit();
            
            return entity;
        } catch (Exception e) {
            trans.rollback(); //có lỗi xảy ra thì rollback xử lý không lưu dữ liệu trở lại (không có thay đổi cơ sở dữ liệu)
            throw  e;
        }
    }
    
    public void deleteProduct(int id) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction trans = session.beginTransaction();
        
        try {
            Product entity = (Product) session.load(Product.class, id);
            
            session.delete(entity);
            
            trans.commit();
            
        } catch (Exception e) {
            trans.rollback(); //có lỗi xảy ra thì rollback xử lý không lưu dữ liệu trở lại (không có thay đổi cơ sở dữ liệu)
            throw  e;
        }
    }
    
    public Product findProductById(int id) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
                
        try {
            Product entity = (Product) session.load(Product.class, id);
            
            return entity;
        } catch (Exception e) {
            throw  e;
        }
    }
    
    public List<Product> findAllProducts() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            String hql = "FROM Product";
            Query query = session.createQuery(hql);
            
            return query.list();
        } catch (Exception e) {
            throw  e;
        }
    }
    
    public List<Product> findProductsByName(String name) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            String hql = "FROM Product WHERE name like :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            
            return query.list();
        } catch (Exception e) {
            throw  e;
        }
    }
}
