/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fudn.dao;

import edu.fudn.entities.Category;
import edu.fudn.helpers.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author SuongNTM
 */
public class CategoryDao {
    public Category insertCategory(Category entity) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction trans = session.beginTransaction();
        
        try {
            session.persist(entity);
            trans.commit();//hoàn tất các thay đổi trong cơ sở dữ liệu
            
            return entity;
        } catch (Exception ex) {
            trans.rollback(); //có lỗi xảy ra thì rollback xử lý không lưu dữ liệu trở lại (không có thay đổi cơ sở dữ liệu)
            throw  ex;
        }
    }
    
    public Category updateCategory(Category entity) throws Exception{
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
    
    public void deleteCategory(int id) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction trans = session.beginTransaction();
        
        try {
            Category entity = (Category) session.load(Category.class, id);
            
            session.delete(entity);
            
            trans.commit();
            
        } catch (Exception e) {
            trans.rollback(); //có lỗi xảy ra thì rollback xử lý không lưu dữ liệu trở lại (không có thay đổi cơ sở dữ liệu)
            throw  e;
        }
    }
    
    public Category findCategoryById(int id) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
                
        try {
            Category entity = (Category) session.load(Category.class, id);
            
            return entity;
        } catch (Exception e) {
            throw  e;
        }
    }
    
    public List<Category> findAllCategories() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            String hql = "FROM Category";
            Query query = session.createQuery(hql);
            
            return query.list();
        } catch (Exception e) {
            throw  e;
        }
    }
    
    public List<Category> findCategoriesByName(String name) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            String hql = "FROM Category WHERE name like :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            
            return query.list();
        } catch (Exception e) {
            throw  e;
        }
    }
}
